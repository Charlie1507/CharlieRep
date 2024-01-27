package com.silva.app.generics.cargadores;

import com.silva.app.generics.celulares.CelularSamsung;
import com.silva.app.generics.celulares.CelularXiaomi;

public class CargadorNormalSamsung implements ICargador<CelularSamsung>
{
    @Override
    public void cargar(CelularSamsung celular)
    {
        System.out.println("Soy un cargador normal de Samsung y la capacidad del cargador es de 48 watts");
        System.out.println("Estoy cargando un celular Samsung");
        System.out.println("tiempo de carga: " + celular.getCapacidadBateria()*3.2);
        System.out.println("------------");
    }
}
