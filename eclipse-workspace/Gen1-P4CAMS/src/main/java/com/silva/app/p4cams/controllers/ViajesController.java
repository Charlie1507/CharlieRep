package com.silva.app.p4cams.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.silva.app.p4cams.dtos.ViajeListDTO;
import com.silva.app.p4cams.dtos.ViajeObtenerDTO;
import com.silva.app.p4cams.models.Viaje;
import com.silva.app.p4cams.services.IService;

@RestController
@RequestMapping("apip4/viajes")
public class ViajesController 
{
	@Autowired
	IService<ViajeListDTO, ViajeObtenerDTO> viajesService;
	
	@PostMapping
	public Map<String, String> guardar(@RequestBody ViajeObtenerDTO c)
	{
		viajesService.guardar(c);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Viaje guardado exitosamente");
		return respuesta;
		
	}
	
	@GetMapping
	public List<ViajeListDTO> listar()
	{
		return viajesService.listar();
	}
	
	@GetMapping("/obtener/{id}")
	public ViajeListDTO obtenerPorId(@PathVariable(name = "id")Long id)
	{
		Optional<ViajeListDTO> viaje = viajesService.getById(id);
		if(viaje.isPresent())
		{
			return viaje.get();
		}
		else
		{
			return null;
		}
		
	}
	
	@DeleteMapping("/eliminar")
	public Map<String, String> eliminar(@RequestParam(name = "id")Long id)
	{
		viajesService.eliminar(id);
		Map<String, String>respuesta = new HashMap<>();
		respuesta.put("msg", "Viaje eliminado exitosamente");
		return respuesta;
	}
	
	@PostMapping("/actualizar/{id}")
	public Map<String, String> actualizar(@RequestBody ViajeObtenerDTO c,@PathVariable(name = "id")Long id )
	{
		Optional<ViajeListDTO> venta = viajesService.getById(id);
		if(venta.isPresent())
		{
			c.setId(id);
			viajesService.guardar(c);
		}
		else
		{
			throw new RuntimeException("El viaje no existe en la base de datos");
		}
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Viaje actualizado correctamente");
		return respuesta;
	}

}
