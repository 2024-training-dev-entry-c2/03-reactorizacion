package com.bookinghotels.model.alojamiento;

import com.bookinghotels.constants.Categoria;
import com.bookinghotels.model.data.ReservaData;

import java.time.LocalDate;
import java.util.List;

public class Apartamento extends Alojamiento {
  private String torre;
  private String numeroApartamento;
  private Float precioPorNoche;


  // Constructor
  public Apartamento(String nombre, String ciudad , Float calificacion, Integer maxPersonas, String torre, String numeroApartamento, Float precioPorNoche) {
    super(nombre, ciudad, Categoria.APARTAMENTO, calificacion, maxPersonas);
    this.torre = torre;
    this.numeroApartamento = numeroApartamento;
    this.precioPorNoche = precioPorNoche;
  }

  // Métodos
  @Override
  public boolean estaDisponible(LocalDate fechaInicio, LocalDate fechaFin, Integer cantPersonas, Integer cantHabitaciones, List<ReservaData<?>> reservas) {
    return cumpleCapacidad(cantPersonas) && noHayConflictoDeFechas(fechaInicio, fechaFin, reservas);
  }

  @Override
  public void getDetalles() {
    getDetallesBasicos();
    System.out.println("Detalles: Torre " + this.torre + ", apartamento" + this.numeroApartamento + ".");
  }

  // Getters y Setters
  public String getTorre() {
    return torre;
  }

  public void setTorre(String torre) {
    this.torre = torre;
  }

  public String getNumeroApartamento() {
    return numeroApartamento;
  }

  public void setNumeroApartamento(String numeroApartamento) {
    this.numeroApartamento = numeroApartamento;
  }

  public Float getPrecioPorNoche() {
    return precioPorNoche;
  }

  public void setPrecioPorNoche(Float precioPorNoche) {
    this.precioPorNoche = precioPorNoche;
  }
}
