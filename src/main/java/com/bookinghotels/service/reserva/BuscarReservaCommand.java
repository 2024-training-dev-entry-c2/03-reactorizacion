package com.bookinghotels.service.reserva;

import com.bookinghotels.controller.HuespedController;
import com.bookinghotels.interfaces.ICommand;
import com.bookinghotels.model.data.HuespedData;
import com.bookinghotels.model.data.ReservaData;
import com.bookinghotels.repositories.ReservaRepository;

public class BuscarReservaCommand implements ICommand {
  private final ReservaRepository repository;
  private final HuespedController huespedController;

  public BuscarReservaCommand(ReservaRepository repository,  HuespedController huespedController) {
    this.repository = repository;
    this.huespedController = huespedController;
  }

  @Override
  public ReservaData<?> execute() {
    HuespedData huesped = huespedController.buscarHuesped();

    return repository.getReservas().stream().filter(reserva -> reserva.getHuesped() == huesped)
      .findFirst()
      .orElse(null);
  }
}
