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
import java.util.Optional;


@WebServlet("/duenios/detalle")
public class DetalleDuenioServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Connection conn = (Connection) req.getAttribute("conn");
        IService<Duenio> service = new DueniosService(conn);
        long id;
        try
        {
            id = Long.parseLong(req.getParameter("id"));
        }
        catch(NumberFormatException e)
        {
            id = 0L;
        }
        Duenio duenio = new Duenio();
        if (  id>0L)
        {
            Optional<Duenio> o = service.getById(id);
            if(o.isPresent())
            {
                duenio = o.get();
                req.setAttribute("duenio", duenio);
                getServletContext().getRequestDispatcher("/detalleDuenio.jsp").forward(req, resp);
            }
            else
            {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "No existe el dueño en la base de datos!");
            }
        }
        else
        {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Error el id en null, se debe enviar como parametro en la url!");
        }
    }
}
