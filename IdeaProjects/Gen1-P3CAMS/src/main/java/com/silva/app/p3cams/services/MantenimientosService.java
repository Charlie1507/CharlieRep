package com.silva.app.p3cams.services;

import com.silva.app.p3cams.models.Mantenimiento;
import com.silva.app.p3cams.models.Propiedad;
import com.silva.app.p3cams.repositories.IMantenimientorepository;
import com.silva.app.p3cams.repositories.IRepository;
import com.silva.app.p3cams.repositories.MantenimientosRepository;
import com.silva.app.p3cams.repositories.PropiedadesRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class MantenimientosService implements IMantenimientoService {

    private IMantenimientorepository mantenimientosRepo;
    private IRepository<Propiedad> propiedadRepo;

    public MantenimientosService(Connection conn)
    {
        this.mantenimientosRepo = new MantenimientosRepository(conn);
        this.propiedadRepo = new PropiedadesRepository(conn);
    }

    public Propiedad getPropiedadId (Long id)
    {
        try
        {
            return mantenimientosRepo.getPropiedadId(id);
        }
        catch (SQLException e)
        {
            throw  new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<Mantenimiento> listar()
    {
        try
        {
            return mantenimientosRepo.listar();
        }
        catch (SQLException e)
        {
            throw  new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Mantenimiento> getById(Long id)
    {
        try
        {
            return Optional.ofNullable(mantenimientosRepo.getById(id));
        }
        catch (SQLException e)
        {
            throw  new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void guardar(Mantenimiento mantenimiento)
    {
        try
        {
            mantenimientosRepo.guardar(mantenimiento);
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
            mantenimientosRepo.eliminar(id);
        }
        catch (SQLException e)
        {
            throw  new RuntimeException(e.getMessage(), e.getCause());
        }
    }


    @Override
    public List<Propiedad> listarPropiedades()
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
}
