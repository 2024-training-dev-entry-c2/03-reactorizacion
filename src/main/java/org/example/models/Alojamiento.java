package org.example.models;

import java.util.List;

public abstract class Alojamiento {
    private String nombre;
    private String ubicacion;
    private float calificacion;
    private List<Habitacion> habitaciones;

    public Alojamiento() {
    }

    public Alojamiento(String nombre, String ubicacion, float calificacion, List<Habitacion> habitaciones) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.calificacion = calificacion;
        this.habitaciones = habitaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(List<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public abstract void mostrarInfo();
}
