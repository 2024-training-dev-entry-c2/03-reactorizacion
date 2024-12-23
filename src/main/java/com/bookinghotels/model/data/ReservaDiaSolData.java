package com.bookinghotels.model.data;

import com.bookinghotels.model.alojamiento.Alojamiento;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaDiaSolData {
  private Alojamiento alojamiento;
  private HuespedData huesped;
  private LocalDate fecha;
  private Integer cantPersonas;
  private LocalTime horaLlegada;

  public ReservaDiaSolData(Alojamiento alojamiento, HuespedData huesped, LocalDate fecha, Integer cantPersonas, LocalTime horaLlegada) {
    this.alojamiento = alojamiento;
    this.huesped = huesped;
    this.fecha = fecha;
    this.cantPersonas = cantPersonas;
    this.horaLlegada = horaLlegada;
  }

  public void mostrarDetalles(){
    Alojamiento alojamiento = (Alojamiento) this.alojamiento;
    System.out.println("Alojamiento: " + alojamiento.getNombre());
    System.out.println("Huesped: " + huesped.getNombre() + " " + huesped.getApellido());
    System.out.println("Día de sol");
    System.out.println("Cantidad de reservas compradas: " + cantPersonas);
    System.out.println("Hora llegada: " + this.horaLlegada);
  }

  public Alojamiento getAlojamiento() {
    return alojamiento;
  }

  public void setAlojamiento(Alojamiento alojamiento) {
    this.alojamiento = alojamiento;
  }

  public HuespedData getHuesped() {
    return huesped;
  }

  public void setHuesped(HuespedData huesped) {
    this.huesped = huesped;
  }

  public LocalDate getFecha() {
    return fecha;
  }

  public void setFecha(LocalDate fecha) {
    this.fecha = fecha;
  }

  public Integer getCantPersonas() {
    return cantPersonas;
  }

  public void setCantPersonas(Integer cantPersonas) {
    this.cantPersonas = cantPersonas;
  }
}
