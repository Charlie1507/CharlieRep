package com.silva.app.p4cams.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "p4_Usuarios")
@Entity
public class Usuario 
{
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "US_SEQ1")
	@SequenceGenerator(sequenceName = "usuario_seq1", allocationSize = 1, name = "US_SEQ1")
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "correo")
	private String correo;
	
	@Column(name = "contrasenia")
	private String contrasenia;
	
	@Column(name = "fechaRegistro")
	private Date fechaRegistro;
	
	@Column(name = "preferencias_viaje")
	private String preferenciaViaje;

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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getPreferenciaViaje() {
		return preferenciaViaje;
	}

	public void setPreferenciaViaje(String preferenciaViaje) {
		this.preferenciaViaje = preferenciaViaje;
	}

	
	
	
}
