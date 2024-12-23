package com.bookinghotels.service.reserva;

import com.bookinghotels.interfaces.ICommand;
import com.bookinghotels.model.data.ReservaData;
import com.bookinghotels.repositories.ReservaRepository;

public class EliminarReservaCommand implements ICommand {
  private final ReservaRepository repository;
  private ReservaData<?> reserva;

  public EliminarReservaCommand(ReservaRepository repository, ReservaData<?> reserva ) {
    this.repository = repository;
    this.reserva = reserva;
  }


  @Override
  public ReservaData<?> execute() {
    repository.eliminarReserva(reserva);
    return reserva;
  }
}
