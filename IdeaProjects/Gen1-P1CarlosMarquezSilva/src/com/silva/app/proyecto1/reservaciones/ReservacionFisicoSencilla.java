package com.silva.app.proyecto1.reservaciones;

import com.silva.app.proyecto1.habitaciones.HabitacionSencilla;

public class ReservacionFisicoSencilla implements IReservacion<HabitacionSencilla>
{
    @Override
    public void reservarHabitacion(HabitacionSencilla habitacion)
    {
        System.out.println("Estoy reservando en fisico para una habitacion Sencilla para el mes " + habitacion.getMesReserva() +
                " en el dia " + habitacion.getDiareserva());
    }
}
