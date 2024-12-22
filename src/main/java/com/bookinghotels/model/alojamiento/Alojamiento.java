package com.bookinghotels.model.alojamiento;

import com.bookinghotels.constants.Categoria;
import com.bookinghotels.model.data.ReservaData;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Alojamiento {
  protected String nombre;
  protected String ciudad;
  protected Categoria categoria;
  protected Float calificacion;
  protected Integer maxPersonas;
  protected List<Habitacion> habitaciones;

  public Alojamiento(String nombre, String ciudad, Categoria categoria, Float calificacion, Integer maxPersonas) {
    this.nombre = nombre;
    this.ciudad = ciudad;
    this.categoria = categoria;
    this.calificacion = calificacion;
    this.maxPersonas = maxPersonas;
    habitaciones = new ArrayList<>();
  }

  public Alojamiento() {
  }

  public abstract boolean estaDisponible(LocalDate fechaInicio, LocalDate fechaFin, Integer cantPersonas, Integer cantHabitaciones, List<ReservaData<?>> reservas);

  public abstract void getDetalles();

  public void agregarHabitacion(Habitacion habitacion) {
    habitaciones.add(habitacion);
  }

  public boolean cumpleCapacidad(Integer cantPersonas) {
    return cantPersonas <= this.maxPersonas;
  }

  public boolean noHayConflictoDeFechas(LocalDate fechaInicio, LocalDate fechaFin, List<ReservaData<?>> reservas) {
    return reservas.stream().allMatch(reserva ->
      fechaFin.isBefore(reserva.getFechaInicio()) || fechaInicio.isAfter(reserva.getFechaFin())
    );
  }

  public List<Habitacion> obtenerHabitacionesDisponibles(LocalDate fechaInicio, LocalDate fechaFin, List<ReservaData<?>> reservas) {
    return habitaciones.stream()
      .filter(habitacion -> habitacion.estaDisponible(fechaInicio, fechaFin, reservas))
      .collect(Collectors.toList());
  }

  //Getters y Setters
  public void getDetallesBasicos() {
    System.out.println(this.nombre);
    System.out.println("Calificación: " + this.calificacion);
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

  public Categoria getCategoria() {
    return categoria;
  }

  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
  }

  public Float getCalificacion() {
    return calificacion;
  }

  public void setCalificacion(Float calificacion) {
    this.calificacion = calificacion;
  }

  public Integer getMaxPersonas() {
    return maxPersonas;
  }

  public void setMaxPersonas(Integer maxPersonas) {
    this.maxPersonas = maxPersonas;
  }

  public List<Habitacion> getHabitaciones() {
    return habitaciones;
  }

  public void setHabitaciones(List<Habitacion> habitaciones) {
    this.habitaciones = habitaciones;
  }
}
