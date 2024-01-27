package com.silva.app.p4cams.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silva.app.p4cams.dao.IUsuariosDAO;
import com.silva.app.p4cams.dao.IViajesDAO;
import com.silva.app.p4cams.dtos.GastoListDTO;
import com.silva.app.p4cams.dtos.ViajeListDTO;
import com.silva.app.p4cams.dtos.ViajeObtenerDTO;
import com.silva.app.p4cams.models.Gasto;
import com.silva.app.p4cams.models.Usuario;
import com.silva.app.p4cams.models.Viaje;

@Service
public class ViajesService implements IService<ViajeListDTO, ViajeObtenerDTO>
{
	@Autowired
	private IViajesDAO viajesDao;
	
	@Autowired
	private IUsuariosDAO usuariosDao;

	@Override
	public List<ViajeListDTO> listar() 
	{
		List<Viaje> viajes = new ArrayList<>();
		viajes = (List<Viaje>) viajesDao.findAll();
		return viajes.stream().map((v)-> {
			return this.convertirViajeaADTO(v);
	}).toList();
	}

	@Override
	public Optional<ViajeListDTO> getById(Long id) 
	{
		Optional<Viaje> viajes = viajesDao.findById(id);
		return Optional.of(this.convertirViajeaADTO(viajes.get()));
	}

	@Override
	public void guardar(ViajeObtenerDTO t) 
	{
		this.viajesDao.save(convertirDTOaViaje(t));
		
	}

	@Override
	public void eliminar(Long id) 
	{
		// TODO Auto-generated method stub
		this.viajesDao.deleteById(id);
		
	}
	
	public Viaje convertirDTOaViaje(ViajeObtenerDTO viajegetdto)
	{
		Viaje v = new Viaje();
		v.setId(viajegetdto.getId());
		v.setFechaInicio(viajegetdto.getFechaInicio());
		v.setFechaFin(viajegetdto.getFechaFin());
		v.setDestino(viajegetdto.getDestino());
		v.setUsuario(usuariosDao.findById(viajegetdto.getUsuario()).get());
		v.setCompaniaViaje(viajegetdto.getCompaniaViaje());
		return v;
	}
	
	public ViajeListDTO convertirViajeaADTO(Viaje v)
	{
		ViajeListDTO vdto = new ViajeListDTO();
		vdto.setId(v.getId());
		vdto.setDestino(v.getDestino());
		vdto.setFechaInicio(v.getFechaInicio());
		vdto.setFechaFin(v.getFechaFin());
		vdto.setUsuario(v.getUsuario());
		vdto.setCompaniaViaje(v.getCompaniaViaje());
		
		List<GastoListDTO> gasto = new ArrayList<>();
		for (Gasto dv : v.getGasto())
		{
			GastoListDTO dvdto = new GastoListDTO();
			dvdto.setId(dv.getId());
			dvdto.setDescripcion(dv.getDescripcion());
			dvdto.setMonto(dv.getMonto());
			dvdto.setFecha(dv.getFecha());
			dvdto.setcGastos(dv.getcGastos());
			gasto.add(dvdto);
			
		}
		vdto.setGasto(gasto);
		return vdto;
	}

}
