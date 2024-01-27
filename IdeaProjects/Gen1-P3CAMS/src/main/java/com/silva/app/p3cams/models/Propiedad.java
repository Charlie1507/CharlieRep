package com.silva.app.p3cams.models;

public class Propiedad
{
    private Long id;
    private String direccion;
    private Long duenioId;
    private Boolean disponibilidad;
    private String tipoPropiedad;
    private Float precio;
    private String duenioNombre;

    public String getDuenioNombre() {
        return duenioNombre;
    }

    public void setDuenioNombre(String duenioNombre) {
        this.duenioNombre = duenioNombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Long getDuenioId() {
        return duenioId;
    }

    public void setDuenioId(Long duenioId) {
        this.duenioId = duenioId;
    }

    public Boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getTipoPropiedad() {
        return tipoPropiedad;
    }

    public void setTipoPropiedad(String tipoPropiedad) {
        this.tipoPropiedad = tipoPropiedad;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }
}
