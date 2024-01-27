package com.silva.app.p4cams.dtos;

import java.util.Date;


public class ActividadObtenerDTO 
{
	private Long id;
	private String nombreActividad;
	private String descripcion;
	private Date fechaInicio;
	private Date fechaFin;
	private Long viaje;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombreActividad() {
		return nombreActividad;
	}
	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Long getViaje() {
		return viaje;
	}
	public void setViaje(Long viaje) {
		this.viaje = viaje;
	}

	
	
}
