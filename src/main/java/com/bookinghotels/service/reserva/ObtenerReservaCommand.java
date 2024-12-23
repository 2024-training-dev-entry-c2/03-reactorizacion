package com.bookinghotels.service.reserva;

import com.bookinghotels.interfaces.ICommand;
import com.bookinghotels.model.data.HuespedData;
import com.bookinghotels.model.data.ReservaData;
import com.bookinghotels.repositories.ReservaRepository;

public class ObtenerReservaCommand implements ICommand {
  private final ReservaRepository repository;
  private final HuespedData huesped;

  public ObtenerReservaCommand(ReservaRepository repository, HuespedData huesped) {
    this.repository = repository;
    this.huesped = huesped;
  }

  @Override
  public ReservaData<?> execute() {
    return repository.getReservas().stream()
      .filter(r -> r.getHuesped().equals(huesped))
      .findFirst()
      .orElse(null);
  }
}
