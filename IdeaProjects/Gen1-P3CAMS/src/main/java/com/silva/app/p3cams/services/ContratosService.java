package com.silva.app.p3cams.services;

import com.silva.app.p3cams.models.Contrato;
import com.silva.app.p3cams.repositories.ContratosRepository;
import com.silva.app.p3cams.repositories.IRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ContratosService implements IService<Contrato>
{
    private IRepository<Contrato> contratosRepo;

    public ContratosService (Connection conn)
    {
        contratosRepo= new ContratosRepository(conn);
    }
    @Override
    public List<Contrato> listar()
    {
        try
        {
            return contratosRepo.listar();
        }
        catch (SQLException e)
        {
            throw  new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Contrato> getById(Long id)
    {
        try
        {
            return Optional.ofNullable(contratosRepo.getById(id));
        }
        catch (SQLException e)
        {
            throw  new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void guardar(Contrato contrato)
    {
        try
        {
            contratosRepo.guardar(contrato);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void eliminar(Long id) {

    }
}
