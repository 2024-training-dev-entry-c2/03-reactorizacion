package com.bookinghotels.model.alojamiento;


import com.bookinghotels.model.data.ReservaData;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

public class Habitacion {
  private String tipo;
  private String descripcion;
  private Float precioPorNoche;
  private Integer habitacionesDisponibles;
  private Integer capacidad;

  public Habitacion(String tipo, String descripcion, Float precioPorNoche, Integer habitacionesDisponibles, Integer capacidad) {
    this.tipo = tipo;
    this.descripcion = descripcion;
    this.precioPorNoche = precioPorNoche;
    this.habitacionesDisponibles = habitacionesDisponibles;
    this.capacidad = capacidad;
  }

  public Habitacion(){
  }

  public void mostrarDetalles() {
    System.out.println("\n+--------- " + tipo + " ---------+");
    System.out.println(descripcion);
    System.out.println("Precio por noche: $" + precioPorNoche);
    System.out.println("Capacidad para " + capacidad + " personas");
    System.out.println("+-----------------------------------+");
  }

  public boolean estaDisponible(LocalDate fechaInicio, LocalDate fechaFin, List<ReservaData<?>> reservas) {
    long habitacionesOcupadas = reservas.stream()
      .filter(reserva -> tieneHabitacionesOcupadasEnRango(fechaInicio, fechaFin, reserva))
      .flatMap(this::obtenerHabitacionesDeReserva)
      .filter(this::esHabitacionTipoDeseado)
      .count();
    return habitacionesOcupadas < habitacionesDisponibles;
  }

  private boolean tieneHabitacionesOcupadasEnRango(LocalDate fechaInicio, LocalDate fechaFin, ReservaData<?> reserva) {
    return fechaInicio.isBefore(reserva.getFechaFin()) && fechaFin.isAfter(reserva.getFechaInicio());
  }

  private Stream<Habitacion> obtenerHabitacionesDeReserva(ReservaData<?> reserva) {
    return reserva.getHabitacionesReservadas().stream().filter(this::esHabitacionTipoDeseado);
  }

  private boolean esHabitacionTipoDeseado(Habitacion habitacion) {
    return habitacion.getTipo().equalsIgnoreCase(this.tipo);
  }

  public String getTipo() {
    return tipo;
  }

  public Float getPrecioPorNoche() {
    return precioPorNoche;
  }
}
