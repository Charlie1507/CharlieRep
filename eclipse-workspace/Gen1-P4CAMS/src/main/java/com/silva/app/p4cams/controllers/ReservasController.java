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

import com.silva.app.p4cams.dtos.ReservaObtenerDTO;
import com.silva.app.p4cams.models.Reserva;
import com.silva.app.p4cams.services.IService;

@RestController
@RequestMapping("apip4/reservas")
public class ReservasController 
{
	@Autowired
	IService<Reserva, ReservaObtenerDTO> reservasService;
	
	@PostMapping
	public Map<String, String> guardar(@RequestBody ReservaObtenerDTO c)
	{
		reservasService.guardar(c);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Reserva guardado exitosamente");
		return respuesta;
		
	}
	
	@GetMapping
	public List<Reserva> listar()
	{
		return reservasService.listar();
	}
	
	@GetMapping("/obtener/{id}")
	public Reserva obtenerPorId(@PathVariable(name = "id")Long id)
	{
		Optional<Reserva> reserva = reservasService.getById(id);
		if(reserva.isPresent())
		{
			return reserva.get();
		}
		else
		{
			return null;
		}
		
	}
	
	@DeleteMapping("/eliminar")
	public Map<String, String> eliminar(@RequestParam(name = "id")Long id)
	{
		reservasService.eliminar(id);
		Map<String, String>respuesta = new HashMap<>();
		respuesta.put("msg", "Reserva eliminado exitosamente");
		return respuesta;
	}
	
	@PostMapping("/actualizar/{id}")
	public Map<String, String> actualizar(@RequestBody ReservaObtenerDTO c,@PathVariable(name = "id")Long id )
	{
		Optional<Reserva> reserva = reservasService.getById(id);
		if(reserva.isPresent())
		{
			c.setId(id);
			reservasService.guardar(c);
		}
		else
		{
			throw new RuntimeException("La reserva no existe en la base de datos");
		}
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Reserva actualizada correctamente");
		return respuesta;
	}
}
