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

import com.silva.app.p4cams.dtos.GastoObtenerDTO;
import com.silva.app.p4cams.models.Gasto;
import com.silva.app.p4cams.services.IService;

@RestController
@RequestMapping("apip4/gastos")
public class GastosController 
{
	@Autowired
	IService<Gasto, GastoObtenerDTO> gastosService;
	
	@PostMapping
	public Map<String, String> guardar(@RequestBody GastoObtenerDTO c)
	{
		gastosService.guardar(c);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Gasto guardado exitosamente");
		return respuesta;
		
	}
	
	@GetMapping
	public List<Gasto> listar()
	{
		return gastosService.listar();
	}
	
	@GetMapping("/obtener/{id}")
	public Gasto obtenerPorId(@PathVariable(name = "id")Long id)
	{
		Optional<Gasto> gasto = gastosService.getById(id);
		if(gasto.isPresent())
		{
			return gasto.get();
		}
		else
		{
			return null;
		}
		
	}
	
	@DeleteMapping("/eliminar")
	public Map<String, String> eliminar(@RequestParam(name = "id")Long id)
	{
		gastosService.eliminar(id);
		Map<String, String>respuesta = new HashMap<>();
		respuesta.put("msg", "Gasto eliminado exitosamente");
		return respuesta;
	}
	
	@PostMapping("/actualizar/{id}")
	public Map<String, String> actualizar(@RequestBody GastoObtenerDTO c,@PathVariable(name = "id")Long id )
	{
		Optional<Gasto> gasto = gastosService.getById(id);
		if(gasto.isPresent())
		{
			c.setId(id);
			gastosService.guardar(c);
		}
		else
		{
			throw new RuntimeException("El gasto no existe en la base de datos");
		}
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Gasto actualizado correctamente");
		return respuesta;
	}

}
