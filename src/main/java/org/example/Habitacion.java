package org.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Habitacion {
    private String tipo;
    private String descripcion;
    private Double precio;
    private Integer capacidadMaxPersonas;
    private List<ReservaData> reservas;
    private Integer numeroHabitaciones;

    public Habitacion(String tipo, String descripcion, Double precio, Integer capacidadMaxPersonas, Integer numeroHabitaciones) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.capacidadMaxPersonas = capacidadMaxPersonas;
        this.numeroHabitaciones = numeroHabitaciones;
    }

    public Habitacion(String tipo, String descripcion, Double precio, List<ReservaData> reservas, Integer capacidadMaxPersonas, Integer numeroHabitaciones) {
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
        numeroHabitaciones++;
    }

    public void mostrarHabitacion(Integer cantidadHabitaciones, LocalDate diaInicio, LocalDate diaFinal) {
        System.out.println("Habitaciones en " + getTipo() + ":");
        System.out.println("*********************************************************");
        System.out.println("Tipo: " + getTipo());
        System.out.println("Descripción: " + getTipo());
        Double precio = calcularPrecio(diaInicio, diaFinal, cantidadHabitaciones, getPrecio());
        setPrecio(precio);
    }

    public Double calcularPrecio(LocalDate diaInicio, LocalDate diaFin, Integer cantidadHabitaciones, Double precioHabitacion) {
        Long noches = ChronoUnit.DAYS.between(diaInicio, diaFin) + 1;
        Double precioTotal = precioHabitacion * noches * cantidadHabitaciones;
        Double aumentoDesc = obtenerAumentoDesc(diaInicio, diaFin);
        Double precioFinal = precioTotal * (1 + aumentoDesc);
        System.out.println("Precio total: $" + precioTotal);
        System.out.println("Aumento/Descuento aplicado: " + (aumentoDesc * 100) + "%");
        System.out.println("Precio final: $" + precioFinal);
        return precioFinal;
    }

    private static Double obtenerAumentoDesc(LocalDate diaInicio, LocalDate diaFin) {
        Integer diaFinMes = diaFin.getDayOfMonth(); // Obtener el día del mes
        Integer diaInicioMes = diaInicio.getDayOfMonth();

        if (diaFinMes >= 25) {
            return 0.15; // Aumento del 15%
        } else if (diaInicioMes >= 10 && diaFinMes <= 15) {
            return 0.10; // Aumento del 10%
        } else if (diaInicioMes >= 5 && diaFinMes <= 10) {
            return -0.08; // Descuento del 8%
        }
        return 0.0;
    }

    public Boolean maxPersonas(Integer cantidadAdultos, Integer cantidadNinos){
        if ((cantidadAdultos+cantidadNinos)> capacidadMaxPersonas){
            return false;
        }
        return true;

    }


    public Boolean estaDisponible(LocalDate fechaIngreso, LocalDate fechaSalida,Integer cantidadRequerida) {
        if (reservas == null) {
            reservas = new ArrayList<>();
        }
        Integer habitacionesOcupadas = 0;
        for (ReservaData reserva : reservas) {
            if (!(fechaSalida.isBefore(reserva.getFechaIngreso()) || fechaIngreso.isAfter(reserva.getFechaSalida()))) {
                habitacionesOcupadas++;
            }
        }

        return (numeroHabitaciones - habitacionesOcupadas) >= cantidadRequerida;
    }

    public void agregarReserva(ReservaData reserva, Integer cantidadRequerida) {
        if (estaDisponible(reserva.getFechaIngreso(), reserva.getFechaSalida(), cantidadRequerida)) {
            reservas.add(reserva);
            numeroHabitaciones -= cantidadRequerida;
            System.out.println("Reserva añadida correctamente. Habitaciones restantes: " + numeroHabitaciones);
        } else {
            System.out.println("No se puede agregar la reserva: No hay suficientes habitaciones disponibles.");
        }
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
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

    public List<ReservaData> getReservas() {
        return reservas;
    }

    public void setReservas(List<ReservaData> reservas) {
        this.reservas = reservas;
    }

    public Integer getNumeroHabitaciones() {
        return numeroHabitaciones;
    }

    public void setNumeroHabitaciones(Integer numeroHabitaciones) {
        this.numeroHabitaciones = numeroHabitaciones;
    }
}
