package com.silva.app.p4cams.dtos;

import java.util.Date;

import com.silva.app.p4cams.enums.TiposReserva;


public class ReservaObtenerDTO 
{
private Long id;
	
	
	private TiposReserva tipoReserva;
	private Date fechaReserva;
	private Long viaje;
	private String detalleReserva;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TiposReserva getTipoReserva() {
		return tipoReserva;
	}
	public void setTipoReserva(TiposReserva tipoReserva) {
		this.tipoReserva = tipoReserva;
	}
	public Date getFechaReserva() {
		return fechaReserva;
	}
	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}
	public Long getViaje() {
		return viaje;
	}
	public void setViaje(Long viaje) {
		this.viaje = viaje;
	}
	public String getDetalleReserva() {
		return detalleReserva;
	}
	public void setDetalleReserva(String detalleReserva) {
		this.detalleReserva = detalleReserva;
	}
	
	
}
