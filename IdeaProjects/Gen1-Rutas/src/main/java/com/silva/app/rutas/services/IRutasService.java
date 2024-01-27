package com.silva.app.rutas.services;

import com.silva.app.rutas.models.Camion;
import com.silva.app.rutas.models.Chofer;
import com.silva.app.rutas.models.Ruta;

import java.util.List;

public interface IRutasService extends IService<Ruta>
{
    List<Camion> listarCamiones();
    List<Chofer> listarChoferes();
    Long guardarReturnId(Ruta ruta);

}
