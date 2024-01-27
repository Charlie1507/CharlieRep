package com.silva.app.rutas.controllers;

import com.silva.app.rutas.models.Camion;
import com.silva.app.rutas.models.Chofer;
import com.silva.app.rutas.models.enums.Marcas;
import com.silva.app.rutas.models.enums.Tipos;
import com.silva.app.rutas.services.CamionesService;
import com.silva.app.rutas.services.IService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;


@WebServlet("/camiones/alta")
public class AltaCamionServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

        Calendar l = new GregorianCalendar();
        Integer[] annios = new Integer[22];
        String [] anniosS = new String[22];
        int c =0;
        for (int i = -20; i < 2; i++)
        {
            annios[c]= (l.get(Calendar.YEAR))+i;
            c++;
        }
        c=0;

        for(Integer n : annios)
        {
            anniosS[c]= String.valueOf(n);
            c++;
        }

        Marcas[] marcas= Marcas.values();
        Tipos[] tipos = Tipos.values();
        req.setAttribute("tipos", tipos);
        req.setAttribute("marcas", marcas);
        req.setAttribute("annios", anniosS);




        getServletContext().getRequestDispatcher("/altaCamion.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Connection conn = (Connection) req.getAttribute("conn");
        IService<Camion> service = new CamionesService(conn);

        String matricula = req.getParameter("matricula");
        String tipoCamion = req.getParameter("tipoCamion");
        String modelo = req.getParameter("modelo");
        String marca = req.getParameter("marca");
        String capacidad = req.getParameter("capacidad");
        String kilometraje = req.getParameter("kilometraje");



        String checkbox[];
        checkbox = req.getParameterValues("disponibilidad");
        Boolean habilitar;
        if(checkbox != null)
        {
            habilitar = true;
        }
        else
        {
            habilitar = false;
        }
        Map<String, String> errores = new HashMap<>();
        if(matricula == null || matricula.isBlank())
        {
            errores.put("matricula", "la matricula es requerida!");
        }
        if(tipoCamion == null || tipoCamion.isBlank())
        {
            errores.put("tipoCamion", "el tipo de camion es requerido!");
        }
        if(modelo == null || modelo.isBlank())
        {
            errores.put("modelo", "el modelo es requerido!");
        }
        if(marca == null || marca.isBlank())
        {
            errores.put("marca", "la marca es requerida!");
        }
        if(capacidad == null || capacidad.isBlank())
        {
            errores.put("capacidad", "la capacidad es requerida!");
        }
        if(kilometraje == null || kilometraje.isBlank())
        {
            errores.put("kilometraje", "el kilometraje es requerido!");
        }
        if(errores.isEmpty())
        {
            Camion camion= new Camion();
            camion.setId(0L);
            camion.setMatricula(matricula);
            camion.setTipoCamion(tipoCamion);
            camion.setModelo(Integer.parseInt(modelo));
            camion.setMarca(marca);
            camion.setCapaciad(Integer.parseInt(capacidad));
            camion.setKilometraje(Float.parseFloat(kilometraje));
            camion.setDisponibilidad(habilitar);
            service.guardar(camion);
            resp.sendRedirect(req.getContextPath() + "/camiones/listar");
        }
        else
        {
            req.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("/altaCamion.jsp").forward(req, resp);
        }
    }
}

