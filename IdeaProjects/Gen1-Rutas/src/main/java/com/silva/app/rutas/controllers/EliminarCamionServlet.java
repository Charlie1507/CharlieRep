package com.silva.app.rutas.controllers;

import com.silva.app.rutas.models.Camion;
import com.silva.app.rutas.services.CamionesService;
import com.silva.app.rutas.services.IService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

@WebServlet("/camiones/eliminar")
public class EliminarCamionServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Connection conn = (Connection) req.getAttribute("conn");
        IService<Camion> service = new CamionesService(conn);
        long id;
        try
        {
            id = Long.parseLong(req.getParameter("id"));
        }
        catch(NumberFormatException e)
        {
            id = 0L;
        }
        Camion camion = new Camion();
        if (  id>0L)
        {
            Optional<Camion> o = service.getById(id);
            if(o.isPresent())
            {
                service.eliminar(id);
                resp.sendRedirect(req.getContextPath() + "/camiones/listar");
            }
            else
            {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "No existe el camion en la base de datos!");
            }
        }
        else
        {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Error el id en null, se debe enviar como parametro en la url!");
        }
    }
}
