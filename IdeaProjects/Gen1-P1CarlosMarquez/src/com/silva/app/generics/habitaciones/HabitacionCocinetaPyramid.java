package com.silva.app.generics.habitaciones;

import com.silva.app.generics.hoteles.HotelPyramid;

public class HabitacionCocinetaPyramid implements IHabitacion<HotelPyramid>
{
    @Override
    public void reservar(HotelPyramid hotel)
    {
        System.out.println("Soy una habitacion con cocineta del Hotel Pyramid y estoy recibiendo una recervacion para el " + hotel.getDiaReserva());
    }
}
