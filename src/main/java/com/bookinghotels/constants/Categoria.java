package com.bookinghotels.constants;

public enum Categoria {
  APARTAMENTO("Apartamento"),
  FINCA("Finca"),
  HOTEL("Hotel"),
  DIA_SOL("Día de sol");

  private final String categoria;

  Categoria(String categoria){
    this.categoria = categoria;
  }

  public String getCategoria() {
    return categoria;
  }

}
