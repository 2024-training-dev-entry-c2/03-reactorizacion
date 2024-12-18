package org.example;

public class Habitacion {
    private String tipo;
    private String descripcion;
    private double precio;
    private Integer disponibles;
    private Integer capacidadMaxPersonas;

    //disponibilidad?

    public Habitacion(String tipo, String descripcion, double precio, Integer disponibles, Integer capacidadMaxPersonas) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.disponibles = disponibles;
        this.capacidadMaxPersonas = capacidadMaxPersonas;
    }

    public Habitacion() {
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Integer getDisponibles() {
        return disponibles;
    }

    public void setDisponibles(Integer disponibles) {
        this.disponibles = disponibles;
    }

    public Integer getcapacidadMaxPersonas() {
        return capacidadMaxPersonas;
    }

    public void setcapacidadMaxPersonas(Integer capacidadMaxPersonas) {
        this.capacidadMaxPersonas = capacidadMaxPersonas;
    }
}
