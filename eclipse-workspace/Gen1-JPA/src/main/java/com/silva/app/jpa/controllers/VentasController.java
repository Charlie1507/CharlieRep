package com.silva.app.jpa.controllers;

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

import com.silva.app.jpa.dtos.VentaDTO;
import com.silva.app.jpa.dtos.VentaListDTO;
import com.silva.app.jpa.models.Venta;
import com.silva.app.jpa.services.IService;

@RestController
@RequestMapping("api/ventas")
public class VentasController 
{
	//Atributos
		@Autowired
		IService<VentaListDTO, VentaDTO> ventasService;
		
		@PostMapping
		public Map<String, String> guardar(@RequestBody VentaDTO c)
		{
			ventasService.guardar(c);
			Map<String, String> respuesta = new HashMap<>();
			respuesta.put("msg", "Venta guardado exitosamente");
			return respuesta;
			
		}
		
		@GetMapping
		public List<VentaListDTO> listar()
		{
			return ventasService.listar();
		}
		
		@GetMapping("/obtener/{id}")
		public VentaListDTO obtenerPorId(@PathVariable(name = "id")Long id)
		{
			Optional<VentaListDTO> venta = ventasService.getById(id);
			if(venta.isPresent())
			{
				return venta.get();
			}
			else
			{
				return null;
			}
			
		}
		
		@DeleteMapping("/eliminar")
		public Map<String, String> eliminar(@RequestParam(name = "id")Long id)
		{
			ventasService.eliminar(id);
			Map<String, String>respuesta = new HashMap<>();
			respuesta.put("msg", "Venta eliminado exitosamente");
			return respuesta;
		}
		
		@PostMapping("/actualizar/{id}")
		public Map<String, String> actualizar(@RequestBody VentaDTO c,@PathVariable(name = "id")Long id )
		{
			Optional<VentaListDTO> venta = ventasService.getById(id);
			if(venta.isPresent())
			{
				c.setId(id);
				ventasService.guardar(c);
			}
			else
			{
				throw new RuntimeException("El cliente no existe en la bd");
			}
			Map<String, String> respuesta = new HashMap<>();
			respuesta.put("msg", "Venta actualizado correctamente");
			return respuesta;
		}

}
