package com.silva.app.p3cams.services;

import com.silva.app.p3cams.models.Duenio;
import com.silva.app.p3cams.repositories.DueniosRepository;
import com.silva.app.p3cams.repositories.IRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class DueniosService implements IService<Duenio>
{
    private IRepository<Duenio> dueniosRepo;

    public DueniosService (Connection conn)
    {
        dueniosRepo = new DueniosRepository(conn);
    }
    @Override
    public List<Duenio> listar() {
        try
        {
            return dueniosRepo.listar();
        }
        catch (SQLException e)
        {
            throw  new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Duenio> getById(Long id)
    {
        try
        {
            return Optional.ofNullable(dueniosRepo.getById(id));
        }
        catch (SQLException e)
        {
            throw  new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void guardar(Duenio duenio)
    {
        try
        {
            dueniosRepo.guardar(duenio);
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
            dueniosRepo.eliminar(id);
        }
        catch (SQLException e)
        {
            throw  new RuntimeException(e.getMessage(), e.getCause());
        }

    }
}
