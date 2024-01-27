package com.silva.app.proyecto1.reservaciones;

import com.silva.app.proyecto1.habitaciones.HabitacionSuite;

public class ReservacionDigitalSuite implements IReservacion<HabitacionSuite>
{
    @Override
    public void reservarHabitacion(HabitacionSuite habitacion)
    {
        System.out.println("Estoy reservando en linea para una habitacion Suite para el mes " + habitacion.getMesReserva() +
                " en el dia " + habitacion.getDiareserva());
    }
}
