package com.silva.app.p3cams.contollers;


import com.silva.app.p3cams.models.Duenio;
import com.silva.app.p3cams.models.Inquilino;
import com.silva.app.p3cams.services.DueniosService;
import com.silva.app.p3cams.services.IService;
import com.silva.app.p3cams.services.InquilinosService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/inquilinos/listar")
public class ListaInquilinosServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Connection conn = (Connection) req.getAttribute("conn");


        IService<Inquilino> service = new InquilinosService(conn);
        List<Inquilino> inquilinos = service.listar();

        req.setAttribute("inquilinos", inquilinos);
        getServletContext().getRequestDispatcher("/listaInquilinos.jsp").forward(req,resp);
    }
}
