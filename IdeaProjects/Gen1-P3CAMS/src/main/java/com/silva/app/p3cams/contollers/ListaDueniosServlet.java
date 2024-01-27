package com.silva.app.p3cams.contollers;

import com.silva.app.p3cams.models.Duenio;
import com.silva.app.p3cams.services.DueniosService;
import com.silva.app.p3cams.services.IService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/duenios/listar")
public class ListaDueniosServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Connection conn = (Connection) req.getAttribute("conn");


        IService<Duenio> service = new DueniosService(conn);
        List<Duenio> duenios = service.listar();

        req.setAttribute("duenios", duenios);
        getServletContext().getRequestDispatcher("/listaDuenios.jsp").forward(req,resp);
    }
}
