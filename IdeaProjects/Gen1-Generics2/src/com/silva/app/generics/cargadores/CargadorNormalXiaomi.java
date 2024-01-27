package com.silva.app.generics.cargadores;

import com.silva.app.generics.celulares.CelularXiaomi;

public class CargadorNormalXiaomi implements ICargador<CelularXiaomi>
{
    @Override
    public void cargar(CelularXiaomi celular)
    {
        System.out.println("Soy un cargador normal de Xiaomi y la capacidad del cargador es de 35 watts");
        System.out.println("Estoy cargando un celular Xiaomi");
        System.out.println("tiempo de carga: " + celular.getCapacidadBateria()*2.7);
        System.out.println("------------");
    }
}
