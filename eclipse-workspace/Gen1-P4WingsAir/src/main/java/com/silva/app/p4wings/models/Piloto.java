package com.silva.app.p4wings.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "wings_pilotos")
@Entity
public class Piloto 
{
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PI_SEQ1")
	@SequenceGenerator(sequenceName = "pilotos_seq1", allocationSize = 1, name = "PI_SEQ1")
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "ap_Paterno")
	private String apPaterno;
	
	@Column(name = "ap_materno")
	private String apMaterno;
	
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "genero")
	private String genero;
	
	@Column(name = "horas_vuelo")
	private Float horasVuelo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApPaterno() {
		return apPaterno;
	}

	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}

	public String getApMaterno() {
		return apMaterno;
	}

	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Float getHorasVuelo() {
		return horasVuelo;
	}

	public void setHorasVuelo(Float horasVuelo) {
		this.horasVuelo = horasVuelo;
	}
	
	

}
