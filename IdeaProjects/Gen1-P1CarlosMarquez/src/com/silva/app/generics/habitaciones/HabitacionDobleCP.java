package com.silva.app.generics.habitaciones;

import com.silva.app.generics.hoteles.HotelCrownParadise;

public class HabitacionDobleCP implements IHabitacion<HotelCrownParadise>
{
    @Override
    public void reservar(HotelCrownParadise hotel)
    {
        System.out.println("Soy una habitacion Doble del Hotel Crown Paradise y estoy recibiendo una recervacion para el" + hotel.getDiaReserva());
    }
}
