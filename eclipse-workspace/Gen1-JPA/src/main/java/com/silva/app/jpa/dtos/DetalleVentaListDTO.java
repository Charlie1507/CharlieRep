package com.silva.app.jpa.dtos;

import com.silva.app.jpa.models.Producto;

public class DetalleVentaListDTO 
{
	private Long id;
	private Integer cantidad;
	private Producto producto;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	

	
}
