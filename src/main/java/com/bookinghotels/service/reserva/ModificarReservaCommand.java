package com.bookinghotels.service.reserva;

import com.bookinghotels.interfaces.ICommand;
import com.bookinghotels.repositories.ReservaRepository;

public class ModificarReservaCommand implements ICommand {
  private final ReservaRepository repository;

  public ModificarReservaCommand(ReservaRepository repository) {
    this.repository = repository;
  }



  @Override
  public void execute() {

  }
}
