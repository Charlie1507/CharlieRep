package com.silva.app.jpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silva.app.jpa.dao.IProductosDao;

import com.silva.app.jpa.models.Producto;

@Service
public class ProductosService implements IService<Producto, Producto>
{
	@Autowired
	private IProductosDao productosDao;

	@Override
	public List<Producto> listar() 
	{
		List<Producto> productos = new ArrayList<>();
		productos = (List<Producto>) productosDao.findAll();
		return productos;
	}

	@Override
	public Optional<Producto> getById(Long id) 
	{
		Optional<Producto> productos = productosDao.findById(id);
		return productos;
	}

	@Override
	public void guardar(Producto t) 
	{
		// TODO Auto-generated method stub
		this.productosDao.save(t);
		
	}

	@Override
	public void eliminar(Long id) 
	{
		// TODO Auto-generated method stub
		this.productosDao.deleteById(id);
		
	}

}
