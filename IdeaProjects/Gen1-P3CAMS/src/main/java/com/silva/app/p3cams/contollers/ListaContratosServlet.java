package com.silva.app.p3cams.contollers;

import com.silva.app.p3cams.models.Contrato;
import com.silva.app.p3cams.models.Inquilino;
import com.silva.app.p3cams.models.Propiedad;
import com.silva.app.p3cams.services.ContratosService;
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
import java.util.Optional;

@WebServlet("/contratos/listar")
public class ListaContratosServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Connection conn = (Connection) req.getAttribute("conn");


        IService<Contrato> service = new ContratosService(conn);
        List<Contrato> contratos = service.listar();
        IService<Propiedad> propiedadService = new PropiedadesService(conn);
        IService<Inquilino> propiedadS = new InquilinosService(conn);

        for (Contrato contrato : contratos) {
            // Obtener información de la propiedad
            Optional<Propiedad> optionalPropiedad = propiedadService.getById(contrato.getPropiedadId());

            Optional<Inquilino> optionalInquilino = propiedadS.getById(contrato.getPropiedadId());

            if (optionalPropiedad.isPresent()) {
                Propiedad propiedad = optionalPropiedad.get();
                contrato.setDireccionPropiedad(propiedad.getDireccion());
            }

            if (optionalInquilino.isPresent()) {
                Inquilino inquilino = optionalInquilino.get();
                contrato.setNombreInquilino(inquilino.getNombre() + " " + inquilino.getApPaterno() + " " + inquilino.getApMaterno());
            }
        }

        req.setAttribute("contratos", contratos);

        getServletContext().getRequestDispatcher("/listaContratos.jsp").forward(req,resp);
    }
}
