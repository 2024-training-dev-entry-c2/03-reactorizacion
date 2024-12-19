package org.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Locale;

public class Habitacion {
    private String tipo;
    private String descripcion;
    private Double precio;
    private Integer capacidadMaxPersonas;
    private List<ReservaData<?>> reservas;
    private Integer numeroHabitaciones;

    public Habitacion(String tipo, String descripcion, double precio, Integer capacidadMaxPersonas, Integer numeroHabitaciones) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.capacidadMaxPersonas = capacidadMaxPersonas;
        this.numeroHabitaciones = numeroHabitaciones;
    }

    public Habitacion(String tipo, String descripcion, double precio, List<ReservaData<?>> reservas, Integer capacidadMaxPersonas, Integer numeroHabitaciones) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.reservas = reservas;
        this.capacidadMaxPersonas = capacidadMaxPersonas;
        this.numeroHabitaciones = numeroHabitaciones;
    }

    public Habitacion() {
    }

    public void cancelado() {
        capacidadMaxPersonas++;
    }

    public void mostrarHabitacion(Integer cantidadHabitaciones, LocalDate diaInicio, LocalDate diaFinal) {
        System.out.println("Habitaciones en " + getTipo() + ":");
        System.out.println("*********************************************************");
        System.out.println("Tipo: " + getTipo());
        System.out.println("Descripción: " + getTipo());
        Double precio = calcularPrecio(diaInicio, diaFinal, cantidadHabitaciones, getPrecio());
        setPrecio(precio);
    }

    public Double calcularPrecio(LocalDate diaInicio, LocalDate diaFin, int cantidadHabitaciones, double precioHabitacion) {
        long noches = ChronoUnit.DAYS.between(diaInicio, diaFin) + 1; // Calcula las noches
        double precioTotal = precioHabitacion * noches * cantidadHabitaciones;

        double aumentoDesc = obtenerAumentoDesc(diaInicio, diaFin);
        double precioFinal = precioTotal * (1 + aumentoDesc);

        System.out.println("Precio total: $" + precioTotal);
        System.out.println("Aumento/Descuento aplicado: " + (aumentoDesc * 100) + "%");
        System.out.println("Precio final: $" + precioFinal);
        return precioFinal;
    }

    private static Double obtenerAumentoDesc(LocalDate diaInicio, LocalDate diaFin) {
        int diaFinMes = diaFin.getDayOfMonth(); // Obtener el día del mes
        int diaInicioMes = diaInicio.getDayOfMonth();

        if (diaFinMes >= 25) {
            return 0.15; // Aumento del 15%
        } else if (diaInicioMes >= 10 && diaFinMes <= 15) {
            return 0.10; // Aumento del 10%
        } else if (diaInicioMes >= 5 && diaFinMes <= 10) {
            return -0.08; // Descuento del 8%
        }
        return 0.0;
    }


    public Boolean estaDisponible(LocalDate fechaIngreso, LocalDate fechaSalida) {
//        for (ReservaData<?> reserva : reservas) {
//            if (!(fechaSalida.isBefore(reserva.getFechaIngreso()) || fechaIngreso.isAfter(reserva.getFechaSalida()))) {
//                return false;
//            }
//        }
        return false;
    }

    public void agregarReserva(ReservaData reserva) {
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
