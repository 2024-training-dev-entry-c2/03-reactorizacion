package org.example;

import java.util.List;

public class Hotel extends Alojamientos {
    private DiaSol diaSol;

    public Hotel(String nombre, String ciudad, String tipo, double calificacion, List<Habitacion> habitacion) {
        super(nombre, ciudad, tipo, calificacion, habitacion);
    }

    public Hotel(String nombre, String ciudad, String tipo, double calificacion, List<Habitacion> habitacion, DiaSol diaSol) {
        super(nombre, ciudad, tipo, calificacion, habitacion);
        this.diaSol = diaSol;
    }

    public Hotel() {
    }

    @Override
    public void mostrarAlojamiento() {
        System.out.println(getCiudad() + ":" + getTipo());
        System.out.println("-----------------------------------------------------------");
        System.out.println("Ciudad Seleccionada: " + getCiudad());
        System.out.println("Nombre: " + getNombre());
        System.out.println((diaSol != null) ? "Precio: " + diaSol.getPrecio() : "Precio: " + getHabitaciones().get(0).getPrecio());
        System.out.println("Calificación: " + getCalificacion() + "⭐");
        System.out.println((diaSol != null) ? "Información de DiaSol: " + diaSol.getActividades() : "No hay información de DiaSol disponible.");
    }

    public DiaSol getDiaSol() {
        return diaSol;
    }

    public void setDiaSol(DiaSol diaSol) {
        this.diaSol = diaSol;
    }
}
