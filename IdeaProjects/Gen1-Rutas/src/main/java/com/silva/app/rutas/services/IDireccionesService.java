package com.silva.app.rutas.services;

import com.silva.app.rutas.models.Direccion;

public interface IDireccionesService extends IService<Direccion>
{
    Long guardarReturnId(Direccion direccion);
}
