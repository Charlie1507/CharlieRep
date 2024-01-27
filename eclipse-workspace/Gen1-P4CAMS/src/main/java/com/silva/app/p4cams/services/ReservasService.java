package com.silva.app.p4cams.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silva.app.p4cams.dao.IReservasDAO;
import com.silva.app.p4cams.dao.IViajesDAO;
import com.silva.app.p4cams.dtos.ReservaObtenerDTO;
import com.silva.app.p4cams.models.Reserva;

@Service
public class ReservasService implements IService<Reserva, ReservaObtenerDTO>
{
	@Autowired
	private IReservasDAO reservaDao;
	@Autowired
	private IViajesDAO viajeDao;

	@Override
	public List<Reserva> listar() 
	{
		List<Reserva> detalles = new ArrayList<>();
		detalles = (List<Reserva>) reservaDao.findAll();
		return detalles;
	}

	@Override
	public Optional<Reserva> getById(Long id) 
	{
		// TODO Auto-generated method stub
		Optional<Reserva> detalle = reservaDao.findById(id);
		return detalle;
		
	}

	@Override
	public void guardar(ReservaObtenerDTO t) 
	{
		// TODO Auto-generated method stub
		this.reservaDao.save(convertirDTOaReserva(t));
	}

	@Override
	public void eliminar(Long id) 
	{
		// TODO Auto-generated method stub
		this.reservaDao.deleteById(id);
	}
	
	public Reserva convertirDTOaReserva(ReservaObtenerDTO ventadto)
	{
		Reserva v = new Reserva();
		v.setId(ventadto.getId());
		v.setTipoReserva(ventadto.getTipoReserva());
		v.setFechaReserva(ventadto.getFechaReserva());
		v.setDetalleReserva(ventadto.getDetalleReserva());
		v.setViaje(viajeDao.findById(ventadto.getViaje()).get());
		return v;
	}


}
