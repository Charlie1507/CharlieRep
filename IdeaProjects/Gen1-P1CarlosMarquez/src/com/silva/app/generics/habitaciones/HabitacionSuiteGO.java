package com.silva.app.generics.habitaciones;

import com.silva.app.generics.hoteles.HotelGrandOasis;
import com.silva.app.generics.hoteles.HotelPyramid;

public class HabitacionSuiteGO implements IHabitacion<HotelGrandOasis>
{

    @Override
    public void reservar(HotelGrandOasis hotel)
    {
        System.out.println("Soy una habitacion Suite del Hotel Gran Oasis y estoy recibiendo una recervacion para el " + hotel.getDiaReserva());
    }
}
