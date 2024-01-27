package com.silva.app.proyecto1.reservaciones;

import com.silva.app.proyecto1.habitaciones.HabitacionSuite;

public class ReservacionFisicoSuite implements IReservacion<HabitacionSuite>
{
    @Override
    public void reservarHabitacion(HabitacionSuite habitacion)
    {
        System.out.println("Estoy reservando en fisico para una habitacion suite para el mes " + habitacion.getMesReserva() +
                " en el dia " + habitacion.getDiareserva());
    }
}
