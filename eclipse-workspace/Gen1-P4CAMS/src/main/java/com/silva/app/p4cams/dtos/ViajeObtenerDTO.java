package com.silva.app.p4cams.dtos;

import java.util.Date;

public class ViajeObtenerDTO 
{
	private Long id;
	private String destino;
	private Date fechaInicio;
	private Date fechaFin;
	private Long usuario;
	private String companiaViaje;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
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
	public Long getUsuario() {
		return usuario;
	}
	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}
	public String getCompaniaViaje() {
		return companiaViaje;
	}
	public void setCompaniaViaje(String companiaViaje) {
		this.companiaViaje = companiaViaje;
	}
	
	

}
