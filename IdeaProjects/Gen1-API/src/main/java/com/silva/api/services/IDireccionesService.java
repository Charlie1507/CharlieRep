package com.silva.api.services;


import com.silva.api.models.Direccion;

public interface IDireccionesService extends IService<Direccion>
{
    Long guardarReturnId(Direccion direccion);
}
