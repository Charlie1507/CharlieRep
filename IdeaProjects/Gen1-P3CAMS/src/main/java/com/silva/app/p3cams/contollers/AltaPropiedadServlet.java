package com.silva.app.p3cams.contollers;

import com.silva.app.p3cams.models.Duenio;
import com.silva.app.p3cams.models.Propiedad;
import com.silva.app.p3cams.models.enums.TipoPropiedad;
import com.silva.app.p3cams.services.IPropiedadService;
import com.silva.app.p3cams.services.IService;
import com.silva.app.p3cams.services.PropiedadesService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/propiedades/alta")
public class AltaPropiedadServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Connection conn = (Connection) req.getAttribute("conn");
        IPropiedadService service = new PropiedadesService(conn);
        TipoPropiedad[] tipos = TipoPropiedad.values();

        req.setAttribute("duenios", service.listarDuenios());
        req.setAttribute("tipos", tipos);
        getServletContext().getRequestDispatcher("/altaPropiedad.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Connection conn = (Connection) req.getAttribute("conn");
        IService<Propiedad> service = new PropiedadesService(conn);


        String direccion = req.getParameter("direccion");
        String duenioId = req.getParameter("duenioId");
        String tipoProp = req.getParameter("tipoProp");
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


        Propiedad propiedad = new Propiedad();
        propiedad.setId(0L);
        propiedad.setDireccion(direccion);
        propiedad.setDuenioId(Long.parseLong(duenioId));
        propiedad.setDisponibilidad(habilitar);
        propiedad.setTipoPropiedad(tipoProp);
        propiedad.setPrecio(Float.parseFloat(precio));
        service.guardar(propiedad);
        resp.sendRedirect(req.getContextPath() + "/propiedades/listar");

    }
}
