package org.example;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public class Habitacion {
    private String tipo;
    private String descripcion;
    private double precio;
    private Integer capacidadMaxPersonas;
    private List<ReservaData<?>> reservas;
    private int numeroHabitaciones;

    public Habitacion(String tipo, String descripcion, double precio, Integer capacidadMaxPersonas, int numeroHabitaciones) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.capacidadMaxPersonas = capacidadMaxPersonas;
        this.numeroHabitaciones = numeroHabitaciones;
    }

    public Habitacion(String tipo, String descripcion, double precio, List<ReservaData<?>> reservas, Integer capacidadMaxPersonas, int numeroHabitaciones) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.reservas = reservas;
        this.capacidadMaxPersonas = capacidadMaxPersonas;
        this.numeroHabitaciones = numeroHabitaciones;
    }

    public Habitacion() {
    }

    public boolean estaDisponible(LocalDate fechaIngreso, LocalDate fechaSalida) {
        for (ReservaData<?> reserva : reservas) {
            if (!(fechaSalida.isBefore(reserva.getFechaIngreso()) || fechaIngreso.isAfter(reserva.getFechaSalida()))) {
                return false;
            }
        }
        return true;
    }

    public void agregarReserva(ReservaData<?> reserva) {
        reservas.add(reserva);
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


    public Integer getcapacidadMaxPersonas() {
        return capacidadMaxPersonas;
    }

    public void setcapacidadMaxPersonas(Integer capacidadMaxPersonas) {
        this.capacidadMaxPersonas = capacidadMaxPersonas;
    }


    public Integer getCapacidadMaxPersonas() {
        return capacidadMaxPersonas;
    }

    public void setCapacidadMaxPersonas(Integer capacidadMaxPersonas) {
        this.capacidadMaxPersonas = capacidadMaxPersonas;
    }

    public List<ReservaData<?>> getReservas() {
        return reservas;
    }

    public void setReservas(List<ReservaData<?>> reservas) {
        this.reservas = reservas;
    }

    public int getNumeroHabitaciones() {
        return numeroHabitaciones;
    }

    public void setNumeroHabitaciones(int numeroHabitaciones) {
        this.numeroHabitaciones = numeroHabitaciones;
    }
}
