package com.silva.app.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.silva.app.jpa.models.Venta;

public interface IVentasDao extends CrudRepository<Venta, Long>
{

}
