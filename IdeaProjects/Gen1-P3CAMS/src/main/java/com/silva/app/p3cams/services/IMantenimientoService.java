package com.silva.app.p3cams.services;

import com.silva.app.p3cams.models.Mantenimiento;
import com.silva.app.p3cams.models.Propiedad;

import java.util.List;

public interface IMantenimientoService extends IService<Mantenimiento>
{
    List<Propiedad> listarPropiedades ();
    Propiedad getPropiedadId (Long id);
}
