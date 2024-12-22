package com.bookinghotels.service.reserva;

import com.bookinghotels.interfaces.ICommand;
import com.bookinghotels.repositories.ReservaRepository;

public class EliminarReservaCommand implements ICommand {
  private final ReservaRepository repository;

  public EliminarReservaCommand(ReservaRepository repository) {
    this.repository = repository;
  }


  @Override
  public void execute() {
    System.out.println("En proceso");
  }
}
