package com.silva.app.p3cams.contollers;

import com.silva.app.p3cams.models.Duenio;
import com.silva.app.p3cams.models.Mantenimiento;
import com.silva.app.p3cams.models.Propiedad;
import com.silva.app.p3cams.services.DueniosService;
import com.silva.app.p3cams.services.IService;
import com.silva.app.p3cams.services.PropiedadesService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;


@WebServlet("/propiedades/detalle")
public class DetallePropiedadServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Connection conn = (Connection) req.getAttribute("conn");
        IService<Propiedad> service = new PropiedadesService(conn);
        long id;
        try
        {
            id = Long.parseLong(req.getParameter("id"));
        }
        catch(NumberFormatException e)
        {
            id = 0L;
        }
        Propiedad propiedad = new Propiedad();
        if (  id>0L)
        {
            Optional<Propiedad> o = service.getById(id);
            if(o.isPresent())
            {
                propiedad = o.get();
                req.setAttribute("propiedad", propiedad);
                getServletContext().getRequestDispatcher("/detallePropiedad.jsp").forward(req, resp);
            }
            else
            {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "No existe la propiedad en la base de datos!");
            }
        }
        else
        {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Error el id en null, se debe enviar como parametro en la url!");
        }
    }
}
