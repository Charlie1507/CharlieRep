package com.silva.app.proyecto1.habitaciones;

import com.silva.app.proyecto1.enums.DiaSemana;
import com.silva.app.proyecto1.enums.Mes;

public class HabitacionSuite
{
    private Mes mesReserva;
    private Integer numeroCamas;
    private Integer diareserva;
    private DiaSemana diaSemana;
    private Integer numhab;

    public HabitacionSuite()
    {

    }

    public Mes getMesReserva() {
        return mesReserva;
    }

    public void setMesReserva(Mes mesReserva) {
        this.mesReserva = mesReserva;
    }

    public Integer getNumeroCamas() {
        return numeroCamas;
    }

    public void setNumeroCamas(Integer numeroCamas) {
        this.numeroCamas = numeroCamas;
    }

    public Integer getDiareserva() {
        return diareserva;
    }

    public void setDiareserva(Integer diareserva) {
        this.diareserva = diareserva;
    }

    public DiaSemana getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DiaSemana diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Integer getNumhab() {
        return numhab;
    }

    public void setNumhab(Integer numhab) {
        this.numhab = numhab;
    }
}
