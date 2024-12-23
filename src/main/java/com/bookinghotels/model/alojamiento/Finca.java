package com.bookinghotels.model.alojamiento;


import com.bookinghotels.constants.Categoria;
import com.bookinghotels.interfaces.IDiaDeSol;
import com.bookinghotels.model.data.ReservaData;

import java.time.LocalDate;
import java.util.List;

public class Finca extends Alojamiento implements IDiaDeSol {
  private DiaDeSol diaDeSol;
  private Float precioPorNoche;

  public Finca(String nombre, String ciudad, Float calificacion, Integer maxPersonas, DiaDeSol diaDeSol, Float precioPorNoche) {
    super(nombre, ciudad, Categoria.FINCA, calificacion, maxPersonas);
    this.diaDeSol = diaDeSol;
    this.precioPorNoche = precioPorNoche;
  }

  public Finca(){
  }

  @Override
  public boolean estaDisponible(LocalDate fechaInicio, LocalDate fechaFin, Integer cantPersonas, Integer cantHabitaciones, List<ReservaData<?>> reservas) {
    return cumpleCapacidad(cantPersonas) && noHayConflictoDeFechas(fechaInicio, fechaFin, reservas);
  }

  @Override
  public void getDetalles() {
    getDetallesBasicos();
    System.out.println("Precio por noche: $" + precioPorNoche);
  }

  @Override
  public boolean tieneDiaDeSol() {
    return diaDeSol != null;
  }

  @Override
  public void mostrarInfoDiaDeSol() {
    getDetallesBasicos();
    if(!tieneDiaDeSol())return;
    diaDeSol.mostrarDetalles();
  }

  @Override
  public DiaDeSol getDiaSol() {
    return diaDeSol;
  }

  @Override
  public Float getPrecio() {
    return precioPorNoche;
  }


}
