package com.silva.app.generics.cargadores;

import com.silva.app.generics.celulares.CelularApple;

public class CargadorCompactoApple implements ICargador<CelularApple>
{
    @Override
    public void cargar(CelularApple celular)
    {
        System.out.println("Soy un cargador compacto de Apple y la capacidad del cargador es de 35 watts");
        System.out.println("Estoy cargando un celular iPhone");
        System.out.println("tiempo de carga: " + celular.getCapacidadBateria()*2.7);
        System.out.println("------------");
    }
}
