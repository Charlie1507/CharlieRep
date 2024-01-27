package com.silva.app.p3cams.contollers;


import com.silva.app.p3cams.models.Duenio;
import com.silva.app.p3cams.services.DueniosService;
import com.silva.app.p3cams.services.IService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/duenios/alta")
public class AltaDuenioServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        getServletContext().getRequestDispatcher("/altaDuenio.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Connection conn = (Connection) req.getAttribute("conn");
        IService<Duenio> service = new DueniosService(conn);

        String nombre = req.getParameter("nombre");
        String apPaterno = req.getParameter("apPaterno");
        String apMaterno = req.getParameter("apMaterno");
        String telefono = req.getParameter("telefono");
        String cuenta = req.getParameter("cuenta");


        Map<String, String> errores = new HashMap<>();
        if(nombre == null || nombre.isBlank())
        {
            errores.put("nombre", "El nombre es requerido!");
        }
        if(apPaterno == null || apPaterno.isBlank())
        {
            errores.put("apPaterno", "El apellido paterno es requerido!");
        }
        if(apMaterno == null || apMaterno.isBlank())
        {
            errores.put("apMaterno", "El nombre es requerido!");
        }
        if(telefono==null || telefono.isBlank())
        {
            errores.put("telefono", "el telefono es requerido");
        }
        else
        {
            String telefonoRegex="\\d{10}";
            if(!telefono.matches(telefonoRegex))
            {
                errores.put("telefono", "el numero de telefono debe tener exactamente 10 digitos");
            }
        }
        if(cuenta == null || cuenta.isBlank())
        {
            errores.put("cuenta", "La cuenta es requerida!");
        }
        if(errores.isEmpty())
        {
            Duenio duenio= new Duenio();
            duenio.setId(0L);
            duenio.setNombre(nombre);
            duenio.setApPaterno(apPaterno);
            duenio.setApMaterno(apMaterno);
            duenio.setTelefono(telefono);
            duenio.setCuenta(cuenta);
            service.guardar(duenio);
            resp.sendRedirect(req.getContextPath() + "/duenios/listar");
        }
        else
        {
            req.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("/altaDuenio.jsp").forward(req, resp);
        }
    }

}
