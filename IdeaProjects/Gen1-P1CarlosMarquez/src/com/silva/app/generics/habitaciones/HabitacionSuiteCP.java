package com.silva.app.generics.habitaciones;

import com.silva.app.generics.hoteles.HotelCrownParadise;
import com.silva.app.generics.hoteles.HotelEmporio;

public class HabitacionSuiteCP implements IHabitacion<HotelCrownParadise>
{

    @Override
    public void reservar(HotelCrownParadise hotel)
    {
        System.out.println("Soy una habitacion Suite del Hotel Crown Paradise y estoy recibiendo una recervacion para el" + hotel.getDiaReserva());
    }
}
