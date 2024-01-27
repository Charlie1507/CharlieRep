package com.silva.app.p4cams.dao;

import org.springframework.data.repository.CrudRepository;

import com.silva.app.p4cams.models.Usuario;

public interface IUsuariosDAO extends CrudRepository<Usuario, Long>
{

}
