package com.bookinghotels.repositories;

import com.bookinghotels.model.data.HuespedData;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HuespedRepository {
  private static HuespedRepository instance;
  private List<HuespedData> huespedes;

  private HuespedRepository() {
    huespedes = new ArrayList<>();
  }

  public static synchronized HuespedRepository getInstance(){
    if(instance == null){
      instance = new HuespedRepository();
    }
    return instance;
  }

  public void addHuesped(HuespedData huesped){
    huespedes.add(huesped);
  }

  public HuespedData buscarHuesped(String correo, LocalDate fechaNacimiento){
    return huespedes.stream()
      .filter(huesped -> huesped.getCorreo().equalsIgnoreCase(correo))
      .filter(huesped -> huesped.getFechaNacimiento().isEqual(fechaNacimiento))
      .findFirst()
      .orElse(null);
  }
}
