package com.silva.app.p3cams.services;

import com.silva.app.p3cams.models.Inquilino;
import com.silva.app.p3cams.repositories.IRepository;
import com.silva.app.p3cams.repositories.InquilinosRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class InquilinosService implements IService<Inquilino>
{
    private IRepository<Inquilino> inquilinosRepo;

    public InquilinosService (Connection conn)
    {
        inquilinosRepo = new InquilinosRepository(conn);
    }
    @Override
    public List<Inquilino> listar()
    {
        try
        {
            return inquilinosRepo.listar();
        }
        catch (SQLException e)
        {
            throw  new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Inquilino> getById(Long id)
    {
        try
        {
            return Optional.ofNullable(inquilinosRepo.getById(id));
        }
        catch (SQLException e)
        {
            throw  new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void guardar(Inquilino inquilino)
    {
        try
        {
            inquilinosRepo.guardar(inquilino);
        }
        catch (SQLException e)
        {
            throw  new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void eliminar(Long id)
    {
        try
        {
            inquilinosRepo.eliminar(id);
        }
        catch (SQLException e)
        {
            throw  new RuntimeException(e.getMessage(), e.getCause());
        }
    }
}
