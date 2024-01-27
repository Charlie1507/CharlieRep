package com.silva.app.p3cams.contollers;

import com.silva.app.p3cams.models.Contrato;
import com.silva.app.p3cams.models.Mantenimiento;
import com.silva.app.p3cams.models.Propiedad;
import com.silva.app.p3cams.services.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

@WebServlet("/contratos/detalle")
public class DetalleContratoServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Connection conn = (Connection) req.getAttribute("conn");
        IService<Contrato> service = new ContratosService(conn);
        long id;
        try
        {
            id = Long.parseLong(req.getParameter("id"));
        }
        catch(NumberFormatException e)
        {
            id = 0L;
        }
        Contrato contrato = new Contrato();
        if (  id>0L)
        {
            Optional<Contrato> o = service.getById(id);
            if(o.isPresent())
            {
                contrato = o.get();

                req.setAttribute("contrato", contrato);
                getServletContext().getRequestDispatcher("/detalleContrato.jsp").forward(req, resp);
            }
            else
            {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "No existe el contrato en la base de datos!");
            }
        }
        else
        {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Error el id en null, se debe enviar como parametro en la url!");
        }
    }
}
