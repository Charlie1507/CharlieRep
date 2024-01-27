package com.silva.app.p3cams.services;

import com.silva.app.p3cams.models.Duenio;
import com.silva.app.p3cams.models.Propiedad;
import com.silva.app.p3cams.repositories.DueniosRepository;
import com.silva.app.p3cams.repositories.IRepository;
import com.silva.app.p3cams.repositories.PropiedadesRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class PropiedadesService implements IPropiedadService
{
    IRepository<Propiedad> propiedadRepo;
    IRepository<Duenio> dueniosRepo;

    public PropiedadesService (Connection conn)
    {

        propiedadRepo = new PropiedadesRepository(conn);
        dueniosRepo = new DueniosRepository(conn);
    }
    @Override
    public List<Propiedad> listar()
    {
        try
        {
            return propiedadRepo.listar();
        }
        catch (SQLException e)
        {
            throw  new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Propiedad> getById(Long id)
    {
        try
        {
            return Optional.ofNullable(propiedadRepo.getById(id));
        }
        catch (SQLException e)
        {
            throw  new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void guardar(Propiedad propiedad)
    {
        try
        {
            propiedadRepo.guardar(propiedad);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void eliminar(Long id)
    {
        try
        {
            propiedadRepo.eliminar(id);
        }
        catch (SQLException e)
        {
            throw  new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<Duenio> listarDuenios()
    {
        try
        {
            return dueniosRepo.listar();
        }
        catch (SQLException e)
        {
            throw  new RuntimeException(e.getMessage(), e.getCause());
        }
    }
}
