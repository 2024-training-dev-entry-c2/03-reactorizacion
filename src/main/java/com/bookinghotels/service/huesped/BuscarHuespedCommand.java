package com.bookinghotels.service.huesped;

import com.bookinghotels.interfaces.ICommand;
import com.bookinghotels.model.data.HuespedData;
import com.bookinghotels.repositories.HuespedRepository;
import com.bookinghotels.utils.ConsolaUtils;

import java.time.LocalDate;

public class BuscarHuespedCommand implements ICommand {
  private HuespedRepository repository;

  public BuscarHuespedCommand(HuespedRepository repository) {
    this.repository = repository;
  }

  @Override
  public HuespedData execute() {
    String correo = ConsolaUtils.obtenerEntrada("Correo electrónico: ");
    LocalDate fechaNacimiento = ConsolaUtils.parseFecha(ConsolaUtils.obtenerEntrada("Fecha de nacimiento (YYYY-MM-dd): "));
    return repository.buscarHuesped(correo,fechaNacimiento);
  }
}
