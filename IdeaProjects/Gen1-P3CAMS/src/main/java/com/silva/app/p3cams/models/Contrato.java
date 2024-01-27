package com.silva.app.p3cams.models;

public class Contrato
{
    private Long id;
    private Long propiedadId;
    private Long duenioId;
    private Long inquilinoId;
    private Integer duracion;
    private String tipoContrato;
    private String direccionPropiedad;
    private String nombreInquilino;

    public String getDireccionPropiedad() {
        return direccionPropiedad;
    }

    public void setDireccionPropiedad(String direccionPropiedad) {
        this.direccionPropiedad = direccionPropiedad;
    }

    public String getNombreInquilino() {
        return nombreInquilino;
    }

    public void setNombreInquilino(String nombreInquilino) {
        this.nombreInquilino = nombreInquilino;
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

    public Long getDuenioId() {
        return duenioId;
    }

    public void setDuenioId(Long dueñoId) {
        this.duenioId = dueñoId;
    }

    public Long getInquilinoId() {
        return inquilinoId;
    }

    public void setInquilinoId(Long inquilinoId) {
        this.inquilinoId = inquilinoId;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }
}
