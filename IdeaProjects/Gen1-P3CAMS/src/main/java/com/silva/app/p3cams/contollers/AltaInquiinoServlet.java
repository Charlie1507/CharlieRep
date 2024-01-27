package com.silva.app.p3cams.contollers;

import com.silva.app.p3cams.models.Duenio;
import com.silva.app.p3cams.models.Inquilino;
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

@WebServlet("/inquilinos/alta")
public class AltaInquiinoServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        getServletContext().getRequestDispatcher("/altaInquilino.jsp").forward(req, resp);
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
            errores.put("cuenta", "La cuenta es requerida!");
        }
        if(errores.isEmpty())
        {
            Inquilino inquilino= new Inquilino();
            inquilino.setId(0L);
            inquilino.setNombre(nombre);
            inquilino.setApPaterno(apPaterno);
            inquilino.setApMaterno(apMaterno);
            inquilino.setTelefono(telefono);
            inquilino.setFechaPago(fechaPago);
            service.guardar(inquilino);
            resp.sendRedirect(req.getContextPath() + "/inquilinos/listar");
        }
        else
        {
            req.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("/altaInquilino.jsp").forward(req, resp);
        }
    }
}
