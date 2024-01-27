package com.silva.app.p4cams.models;

import java.util.Date;

import com.silva.app.p4cams.enums.TiposReserva;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "p4_reservas")
@Entity
public class Reserva 
{
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RE_SEQ1")
	@SequenceGenerator(sequenceName = "reservas_seq1", allocationSize = 1, name = "RE_SEQ1")
	private Long id;
	
	@Column(name = "tipo_reserva")
	private TiposReserva tipoReserva;
	
	@Column(name = "fecha_reserva")
	private Date fechaReserva;
	
	@JoinColumn(name = "viaje_id")
	@ManyToOne
	private Viaje viaje;
	
	@Column(name = "detalle_reserva")
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

	public Viaje getViaje() {
		return viaje;
	}

	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}

	public String getDetalleReserva() {
		return detalleReserva;
	}

	public void setDetalleReserva(String detalleReserva) {
		this.detalleReserva = detalleReserva;
	}
	
	
}
