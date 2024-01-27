package com.silva.app.p4cams.dtos;

import java.util.Date;

import com.silva.app.p4cams.enums.CategoriasGastos;

public class GastoListDTO 
{
	private Long id;
	private String descripcion;
	private Float monto;
	private Date fecha;
	private CategoriasGastos cGastos;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Float getMonto() {
		return monto;
	}
	public void setMonto(Float monto) {
		this.monto = monto;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public CategoriasGastos getcGastos() {
		return cGastos;
	}
	public void setcGastos(CategoriasGastos cGastos) {
		this.cGastos = cGastos;
	}
	
	

}
