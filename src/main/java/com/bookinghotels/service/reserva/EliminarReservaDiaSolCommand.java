package com.bookinghotels.service.reserva;

import com.bookinghotels.interfaces.ICommand;
import com.bookinghotels.model.data.ReservaDiaSolData;
import com.bookinghotels.repositories.ReservaRepository;

public class EliminarReservaDiaSolCommand implements ICommand {
  private final ReservaRepository repository;
  private ReservaDiaSolData reserva;

  public EliminarReservaDiaSolCommand(ReservaRepository repository, ReservaDiaSolData reserva ) {
    this.repository = repository;
    this.reserva = reserva;
  }


  @Override
  public ReservaDiaSolData execute() {
    repository.eliminarReserva(reserva);
    return reserva;
  }
}
