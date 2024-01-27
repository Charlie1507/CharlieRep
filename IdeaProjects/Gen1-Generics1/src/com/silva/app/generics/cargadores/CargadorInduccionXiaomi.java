package com.silva.app.generics.cargadores;

import com.silva.app.generics.celulares.CelularXiaomi;

public class CargadorInduccionXiaomi implements IXiaomiCargador
{
    @Override
    public void cargar(CelularXiaomi celular)
    {
        System.out.println("Soy un cargador de induccion de Xiaomi y la capacidad del cargador es de 25 watts");
        System.out.println("Estoy cargando un celular Xiaomi");
        System.out.println("tiempo de carga: " + celular.getCapacidadBateria()*3.8);
        System.out.println("------------");
    }
}
