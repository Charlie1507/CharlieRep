package com.silva.app.generics.cargadores;

import com.silva.app.generics.celulares.CelularApple;

public interface ICargador <T>
{
    public void cargar (T dispositivo);

}
