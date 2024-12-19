package com.booking.Models.Habitacion;

import java.util.List;

public class Habitacion {

    private List<String> tipoDeHabitacion;
    private double precio;
    private String descripcion;
    private boolean disponibilidad;
    private int cantidadMenores;
    private int cantidadAdultos;
    private double precioBase;

    public Habitacion() {
    }

    public Habitacion(List<String> tipoDeHabitacion, double precio, String descripcion, boolean disponibilidad,
                      int cantidadMenores, int cantidadAdultos, double precioBase) {
        this.tipoDeHabitacion = tipoDeHabitacion;
        this.precio = precio;
        this.descripcion = descripcion;
        this.disponibilidad = disponibilidad;
        this.cantidadMenores = cantidadMenores;
        this.cantidadAdultos = cantidadAdultos;
        this.precioBase = precioBase;
    }


    @Override
    public String toString() {
        return "Habitacion:\n" +
                "  Tipo de Habitación: " + tipoDeHabitacion + "\n" +
                "  Descripción: " + descripcion + "\n" +
                "  Precio Base: $" + precioBase + "\n" +
                "  Precio Total: $" + precio + "\n" +
                "  Disponibilidad: " + (disponibilidad ? "Disponible" : "No Disponible") + "\n" +
                "  Capacidad: " + cantidadAdultos + " adultos, " + cantidadMenores + " menores";
    }

    public List<String> getTipoDeHabitacion() {
        return tipoDeHabitacion;
    }

    public double getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public int getCantidadMenores() {
        return cantidadMenores;
    }

    public int getCantidadAdultos() {
        return cantidadAdultos;
    }
}