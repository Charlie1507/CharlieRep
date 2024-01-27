package com.silva.app.p3cams.contollers;

import com.silva.app.p3cams.models.Duenio;
import com.silva.app.p3cams.models.Inquilino;
import com.silva.app.p3cams.services.DueniosService;
import com.silva.app.p3cams.services.IService;
import com.silva.app.p3cams.services.InquilinosService;
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

@WebServlet("/inquilinos/editar")
public class EditarInquilinoServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Connection conn = (Connection) req.getAttribute("conn");
        IService<Inquilino> service = new InquilinosService(conn);
        long id;
        try
        {
            id = Long.parseLong(req.getParameter("id"));
        }
        catch(NumberFormatException e)
        {
            id = 0L;
        }
        Inquilino inquilino = new Inquilino();
        if (  id>0L)
        {
            Optional<Inquilino> o = service.getById(id);
            if(o.isPresent())
            {
                inquilino = o.get();
                req.setAttribute("inquilino", inquilino);
                getServletContext().getRequestDispatcher("/edicionInquilino.jsp").forward(req, resp);
            }
            else
            {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "No existe el inquilino en la base de datos!");
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
        IService<Inquilino> service = new InquilinosService(conn);

        String nombre = req.getParameter("nombre");
        String apPaterno = req.getParameter("apPaterno");
        String apMaterno = req.getParameter("apMaterno");
        String telefono = req.getParameter("telefono");
        String fechaPago = req.getParameter("fechaPago");


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
        if(fechaPago == null || fechaPago.isBlank())
        {
            errores.put("fechaPago", "La fecha de pago es requerida!");
        }
        long id;
        id = Long.parseLong(req.getParameter("id"));
        Inquilino inquilino= new Inquilino();
        inquilino.setId(id);
        inquilino.setNombre(nombre);
        inquilino.setApPaterno(apPaterno);
        inquilino.setApMaterno(apMaterno);
        inquilino.setTelefono(telefono);
        inquilino.setFechaPago(fechaPago);

        if(errores.isEmpty())
        {

            service.guardar(inquilino);
            resp.sendRedirect(req.getContextPath() + "/inquilinos/listar");
        }
        else
        {
            req.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("/edicionInquilino.jsp").forward(req, resp);
        }
    }
}
