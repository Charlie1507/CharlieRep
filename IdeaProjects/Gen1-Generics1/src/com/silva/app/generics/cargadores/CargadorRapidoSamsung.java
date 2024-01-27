package com.silva.app.generics.cargadores;

import com.silva.app.generics.celulares.CelularSamsung;

public class CargadorRapidoSamsung implements ISamsungCargador
{
    @Override
    public void cargar(CelularSamsung celular)
    {
        System.out.println("Soy un cargador rapido de Samsung y la capacidad del cargador es de 76 watts");
        System.out.println("Estoy cargando un celular Samsung");
        System.out.println("tiempo de carga: " + celular.getCapacidadBateria()*0.9);
        System.out.println("------------");
    }
}
