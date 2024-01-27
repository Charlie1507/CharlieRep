package com.silva.app.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.silva.app.jpa.models.DetalleVenta;

public interface IDetallesVentas extends CrudRepository<DetalleVenta, Long>
{

}
