package com.silva.app.jpa.dtos;

import java.util.Date;
import java.util.List;

import com.silva.app.jpa.models.Cliente;

public class VentaListDTO 
{
	private Long id;
	private Date fecha;
	private Float subtotal;
	private Float descuento;
	private Float total;
	private String formaPago;
	private Cliente cliente;
	private List<DetalleVentaListDTO> detalle;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Float getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Float subtotal) {
		this.subtotal = subtotal;
	}
	public Float getDescuento() {
		return descuento;
	}
	public void setDescuento(Float descuento) {
		this.descuento = descuento;
	}
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}
	public String getFormaPago() {
		return formaPago;
	}
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<DetalleVentaListDTO> getDetalle() {
		return detalle;
	}
	public void setDetalle(List<DetalleVentaListDTO> detalle) {
		this.detalle = detalle;
	}
	
	

}
