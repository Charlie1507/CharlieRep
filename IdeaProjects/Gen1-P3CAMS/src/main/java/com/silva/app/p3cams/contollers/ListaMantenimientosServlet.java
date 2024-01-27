package com.silva.app.p3cams.contollers;


import com.silva.app.p3cams.models.Duenio;
import com.silva.app.p3cams.models.Mantenimiento;
import com.silva.app.p3cams.models.Propiedad;
import com.silva.app.p3cams.services.DueniosService;
import com.silva.app.p3cams.services.IMantenimientoService;
import com.silva.app.p3cams.services.IService;
import com.silva.app.p3cams.services.MantenimientosService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/mantenimientos/listar")
public class ListaMantenimientosServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Connection conn = (Connection) req.getAttribute("conn");


        IMantenimientoService service = new MantenimientosService(conn);
        List<Mantenimiento> mantenimientos = service.listar();
        List<Propiedad> propiedades = service.listarPropiedades();

        // Agregar la información de las propiedades a cada mantenimiento
        for (Mantenimiento mantenimiento : mantenimientos) {
            for (Propiedad propiedad : propiedades) {
                if (mantenimiento.getPropiedadId() == propiedad.getId()) {
                    mantenimiento.setDireccionPropiedad(propiedad.getDireccion());
                    break;
                }
            }
        }

        req.setAttribute("mantenimientos", mantenimientos);

        getServletContext().getRequestDispatcher("/listaMantenimientos.jsp").forward(req,resp);
    }
}
