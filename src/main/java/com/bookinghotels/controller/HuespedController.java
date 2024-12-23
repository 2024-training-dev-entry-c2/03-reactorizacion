package com.bookinghotels.controller;

import com.bookinghotels.model.data.HuespedData;
import com.bookinghotels.repositories.HuespedRepository;
import com.bookinghotels.service.huesped.AgregarHuespedCommand;
import com.bookinghotels.service.huesped.BuscarHuespedCommand;

public class HuespedController {
  private HuespedRepository repository = HuespedRepository.getInstance();

  public HuespedController() {
  }

  public HuespedData registrarHuesped(){
    AgregarHuespedCommand agregarCommand = new AgregarHuespedCommand(repository);
    return agregarCommand.execute();
  }

  public HuespedData buscarHuesped(){
    BuscarHuespedCommand buscarCommand = new BuscarHuespedCommand(repository);
    return buscarCommand.execute();
  }
}
