package com.silva.app.p4cams.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silva.app.p4cams.dao.IActividadesDAO;
import com.silva.app.p4cams.dao.IGastosDAO;
import com.silva.app.p4cams.dao.IViajesDAO;
import com.silva.app.p4cams.dtos.ActividadObtenerDTO;
import com.silva.app.p4cams.dtos.GastoObtenerDTO;
import com.silva.app.p4cams.models.Actividad;
import com.silva.app.p4cams.models.Gasto;

@Service
public class ActividadesService implements IService<Actividad, ActividadObtenerDTO>
{

	@Autowired
	private IActividadesDAO actividadDao;
	
	@Autowired
	private IViajesDAO viajeDao;

	@Override
	public List<Actividad> listar() 
	{
		List<Actividad> detalles = new ArrayList<>();
		detalles = (List<Actividad>) actividadDao.findAll();
		return detalles;
	}

	@Override
	public Optional<Actividad> getById(Long id) 
	{
		// TODO Auto-generated method stub
		Optional<Actividad> detalle = actividadDao.findById(id);
		return detalle;
		
	}

	@Override
	public void guardar(ActividadObtenerDTO t) 
	{
		// TODO Auto-generated method stub
		this.actividadDao.save(convertirDTOaAct(t));
	}

	@Override
	public void eliminar(Long id) 
	{
		// TODO Auto-generated method stub
		this.actividadDao.deleteById(id);
	}
	
	public Actividad convertirDTOaAct(ActividadObtenerDTO ventadto)
	{
		Actividad v = new Actividad();
		v.setId(ventadto.getId());
		v.setNombreActividad(ventadto.getNombreActividad());
		v.setDescripcion(ventadto.getDescripcion());
		v.setFechaInicio(ventadto.getFechaInicio());
		v.setFechaFin(ventadto.getFechaFin());
		v.setViaje(viajeDao.findById(ventadto.getViaje()).get());
		return v;
	}

}
