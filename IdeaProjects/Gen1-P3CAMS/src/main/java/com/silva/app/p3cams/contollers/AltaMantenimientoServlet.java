package com.silva.app.p3cams.contollers;

import com.silva.app.p3cams.models.Mantenimiento;
import com.silva.app.p3cams.models.Propiedad;
import com.silva.app.p3cams.services.IMantenimientoService;
import com.silva.app.p3cams.services.IService;
import com.silva.app.p3cams.services.MantenimientosService;
import com.silva.app.p3cams.services.PropiedadesService;
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

@WebServlet("/mantenimientos/alta")
public class AltaMantenimientoServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Connection conn = (Connection) req.getAttribute("conn");
        IMantenimientoService service = new MantenimientosService(conn);

        req.setAttribute("propiedades", service.listarPropiedades());

        getServletContext().getRequestDispatcher("/altaMantenimiento.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Connection conn = (Connection) req.getAttribute("conn");
        IMantenimientoService service = new MantenimientosService(conn);


        String propiedadId = req.getParameter("propiedadId");
        String descripcion = req.getParameter("descripcion");
        String fechaReporte = req.getParameter("fechaReporte");
        String costo = req.getParameter("costo");

        LocalDate fecha2=LocalDate.parse(fechaReporte);
        String fechaFormateada = fecha2.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        LocalDate fecha;
        try
        {
            fecha = LocalDate.parse(fechaFormateada, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        catch (DateTimeParseException e)
        {
            fecha = null;
        }
        String checkbox[];
        checkbox = req.getParameterValues("finalizado");
        Boolean habilitar;
        if(checkbox != null)
        {
            habilitar = true;
        }
        else
        {
            habilitar = false;
        }

        Mantenimiento mantenimiento = new Mantenimiento();
        mantenimiento.setId(0L);
        mantenimiento.setPropiedadId(Long.parseLong(propiedadId));
        mantenimiento.setDescripcion(descripcion);
        mantenimiento.setFechaReporte(fecha);
        mantenimiento.setCosto(Float.parseFloat(costo));
        mantenimiento.setEstadoFinalizado(habilitar);
        service.guardar(mantenimiento);
        resp.sendRedirect(req.getContextPath() + "/mantenimientos/listar");
    }
}
