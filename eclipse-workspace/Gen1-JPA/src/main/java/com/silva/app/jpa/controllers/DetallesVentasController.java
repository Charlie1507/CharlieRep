package com.silva.app.jpa.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.silva.app.jpa.dtos.DetalleVentaDTO;
import com.silva.app.jpa.models.DetalleVenta;
import com.silva.app.jpa.services.IService;

@RestController
@RequestMapping("api/detallesventas")
public class DetallesVentasController 
{
	//Atributos
		@Autowired
		IService<DetalleVenta, DetalleVentaDTO> detallesVentasServices;
		
		@PostMapping
		public Map<String, String> guardar(@RequestBody DetalleVentaDTO c)
		{
			detallesVentasServices.guardar(c);
			Map<String, String> respuesta = new HashMap<>();
			respuesta.put("msg", "Producto guardado exitosamente");
			return respuesta;
			
		}
		
		@GetMapping
		public List<DetalleVenta> listar()
		{
			return detallesVentasServices.listar();
		}
		
		@GetMapping("/obtener/{id}")
		public DetalleVenta obtenerPorId(@PathVariable(name = "id")Long id)
		{
			Optional<DetalleVenta> producto = detallesVentasServices.getById(id);
			if(producto.isPresent())
			{
				return producto.get();
			}
			else
			{
				return null;
			}
			
		}
		
		@DeleteMapping("/eliminar")
		public Map<String, String> eliminar(@RequestParam(name = "id")Long id)
		{
			detallesVentasServices.eliminar(id);
			Map<String, String>respuesta = new HashMap<>();
			respuesta.put("msg", "Detalle eliminado exitosamente");
			return respuesta;
		}
		
		@PostMapping("/actualizar/{id}")
		public Map<String, String> actualizar(@RequestBody DetalleVentaDTO c,@PathVariable(name = "id")Long id )
		{
			Optional<DetalleVenta> producto = detallesVentasServices.getById(id);
			if(producto.isPresent())
			{
				c.setId(id);
				detallesVentasServices.guardar(c);
			}
			else
			{
				throw new RuntimeException("El cliente no existe en la bd");
			}
			Map<String, String> respuesta = new HashMap<>();
			respuesta.put("msg", "Detalle actualizado correctamente");
			return respuesta;
		}
}
