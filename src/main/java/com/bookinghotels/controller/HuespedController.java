package com.bookinghotels.controller;

import com.bookinghotels.model.data.HuespedData;
import com.bookinghotels.repositories.HuespedRepository;
import com.bookinghotels.service.huesped.AgregarHuespedCommand;
import com.bookinghotels.service.huesped.BuscarHuespedCommand;
import com.bookinghotels.utils.ConsolaUtils;

public class HuespedController {
  private HuespedRepository repository = HuespedRepository.getInstance();
  private ConsolaUtils consolaUtils;

  public HuespedController(ConsolaUtils consolaUtils) {
    this.consolaUtils = consolaUtils;
  }

  public HuespedData registrarHuesped(){
    AgregarHuespedCommand agregarCommand = new AgregarHuespedCommand(repository, consolaUtils);
    return agregarCommand.execute();
  }

  public HuespedData buscarHuesped(){
    BuscarHuespedCommand buscarCommand = new BuscarHuespedCommand(repository, consolaUtils);
    return buscarCommand.execute();
  }
}
