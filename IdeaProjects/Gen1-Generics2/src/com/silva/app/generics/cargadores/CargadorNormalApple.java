package com.silva.app.generics.cargadores;

import com.silva.app.generics.celulares.CelularApple;

public class CargadorNormalApple implements ICargador<CelularApple>
{
    @Override
    public void cargar(CelularApple celular)
    {
        System.out.println("Soy un cargador normal de apple y la capacidad del cargador es de 20 watts");
        System.out.println("Estoy cargando un celular iPhone");
        System.out.println("tiempo de carga: " + celular.getCapacidadBateria()*3.6);
        System.out.println("------------");

    }
}
