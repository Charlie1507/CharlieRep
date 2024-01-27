package com.silva.app.p3cams.contollers;

import com.silva.app.p3cams.models.Inquilino;
import com.silva.app.p3cams.models.Mantenimiento;
import com.silva.app.p3cams.services.IMantenimientoService;
import com.silva.app.p3cams.services.IService;
import com.silva.app.p3cams.services.InquilinosService;
import com.silva.app.p3cams.services.MantenimientosService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

@WebServlet("/mantenimientos/eliminar")
public class EliminarMantenimientosServlet  extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Connection conn = (Connection) req.getAttribute("conn");
        IMantenimientoService service = new MantenimientosService(conn);
        long id;
        try
        {
            id = Long.parseLong(req.getParameter("id"));
        }
        catch(NumberFormatException e)
        {
            id = 0L;
        }
        Mantenimiento mantenimiento = new Mantenimiento();
        if (  id>0L)
        {
            Optional<Mantenimiento> o = service.getById(id);
            if(o.isPresent())
            {
                service.eliminar(id);
                resp.sendRedirect(req.getContextPath() + "/mantenimientos/listar");
            }
            else
            {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "No existe el mantenimiento en la base de datos!");
            }
        }
        else
        {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Error el id en null, se debe enviar como parametro en la url!");
        }
    }
}
