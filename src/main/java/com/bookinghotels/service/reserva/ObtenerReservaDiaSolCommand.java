package com.bookinghotels.service.reserva;

import com.bookinghotels.interfaces.ICommand;
import com.bookinghotels.model.data.HuespedData;
import com.bookinghotels.model.data.ReservaDiaSolData;
import com.bookinghotels.repositories.ReservaRepository;

public class ObtenerReservaDiaSolCommand implements ICommand {
  private final ReservaRepository repository;
  private final HuespedData huesped;

  public ObtenerReservaDiaSolCommand(ReservaRepository repository, HuespedData huesped) {
    this.repository = repository;
    this.huesped = huesped;
  }

  @Override
  public ReservaDiaSolData execute() {
    return repository.getReservasDiaSol().stream()
      .filter(r -> r.getHuesped().equals(huesped))
      .findFirst()
      .orElse(null);
  }
}
