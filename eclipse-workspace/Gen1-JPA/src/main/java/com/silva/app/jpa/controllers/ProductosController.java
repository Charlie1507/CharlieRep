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

import com.silva.app.jpa.models.Producto;
import com.silva.app.jpa.services.IService;

@RestController
@RequestMapping("api/productos")
public class ProductosController 
{
	//Atributos
	@Autowired
	IService<Producto, Producto> productosService;
	
	@PostMapping
	public Map<String, String> guardar(@RequestBody Producto c)
	{
		productosService.guardar(c);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Producto guardado exitosamente");
		return respuesta;
		
	}
	
	@GetMapping
	public List<Producto> listar()
	{
		return productosService.listar();
	}
	
	@GetMapping("/obtener/{id}")
	public Producto obtenerPorId(@PathVariable(name = "id")Long id)
	{
		Optional<Producto> producto = productosService.getById(id);
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
		productosService.eliminar(id);
		Map<String, String>respuesta = new HashMap<>();
		respuesta.put("msg", "Producto eliminado exitosamente");
		return respuesta;
	}
	
	@PostMapping("/actualizar/{id}")
	public Map<String, String> actualizar(@RequestBody Producto c,@PathVariable(name = "id")Long id )
	{
		Optional<Producto> producto = productosService.getById(id);
		if(producto.isPresent())
		{
			c.setId(id);
			productosService.guardar(c);
		}
		else
		{
			throw new RuntimeException("El cliente no existe en la bd");
		}
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Producto actualizado correctamente");
		return respuesta;
	}

}
