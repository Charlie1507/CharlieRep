package com.silva.app.generics.cargadores;

import com.silva.app.generics.celulares.CelularSamsung;

public class CargadorInduccionSamsung implements ISamsungCargador
{
    @Override
    public void cargar(CelularSamsung celular)
    {
        System.out.println("Soy un cargador de induccion de Samsung y la capacidad del cargador es de 20 watts");
        System.out.println("Estoy cargando un celular Samsung");
        System.out.println("tiempo de carga: " + celular.getCapacidadBateria()*4.1);
        System.out.println("------------");
    }
}
