package com.silva.app.api;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class C1 
{
	/*
	public static void main(String[] args) 
	{
		List<Integer> lista = f1();
		
		System.out.println(lista);
		System.out.println(f2(lista));
		System.out.println(f3("javier@hotmail.com"));
		
	}
	*/
	
	@GetMapping
	public static List<Integer> f1()
	{
		List<Integer> numeros = new ArrayList<>();
		for (int i = 0; i<10; i++)
		{
			numeros.add((int)(Math.random()*10+1));
		}
		return numeros;
	}
	
	@PostMapping
	public static List<List<Integer>> f2(@RequestBody List<Integer> lista)
	{
		List<Integer> pares = new ArrayList<>();
		List<Integer> impares = new ArrayList<>();
		List<List<Integer>> listaDeListas = new ArrayList<>();
		for (int i =0; i < lista.size(); i++)
		{
			if(lista.get(i) % 2 == 0)
			{
				pares.add(lista.get(i));
			}
			else
			{
				impares.add(lista.get(i));
			}
		}
		listaDeListas.add(impares);
		listaDeListas.add(pares);
		return listaDeListas;
	}
	
	
	@GetMapping("/validar")
	public static String f3(@RequestParam (name="correo") String correo)
	{
		
		Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher mather = pattern.matcher(correo);
		if (mather.find() == true)
		{
			return "OK";
		}
		else
		{
			return "ERROR";
		}
	}
}
