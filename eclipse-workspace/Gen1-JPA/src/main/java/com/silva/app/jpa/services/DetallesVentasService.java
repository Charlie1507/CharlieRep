package com.silva.app.jpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silva.app.jpa.dao.IDetallesVentas;
import com.silva.app.jpa.dao.IProductosDao;
import com.silva.app.jpa.dao.IVentasDao;
import com.silva.app.jpa.dtos.DetalleVentaDTO;
import com.silva.app.jpa.dtos.VentaDTO;
import com.silva.app.jpa.models.DetalleVenta;
import com.silva.app.jpa.models.Venta;

@Service
public class DetallesVentasService implements IService<DetalleVenta, DetalleVentaDTO>
{
	@Autowired
	private IDetallesVentas detallesVentasDao;
	@Autowired
	private IProductosDao productosDao;
	@Autowired
	private IVentasDao ventasDao;
	
	@Override
	public List<DetalleVenta> listar() 
	{
		List<DetalleVenta> detalles = new ArrayList<>();
		detalles = (List<DetalleVenta>) detallesVentasDao.findAll();
		return detalles;
	}

	@Override
	public Optional<DetalleVenta> getById(Long id) 
	{
		Optional<DetalleVenta> detalle = detallesVentasDao.findById(id);
		return detalle;
	}

	@Override
	public void guardar(DetalleVentaDTO t) 
	{
		// TODO Auto-generated method stub
				this.detallesVentasDao.save(convertirDTOaDVenta(t));
		
	}

	@Override
	public void eliminar(Long id) 
	{
		// TODO Auto-generated method stub
				this.detallesVentasDao.deleteById(id);
		
	}
	
	//metodo parfa converir DTO en un modelo original
		public DetalleVenta convertirDTOaDVenta(DetalleVentaDTO ventadto)
		{
			DetalleVenta v = new DetalleVenta();
			v.setId(ventadto.getId());
			v.setCantidad(ventadto.getCantidad());
			v.setProducto(productosDao.findById(ventadto.getProducto()).get());
			v.setVenta(ventasDao.findById(ventadto.getVenta()).get());
			return v;
		}

}
