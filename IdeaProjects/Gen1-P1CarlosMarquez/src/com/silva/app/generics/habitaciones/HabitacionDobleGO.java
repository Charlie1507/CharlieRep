package com.silva.app.generics.habitaciones;

import com.silva.app.generics.hoteles.HotelGrandOasis;

public class HabitacionDobleGO implements IHabitacion<HotelGrandOasis>
{

    @Override
    public void reservar(HotelGrandOasis hotel)
    {
        System.out.println("Soy una habitacion Doble del Hotel Gran Oasis y estoy recibiendo una recervacion para el " + hotel.getDiaReserva());
    }
}
