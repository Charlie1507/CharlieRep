package com.silva.app.p3cams.services;

import com.silva.app.p3cams.models.Duenio;
import com.silva.app.p3cams.models.Propiedad;

import java.util.List;

public interface IPropiedadService extends IService<Propiedad>
{

    List<Duenio> listarDuenios ();
}
