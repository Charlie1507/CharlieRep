package com.silva.app.generics.hoteles;

import com.silva.app.generics.enums.DiaSemana;
import com.silva.app.generics.enums.Evento;

public class HotelGrandOasis
{
    private String direccion;
    private Boolean alberca;
    private Boolean kidClub;
    private Integer numeroHabitaciones;
    private DiaSemana diaReserva;
    private Boolean salon;
    private Evento evento;

    public void evento (Evento reserva,DiaSemana dreserva)
    {
        if(salon==true)
        {
            System.out.println("Tengo una reserva en mi salon para el proximo evento: " + reserva + " para el dia " + dreserva);
        }
        else
        {
            System.out.println("No tengo disponibilidad para el evento: " + reserva + " para el dia " + dreserva);
        }
    }

    public HotelGrandOasis()
    {

    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Boolean getAlberca() {
        return alberca;
    }

    public void setAlberca(Boolean alberca) {
        this.alberca = alberca;
    }

    public Boolean getKidClub() {
        return kidClub;
    }

    public void setKidClub(Boolean kidClub) {
        this.kidClub = kidClub;
    }

    public Integer getNumeroHabitaciones() {
        return numeroHabitaciones;
    }

    public void setNumeroHabitaciones(Integer numeroHabitaciones) {
        this.numeroHabitaciones = numeroHabitaciones;
    }

    public DiaSemana getDiaReserva() {
        return diaReserva;
    }

    public void setDiaReserva(DiaSemana diaReserva) {
        this.diaReserva = diaReserva;
    }

    public Boolean getSalon() {
        return salon;
    }

    public void setSalon(Boolean salon) {
        this.salon = salon;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
