package com.silva.app.p3cams.models;

import java.time.LocalDate;

public class Mantenimiento
{
    private Long id;
    private Long  propiedadId;
    private String descripcion;
    private Float costo;
    private LocalDate fechaReporte;
    private Boolean estadoFinalizado;

    private String direccionPropiedad;

    public String getDireccionPropiedad() {
        return direccionPropiedad;
    }

    public void setDireccionPropiedad(String direccionPropiedad) {
        this.direccionPropiedad = direccionPropiedad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPropiedadId() {
        return propiedadId;
    }

    public void setPropiedadId(Long propiedadId) {
        this.propiedadId = propiedadId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public LocalDate getFechaReporte() {
        return fechaReporte;
    }

    public void setFechaReporte(LocalDate fechaReporte) {
        this.fechaReporte = fechaReporte;
    }

    public Boolean getEstadoFinalizado() {
        return estadoFinalizado;
    }

    public void setEstadoFinalizado(Boolean estadoFinalizado) {
        this.estadoFinalizado = estadoFinalizado;
    }
}
