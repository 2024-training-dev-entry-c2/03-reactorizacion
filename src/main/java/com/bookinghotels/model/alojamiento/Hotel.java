package com.bookinghotels.model.alojamiento;


import com.bookinghotels.constants.Categoria;
import com.bookinghotels.interfaces.IDiaDeSol;
import com.bookinghotels.model.data.ReservaData;

import java.time.LocalDate;
import java.util.List;

public class Hotel extends Alojamiento implements IDiaDeSol {
  private DiaDeSol diaDeSol;
  private Boolean servicioHabitacion;

  public Hotel(String nombre, String ciudad , Float calificacion, DiaDeSol diaDeSol, Boolean servicioHabitacion) {
    super(nombre, ciudad, Categoria.HOTEL, calificacion, null);
    this.diaDeSol = diaDeSol;
    this.servicioHabitacion = servicioHabitacion;
  }

  public Hotel(){
  }

  @Override
  public boolean estaDisponible(LocalDate fechaInicio, LocalDate fechaFin, Integer cantPersonas, Integer cantHabitaciones, List<ReservaData<?>> reservas) {
    return true;
  }

  @Override
  public void getDetalles() {
    getDetallesBasicos();
    String servicio = this.servicioHabitacion == true ? "Incluido" : "No tiene";
    System.out.println("Servicio a la habitación: " + servicio);
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
  public Float getPrecio(){
    return habitaciones.stream()
      .map(Habitacion::getPrecioPorNoche)
      .min(Float::compare)
      .orElse(null);
  }

  @Override
  public DiaDeSol getDiaSol() {
    return diaDeSol;
  }

  public void setDiaDeSol(DiaDeSol diaDeSol) {
    this.diaDeSol = diaDeSol;
  }

}
