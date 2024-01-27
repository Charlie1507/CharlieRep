package com.silva.app.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public class C1 
{
	@WebMethod
	public int suma(int a, int b)
	{
		return a+b;
	}
	
	@WebMethod
	public int resta(int a, int b)
	{
		return a-b;
	}
	
	@WebMethod
	public int multiplicacion(int a, int b)
	{
		return a*b;
	}
	
	@WebMethod
	public double division (int a, int b)
	{
		return a/ (b*1.0);
	}

}
