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
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@WebServlet("/duenios/editar")
public class EditarDuenioServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Connection conn = (Connection) req.getAttribute("conn");
        IService<Duenio> service = new DueniosService(conn);
        long id;
        try
        {
            id = Long.parseLong(req.getParameter("id"));
        }
        catch(NumberFormatException e)
        {
            id = 0L;
        }
        Duenio duenio = new Duenio();
        if (  id>0L)
        {
            Optional<Duenio> o = service.getById(id);
            if(o.isPresent())
            {
                duenio = o.get();
                req.setAttribute("duenio", duenio);
                getServletContext().getRequestDispatcher("/edicionDuenio.jsp").forward(req, resp);
            }
            else
            {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "No existe el dueño en la base de datos!");
            }
        }
        else
        {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Error el id en null, se debe enviar como parametro en la url!");
        }
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
        long id;
        id = Long.parseLong(req.getParameter("id"));
        Duenio duenio= new Duenio();
        duenio.setId(id);
        duenio.setNombre(nombre);
        duenio.setApPaterno(apPaterno);
        duenio.setApMaterno(apMaterno);
        duenio.setTelefono(telefono);
        duenio.setCuenta(cuenta);

        if(errores.isEmpty())
        {

            service.guardar(duenio);
            resp.sendRedirect(req.getContextPath() + "/duenios/listar");
        }
        else
        {
            req.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("/edicionDuenio.jsp").forward(req, resp);
        }
    }
}
