package com.silva.app.generics.habitaciones;

import com.silva.app.generics.hoteles.HotelEmporio;

public class HabitacionSimpleEmporio implements IHabitacion<HotelEmporio>
{

    @Override
    public void reservar(HotelEmporio hotel)
    {
        System.out.println("Soy una habitacion Doble del Hotel Emporio y estoy recibiendo una recervacion para el " + hotel.getDiaReserva());
    }
}
