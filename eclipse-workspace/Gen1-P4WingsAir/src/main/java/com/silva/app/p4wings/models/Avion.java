package com.silva.app.p4wings.models;

import com.silva.app.p4wings.enums.TipoAvion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "aviones")
@Entity
public class Avion 
{
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AV_SEQ1")
	@SequenceGenerator(sequenceName = "aviones_seq1", allocationSize = 1, name = "AV_SEQ1")
	private Long id;
	
	@Column(name = "tipo_avion")
	private TipoAvion tAvion;
	
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "horas_vuelo")
	private String hVuelo;
	
	@Column(name = "capacidad")
	private Integer capacidad;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoAvion gettAvion() {
		return tAvion;
	}

	public void settAvion(TipoAvion tAvion) {
		this.tAvion = tAvion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String gethVuelo() {
		return hVuelo;
	}

	public void sethVuelo(String hVuelo) {
		this.hVuelo = hVuelo;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}
	
	
	

}
