package org.example;

import java.util.List;

public abstract class Alojamientos {
    private String nombre;
    private String ciudad;
    private String tipo;
    private Double calificacion;
    private List<Habitacion> habitaciones;

    public Alojamientos(String nombre, String ciudad, String tipo, Double calificacion, List<Habitacion> habitacion) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.tipo = tipo;
        this.calificacion = calificacion;
        this.habitaciones = habitacion;
    }

    public Alojamientos(String nombre, String ciudad, String tipo, Double calificacion) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.tipo = tipo;
        this.calificacion = calificacion;
    }

    abstract public void mostrarAlojamiento() ;

    public Alojamientos() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(List<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }
}
