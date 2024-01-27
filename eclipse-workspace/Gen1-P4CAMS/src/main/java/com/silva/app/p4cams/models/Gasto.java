package com.silva.app.p4cams.models;

import java.util.Date;

import com.silva.app.p4cams.enums.CategoriasGastos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "p4_gastos")
@Entity
public class Gasto 
{
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GA_SEQ1")
	@SequenceGenerator(sequenceName = "gastos_seq1", allocationSize = 1, name = "GA_SEQ1")
	private Long id;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "monto")
	private Float monto;
	
	@Column(name = "fecha")
	private Date fecha;
	
	@JoinColumn(name = "viaje_id")
	@ManyToOne
	private Viaje viaje;
	
	@Column(name = "categoria_gastos")
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

	public Viaje getViaje() {
		return viaje;
	}

	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}

	public CategoriasGastos getcGastos() {
		return cGastos;
	}

	public void setcGastos(CategoriasGastos cGastos) {
		this.cGastos = cGastos;
	}
	
	

}
