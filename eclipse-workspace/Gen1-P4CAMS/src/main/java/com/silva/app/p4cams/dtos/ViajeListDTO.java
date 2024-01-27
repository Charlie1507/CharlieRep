package com.silva.app.p4cams.dtos;

import java.util.Date;
import java.util.List;

import com.silva.app.p4cams.models.Gasto;
import com.silva.app.p4cams.models.Usuario;

public class ViajeListDTO 
{
	private Long id;
	private String destino;
	private Date fechaInicio;
	private Date fechaFin;
	private Usuario usuario;
	private String companiaViaje;
	private List<GastoListDTO> gasto;
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
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getCompaniaViaje() {
		return companiaViaje;
	}
	public void setCompaniaViaje(String companiaViaje) {
		this.companiaViaje = companiaViaje;
	}
	public List<GastoListDTO> getGasto() {
		return gasto;
	}
	public void setGasto(List<GastoListDTO> gasto) {
		this.gasto = gasto;
	}
	
	
}
