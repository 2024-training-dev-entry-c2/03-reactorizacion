package com.bookinghotels.service.reserva;

import com.bookinghotels.interfaces.ICommand;
import com.bookinghotels.repositories.ReservaRepository;

public class CrearReservaCommand implements ICommand {
  private final ReservaRepository repository;

  public CrearReservaCommand(ReservaRepository repository) {
    this.repository = repository;
  }


  @Override
  public void execute() {
    //repository.addReserva();
    System.out.println("En proceso de desarrollo.");
  }

}
