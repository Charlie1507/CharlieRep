package com.silva.app.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.silva.app.jpa.models.Cliente;

public interface IClientesDao extends CrudRepository<Cliente, Long>
{

}
