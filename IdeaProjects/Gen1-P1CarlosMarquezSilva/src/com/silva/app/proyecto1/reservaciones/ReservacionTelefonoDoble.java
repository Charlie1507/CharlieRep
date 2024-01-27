package com.silva.app.proyecto1.reservaciones;

import com.silva.app.proyecto1.habitaciones.HabitacionDoble;

public class ReservacionTelefonoDoble implements IReservacion<HabitacionDoble>
{
    @Override
    public void reservarHabitacion(HabitacionDoble habitacion)
    {
        System.out.println("Estoy reservando por telefono para una habitacion doble para el mes " + habitacion.getMesReserva() +
                " en el dia " + habitacion.getDiareserva());
    }
}
