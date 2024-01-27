package com.silva.app.p3cams.contollers;

import com.silva.app.p3cams.models.Duenio;
import com.silva.app.p3cams.models.Mantenimiento;
import com.silva.app.p3cams.models.Propiedad;
import com.silva.app.p3cams.services.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

@WebServlet("/mantenimientos/detalle")
public class DetalleMantenimiento extends HttpServlet
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
                mantenimiento = o.get();
                long propiedadId = mantenimiento.getPropiedadId();
                IService<Propiedad> propiedadService = new PropiedadesService(conn);
                Optional<Propiedad> propiedadOptional = propiedadService.getById(propiedadId);
                if (propiedadOptional.isPresent()) {
                    Propiedad propiedad = propiedadOptional.get();
                    req.setAttribute("propiedad", propiedad);
                } else {
                    // Manejar el caso en el que no se puede encontrar la propiedad
                    resp.sendError(HttpServletResponse.SC_NOT_FOUND, "No se puede encontrar la propiedad asociada al mantenimiento");
                    return;
                }

                req.setAttribute("mantenimiento", mantenimiento);
                getServletContext().getRequestDispatcher("/detalleMantenimiento.jsp").forward(req, resp);
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
