package com.silva.app.p4cams.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "p4_viajes")
@Entity
public class Viaje 
{
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VI_SEQ1")
	@SequenceGenerator(sequenceName = "viajes_seq1", allocationSize = 1, name = "VI_SEQ1")
	private Long id;
	
	@Column(name = "destino")
	private String destino;
	
	@Column(name = "fecha_inicio")
	private Date fechaInicio;
	
	@Column(name = "fecha_fin")
	private Date fechaFin;
	
	@JoinColumn(name = "usuario_id")
	@ManyToOne
	private Usuario usuario;
	
	@Column(name = "Compania_viaje")
	private String companiaViaje;
	
	@OneToMany(mappedBy = "viaje")
	private List<Gasto> gasto;
	

	public List<Gasto> getGasto() {
		return gasto;
	}

	public void setGasto(List<Gasto> gasto) {
		this.gasto = gasto;
	}

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

	
	
	
	
	
}
