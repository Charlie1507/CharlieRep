package com.silva.app.p3cams.repositories;

import com.silva.app.p3cams.models.Mantenimiento;
import com.silva.app.p3cams.models.Propiedad;

import java.sql.SQLException;

public interface IMantenimientorepository extends IRepository<Mantenimiento>
{
    Propiedad getPropiedadId (Long id) throws SQLException;
}
