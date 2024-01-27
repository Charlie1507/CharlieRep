package com.silva.app.p3cams.repositories;

import java.sql.SQLException;
import java.util.List;

public interface IRepository<T>
{
    List<T> listar() throws SQLException;
    T getById(Long id) throws SQLException;
    void guardar (T t) throws SQLException;
    void eliminar (Long id) throws SQLException;
}
