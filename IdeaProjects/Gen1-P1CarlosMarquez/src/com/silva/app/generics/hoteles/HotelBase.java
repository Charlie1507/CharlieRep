package com.silva.app.generics.hoteles;

import com.silva.app.generics.enums.DiaSemana;
import com.silva.app.generics.enums.Evento;

public abstract class HotelBase
{
    private String direccion;
    private Integer numeroHabitaciones;
    private DiaSemana diaReserva;


    public abstract void checkIn();
    public abstract void checkOut();
}
