package com.silva.app.p3cams.contollers;

import com.silva.app.p3cams.models.Contrato;
import com.silva.app.p3cams.models.Duenio;
import com.silva.app.p3cams.models.Inquilino;
import com.silva.app.p3cams.models.Mantenimiento;
import com.silva.app.p3cams.services.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;


@WebServlet("/contratos/alta")
public class AltaContratoServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Connection conn = (Connection) req.getAttribute("conn");
        IService<Contrato> service = new ContratosService(conn);
        IService<Duenio> serviceD = new DueniosService(conn);
        IService<Inquilino> serviceI = new InquilinosService(conn);
        IPropiedadService serviceP = new PropiedadesService(conn);

        req.setAttribute("duenios", serviceD.listar());
        req.setAttribute("inquilinos", serviceI.listar());
        req.setAttribute("propiedades", serviceP.listar());

        getServletContext().getRequestDispatcher("/altaContratos.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Connection conn = (Connection) req.getAttribute("conn");
        IService<Contrato> service = new ContratosService(conn);


        String propiedadId = req.getParameter("propiedadId");
        String duenioId = req.getParameter("duenioId");
        String inquilinoId = req.getParameter("inquilinoId");
        String duracion = req.getParameter("duracion");
        String tipoContrato = req.getParameter("tipoContrato");



        Contrato contrato = new Contrato();
        contrato.setId(0L);
        contrato.setPropiedadId(Long.parseLong(propiedadId));
        contrato.setDuenioId(Long.parseLong(duenioId));
        contrato.setInquilinoId(Long.parseLong(inquilinoId));
        contrato.setDuracion(Integer.parseInt(duracion));
        contrato.setTipoContrato(tipoContrato);
        service.guardar(contrato);
        resp.sendRedirect(req.getContextPath() + "/contratos/listar");
    }
}
