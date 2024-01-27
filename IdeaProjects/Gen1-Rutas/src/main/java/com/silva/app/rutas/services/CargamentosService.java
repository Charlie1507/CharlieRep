package com.silva.app.rutas.services;

import com.silva.app.rutas.models.Cargamento;
import com.silva.app.rutas.repositories.CargamentoRepository;
import com.silva.app.rutas.repositories.IRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CargamentosService implements IService<Cargamento>
{
    private IRepository<Cargamento> cargamentoRepo;
    public CargamentosService (Connection conn)
    {
        cargamentoRepo= new CargamentoRepository(conn);
    }

    @Override
    public List<Cargamento> listar() {
        return null;
    }

    @Override
    public Optional<Cargamento> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public void guardar(Cargamento cargamento)
    {
        try
        {
            cargamentoRepo.guardar(cargamento);
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
