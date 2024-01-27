package com.silva.api.repositories;



import com.silva.api.models.Direccion;

import java.sql.SQLException;

public interface IDireccionesRepository extends IRepository<Direccion>
{
    Long guardarReturnId(Direccion direccion) throws SQLException;
}
