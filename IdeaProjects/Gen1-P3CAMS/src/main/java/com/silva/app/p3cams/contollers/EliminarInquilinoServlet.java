package com.silva.app.p3cams.contollers;

import com.silva.app.p3cams.models.Inquilino;
import com.silva.app.p3cams.services.IService;
import com.silva.app.p3cams.services.InquilinosService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;


@WebServlet("/inquilinos/eliminar")
public class EliminarInquilinoServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Connection conn = (Connection) req.getAttribute("conn");
        IService<Inquilino> service = new InquilinosService(conn);
        long id;
        try
        {
            id = Long.parseLong(req.getParameter("id"));
        }
        catch(NumberFormatException e)
        {
            id = 0L;
        }
        Inquilino inquilino = new Inquilino();
        if (  id>0L)
        {
            Optional<Inquilino> o = service.getById(id);
            if(o.isPresent())
            {
                service.eliminar(id);
                resp.sendRedirect(req.getContextPath() + "/inquilinos/listar");
            }
            else
            {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "No existe el inquilinos en la base de datos!");
            }
        }
        else
        {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Error el id en null, se debe enviar como parametro en la url!");
        }
    }
}
