package com.bookinghotels.repositories;

import com.bookinghotels.model.alojamiento.Habitacion;
import com.bookinghotels.model.data.ReservaData;
import com.bookinghotels.model.data.ReservaDiaSolData;

import java.util.ArrayList;
import java.util.List;

public class ReservaRepository {
  private static ReservaRepository instance;
  private List<ReservaData<?>> reservas;
  private List<ReservaDiaSolData> reservasDiaSol;

  private ReservaRepository() {
    this.reservas = new ArrayList<>();
    this.reservasDiaSol = new ArrayList<>();
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

  public List<ReservaDiaSolData> getReservasDiaSol(){
    return reservasDiaSol;
  }

  public void addReserva(ReservaData<?> reserva){
    reservas.add(reserva);
  }

  public void addReserva(ReservaDiaSolData reserva){
    reservasDiaSol.add(reserva);
  }

  public void eliminarReserva(ReservaData<?> reserva){
    reservas.remove(reserva);
  }

  public void eliminarReserva(ReservaDiaSolData reserva){
    reservasDiaSol.remove(reserva);
  }

  public void modificarHabitaciones(ReservaData<?> reserva, List<Habitacion> habitaciones){
    reservas.get(reservas.indexOf(reserva)).setHabitacionesReservadas(habitaciones);
  }
}
