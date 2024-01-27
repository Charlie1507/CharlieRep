package com.silva.app.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.silva.app.jpa.models.Producto;

public interface IProductosDao extends CrudRepository<Producto, Long>
{

}
