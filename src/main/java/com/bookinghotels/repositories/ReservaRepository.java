package com.bookinghotels.repositories;

import com.bookinghotels.model.data.ReservaData;

import java.util.ArrayList;
import java.util.List;

public class ReservaRepository {
  private static ReservaRepository instance;
  private List<ReservaData<?>> reservas;

  private ReservaRepository() {
    this.reservas = new ArrayList<>();
  }

  public static synchronized ReservaRepository getInstance(){
    if(instance == null){
      instance = new ReservaRepository();
    }
    return instance;
  }

  public List<ReservaData<?>> getReservas(){
    return reservas;
  }

  public void addReserva(ReservaData<?> reserva){
    reservas.add(reserva);
  }
}
