package com.bookinghotels.constants;

public enum Categoria {
  HOTEL("Hotel"),
  FINCA("Finca"),
  APARTAMENTO("Apartamento"),
  DIA_SOL("Día de sol");

  private final String categoria;

  Categoria(String categoria){
    this.categoria = categoria;
  }

  public String getCategoria() {
    return categoria;
  }

}
