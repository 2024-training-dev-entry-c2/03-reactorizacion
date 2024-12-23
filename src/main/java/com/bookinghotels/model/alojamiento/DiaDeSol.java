package com.bookinghotels.model.alojamiento;

import java.util.List;

public class DiaDeSol {
  private String actividades;
  private List<String> extras;
  private Float precioPorPersona;
  private Integer maxCapacidad;

  public DiaDeSol(String actividades, List<String> extras, Float precioPorPersona, Integer maxCapacidad) {
    this.actividades = actividades;
    this.extras = extras;
    this.precioPorPersona = precioPorPersona;
    this.maxCapacidad = maxCapacidad;
  }

  public DiaDeSol(){
  }

  public boolean estaDisponible(Integer cantPersonas) {
    return cantPersonas <= maxCapacidad;
  }

  public void mostrarDetalles(){
    System.out.println("Actividades: " + this.actividades);
    System.out.println("Extras: " + this.extras.toString());
    System.out.println("Precio por persona: $" + this.precioPorPersona);
  }

  public String getActividades() {
    return actividades;
  }

  public void setActividades(String actividades) {
    this.actividades = actividades;
  }

  public List<String> getExtras() {
    return extras;
  }

  public void setExtras(List<String> extras) {
    this.extras = extras;
  }

  public Float getPrecioPorPersona() {
    return precioPorPersona;
  }

  public void setPrecioPorPersona(Float precioPorPersona) {
    this.precioPorPersona = precioPorPersona;
  }

  public Integer getMaxCapacidad() {
    return maxCapacidad;
  }

  public void setMaxCapacidad(Integer maxCapacidad) {
    this.maxCapacidad = maxCapacidad;
  }
}
