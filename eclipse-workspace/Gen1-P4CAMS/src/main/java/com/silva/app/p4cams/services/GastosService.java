package com.silva.app.p4cams.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silva.app.p4cams.dao.IGastosDAO;
import com.silva.app.p4cams.dao.IViajesDAO;
import com.silva.app.p4cams.dtos.GastoObtenerDTO;
import com.silva.app.p4cams.dtos.ReservaObtenerDTO;
import com.silva.app.p4cams.models.Gasto;
import com.silva.app.p4cams.models.Reserva;

@Service
public class GastosService implements IService<Gasto, GastoObtenerDTO>
{

	@Autowired
	private IGastosDAO gastoDao;
	
	@Autowired
	private IViajesDAO viajeDao;

	@Override
	public List<Gasto> listar() 
	{
		List<Gasto> detalles = new ArrayList<>();
		detalles = (List<Gasto>) gastoDao.findAll();
		return detalles;
	}

	@Override
	public Optional<Gasto> getById(Long id) 
	{
		// TODO Auto-generated method stub
		Optional<Gasto> detalle = gastoDao.findById(id);
		return detalle;
		
	}

	@Override
	public void guardar(GastoObtenerDTO t) 
	{
		// TODO Auto-generated method stub
		this.gastoDao.save(convertirDTOaGasto(t));
	}

	@Override
	public void eliminar(Long id) 
	{
		// TODO Auto-generated method stub
		this.gastoDao.deleteById(id);
	}
	
	public Gasto convertirDTOaGasto(GastoObtenerDTO ventadto)
	{
		Gasto v = new Gasto();
		v.setId(ventadto.getId());
		v.setDescripcion(ventadto.getDescripcion());
		v.setMonto(ventadto.getMonto());
		v.setFecha(ventadto.getFecha());
		v.setcGastos(ventadto.getcGastos());
		v.setViaje(viajeDao.findById(ventadto.getViaje()).get());
		return v;
	}

}
