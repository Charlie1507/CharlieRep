package com.silva.app.rutas.controllers;

import com.google.gson.Gson;
import com.silva.app.rutas.models.Cargamento;
import com.silva.app.rutas.models.Chofer;
import com.silva.app.rutas.models.Ruta;
import com.silva.app.rutas.services.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/rutas/alta")
public class AltaRutaServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

        Connection conn = (Connection) req.getAttribute("conn");
        IRutasService service = new RutasService(conn);
        req.setAttribute("camiones", service.listarCamiones());
        req.setAttribute("choferes", service.listarChoferes());

        HttpSession session = req.getSession();
        List<Cargamento> cargamentos = (List<Cargamento>) session.getAttribute("cargamentos");
        req.setAttribute("cargamentos", cargamentos);

        getServletContext().getRequestDispatcher("/altaRuta.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Connection conn = (Connection) req.getAttribute("conn");
        IRutasService service = new RutasService(conn);

        String choferId = req.getParameter("choferId");
        String origenId = req.getParameter("origenId");
        String fSalida = req.getParameter("fSalida");
        String distancia = req.getParameter("distancia");
        String camionId = req.getParameter("camionId");
        String destinoId = req.getParameter("destinoId");
        String capCamion = req.getParameter("capCamion");
        String fLlegada = req.getParameter("fLlegada");

        LocalDate fechasal=LocalDate.parse(fSalida);
        String fFormateadaSal = fechasal.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate fechaleg=LocalDate.parse(fLlegada);
        String fFormateadaLleg = fechaleg.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        LocalDate fechaSal;
        LocalDate fechaLleg;
        try
        {
            fechaSal = LocalDate.parse(fFormateadaSal, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        catch (DateTimeParseException e)
        {
            fechaSal = null;
        }
        try
        {
            fechaLleg = LocalDate.parse(fFormateadaLleg, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        catch (DateTimeParseException e)
        {
            fechaLleg = null;
        }

        Ruta ruta= new Ruta();
        ruta.setId(0L);
        ruta.setCamionId(Long.parseLong(camionId));
        ruta.setChoferId(Long.parseLong(choferId));
        ruta.setDireccionOrigenId(Long.parseLong(origenId));
        ruta.setDireccionDestinoId(Long.parseLong(destinoId));
        ruta.setDistancia(Float.parseFloat(distancia));
        ruta.setFechaSalida(fechaSal);
        ruta.setFechaLlegadaEstimada(fechaLleg);
        ruta.setFechaLlegadaReal(fechaLleg);
        ruta.setaTiempo(1);

        resp.setContentType("application/json");
        Map<String, String> respuesta = new HashMap<>();
        if (choferId == null || origenId==null || fSalida == null || distancia==null || camionId== null || destinoId==null || capCamion==null || fLlegada==null)
        {
            try(PrintWriter out = resp.getWriter())
            {
                resp.setStatus(400);
                respuesta.put("message", "Debes ingresar todos los valores");
                respuesta.put("status", "error");
                String json = new Gson().toJson(respuesta);
                out.print(json);
            }
        }
        else
        {
            Long id = service.guardarReturnId(ruta);
            try (PrintWriter out = resp.getWriter())
            {
                resp.setStatus(201);
                respuesta.put("message", id.toString());
                respuesta.put("status", "success");
                String json = new Gson().toJson(respuesta);
                out.print(json);
            }
        }



    }
}
