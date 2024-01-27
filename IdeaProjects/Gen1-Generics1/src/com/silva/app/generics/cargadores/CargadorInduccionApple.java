package com.silva.app.generics.cargadores;

import com.silva.app.generics.celulares.CelularApple;

public class CargadorInduccionApple implements IAppleCargador
{
    @Override
    public void cargar(CelularApple celular)
    {
        System.out.println("Soy un cargador de induccion de Apple y la capacidad del cargador es de 15 watts");
        System.out.println("Estoy cargando un celular iPhone");
        System.out.println("tiempo de carga: " + celular.getCapacidadBateria()*4.5);
        System.out.println("------------");
    }
}
