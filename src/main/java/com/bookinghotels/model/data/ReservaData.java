package com.bookinghotels.model.data;

import com.bookinghotels.model.alojamiento.Alojamiento;
import com.bookinghotels.model.alojamiento.Habitacion;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ReservaData<T> {
  private T alojamiento;
  private HuespedData huesped;
  private LocalDate fechaInicio;
  private LocalDate fechaFin;
  private LocalTime horaLlegada;
  private List<Habitacion> habitacionesReservadas;

  public ReservaData(T alojamiento, HuespedData huesped, LocalDate fechaInicio, LocalDate fechaFin, LocalTime horaLlegada, List<Habitacion> habitacionesReservadas) {
    this.alojamiento = alojamiento;
    this.huesped = huesped;
    this.fechaInicio = fechaInicio;
    this.fechaFin = fechaFin;
    this.horaLlegada = horaLlegada;
    this.habitacionesReservadas = habitacionesReservadas;
  }

  public ReservaData(){
  }

  public void mostrarDetalles(){
    Alojamiento alojamiento = (Alojamiento) this.alojamiento;
    System.out.println("Alojamiento: " + alojamiento.getNombre());
    System.out.println("Huesped: " + huesped.getNombre() + " " + huesped.getApellido());
    System.out.println("Hora llegada: " + this.horaLlegada);
     mostrarHabitaciones(alojamiento);
  }

  public void mostrarHabitaciones(Alojamiento alojamiento){
    if(!alojamiento.getHabitaciones().isEmpty()){
      alojamiento.getHabitaciones().forEach(habitacion -> System.out.println("- " + habitacion.getTipo() + "\n"));
    }
  }

  public T getAlojamiento() {
    return alojamiento;
  }

  public void setAlojamiento(T alojamiento) {
    this.alojamiento = alojamiento;
  }

  public HuespedData getHuesped() {
    return huesped;
  }

  public LocalDate getFechaInicio() {
    return fechaInicio;
  }

  public void setFechaInicio(LocalDate fechaInicio) {
    this.fechaInicio = fechaInicio;
  }

  public LocalDate getFechaFin() {
    return fechaFin;
  }

  public List<Habitacion> getHabitacionesReservadas() {
    return habitacionesReservadas;
  }

  public void setHabitacionesReservadas(List<Habitacion> habitacionesReservadas) {
    this.habitacionesReservadas = habitacionesReservadas;
  }

}
