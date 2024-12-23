package com.bookinghotels.model.alojamiento;

import com.bookinghotels.constants.Categoria;
import com.bookinghotels.model.data.ReservaData;

import java.time.LocalDate;
import java.util.List;

public class Apartamento extends Alojamiento {
  private String torre;
  private String numeroApartamento;
  private Float precioPorNoche;

  public Apartamento(String nombre, String ciudad , Float calificacion, Integer maxPersonas, String torre, String numeroApartamento, Float precioPorNoche) {
    super(nombre, ciudad, Categoria.APARTAMENTO, calificacion, maxPersonas);
    this.torre = torre;
    this.numeroApartamento = numeroApartamento;
    this.precioPorNoche = precioPorNoche;
  }

  public Apartamento(){
  }

  @Override
  public boolean estaDisponible(LocalDate fechaInicio, LocalDate fechaFin, Integer cantPersonas, Integer cantHabitaciones, List<ReservaData<?>> reservas) {
    return cumpleCapacidad(cantPersonas) && noHayConflictoDeFechas(fechaInicio, fechaFin, reservas);
  }

  @Override
  public void getDetalles() {
    getDetallesBasicos();
    System.out.println("Detalles: Torre " + this.torre + ", apartamento" + this.numeroApartamento + ".");
  }

  @Override
  public Float getPrecio() {
    return precioPorNoche;
  }

}
