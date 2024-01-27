package com.silva.app.p4cams.dao;

import org.springframework.data.repository.CrudRepository;

import com.silva.app.p4cams.models.Usuario;
import com.silva.app.p4cams.models.Viaje;

public interface IViajesDAO extends CrudRepository<Viaje, Long>
{

}
