package com.silva.app.p3cams.contollers;

import com.silva.app.p3cams.models.Inquilino;
import com.silva.app.p3cams.models.Propiedad;
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
import java.util.List;

@WebServlet("/propiedades/listar")
public class ListaPropiedadesServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Connection conn = (Connection) req.getAttribute("conn");


        IService<Propiedad> service = new PropiedadesService(conn);
        List<Propiedad> propiedades = service.listar();

        req.setAttribute("propiedades", propiedades);

        getServletContext().getRequestDispatcher("/listaPropiedades.jsp").forward(req,resp);
    }
}
