package com.silva.app.p3cams.contollers;

import com.silva.app.p3cams.models.Inquilino;
import com.silva.app.p3cams.models.Propiedad;
import com.silva.app.p3cams.services.IPropiedadService;
import com.silva.app.p3cams.services.IService;
import com.silva.app.p3cams.services.InquilinosService;
import com.silva.app.p3cams.services.PropiedadesService;
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

@WebServlet("/propiedades/editar")
public class EditarPropiedadServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Connection conn = (Connection) req.getAttribute("conn");
        IPropiedadService service = new PropiedadesService(conn);
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
                getServletContext().getRequestDispatcher("/edicionPropiedad.jsp").forward(req, resp);
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Connection conn = (Connection) req.getAttribute("conn");
        IPropiedadService service = new PropiedadesService(conn);

        String direccion = req.getParameter("direccion");
        String duenioId = req.getParameter("duenioId");
        String tipoPropiedad = req.getParameter("tipoPropiedad");
        String precio = req.getParameter("precio");
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

        long id;
        id = Long.parseLong(req.getParameter("id"));
        Propiedad propiedad= new Propiedad();
        propiedad.setId(id);
        propiedad.setDireccion(direccion);
        propiedad.setDuenioId(Long.parseLong(duenioId));
        propiedad.setDisponibilidad(habilitar);
        propiedad.setTipoPropiedad(tipoPropiedad);
        propiedad.setPrecio(Float.parseFloat(precio));

        if(errores.isEmpty())
        {

            service.guardar(propiedad);
            resp.sendRedirect(req.getContextPath() + "/propiedades/listar");
        }
        else
        {
            req.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("/edicionPropiedad.jsp").forward(req, resp);
        }
    }
}
