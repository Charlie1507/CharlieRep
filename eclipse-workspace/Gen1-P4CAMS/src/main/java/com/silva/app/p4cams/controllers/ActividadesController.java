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

import com.silva.app.p4cams.dtos.ActividadObtenerDTO;
import com.silva.app.p4cams.models.Actividad;
import com.silva.app.p4cams.services.IService;

@RestController
@RequestMapping("apip4/actividades")
public class ActividadesController 
{
	@Autowired
	IService<Actividad, ActividadObtenerDTO> actividadesService;
	
	@PostMapping
	public Map<String, String> guardar(@RequestBody ActividadObtenerDTO c)
	{
		actividadesService.guardar(c);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Actividad guardada exitosamente");
		return respuesta;
		
	}
	
	@GetMapping
	public List<Actividad> listar()
	{
		return actividadesService.listar();
	}
	
	@GetMapping("/obtener/{id}")
	public Actividad obtenerPorId(@PathVariable(name = "id")Long id)
	{
		Optional<Actividad> viaje = actividadesService.getById(id);
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
		actividadesService.eliminar(id);
		Map<String, String>respuesta = new HashMap<>();
		respuesta.put("msg", "Actividad eliminado exitosamente");
		return respuesta;
	}
	
	@PostMapping("/actualizar/{id}")
	public Map<String, String> actualizar(@RequestBody ActividadObtenerDTO c,@PathVariable(name = "id")Long id )
	{
		Optional<Actividad> venta = actividadesService.getById(id);
		if(venta.isPresent())
		{
			c.setId(id);
			actividadesService.guardar(c);
		}
		else
		{
			throw new RuntimeException("La actividad no existe en la base de datos");
		}
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Actividad actualizado correctamente");
		return respuesta;
	}
}
