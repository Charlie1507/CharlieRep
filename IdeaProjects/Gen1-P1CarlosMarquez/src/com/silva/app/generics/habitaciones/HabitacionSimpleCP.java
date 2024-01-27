package com.silva.app.generics.habitaciones;

import com.silva.app.generics.hoteles.HotelCrownParadise;

public class HabitacionSimpleCP implements IHabitacion<HotelCrownParadise>
{
    @Override
    public void reservar(HotelCrownParadise hotel)
    {
        System.out.println("Soy una habitacion Simple del Hotel Crown Paradise y estoy recibiendo una recervacion para el " + hotel.getDiaReserva());
    }
}
