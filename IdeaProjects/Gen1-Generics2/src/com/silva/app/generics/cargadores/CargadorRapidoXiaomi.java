package com.silva.app.generics.cargadores;

import com.silva.app.generics.celulares.CelularXiaomi;

public class CargadorRapidoXiaomi implements ICargador<CelularXiaomi>
{
    @Override
    public void cargar(CelularXiaomi celular)
    {
        System.out.println("Soy un cargador rapido de Xiaomi y la capacidad del cargador es de 67 watts");
        System.out.println("Estoy cargando un celular Xiaomi");
        System.out.println("tiempo de carga: " + celular.getCapacidadBateria() * 1.2);
        System.out.println("------------");
    }
}
