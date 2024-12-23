package com.bookinghotels.service.huesped;

import com.bookinghotels.interfaces.ICommand;
import com.bookinghotels.model.data.HuespedData;
import com.bookinghotels.repositories.HuespedRepository;
import com.bookinghotels.utils.ConsolaUtils;

import java.time.LocalDate;

public class BuscarHuespedCommand implements ICommand {
  private HuespedRepository repository;
  private final ConsolaUtils consola;

  public BuscarHuespedCommand(HuespedRepository repository, ConsolaUtils consola) {
    this.consola = consola;
    this.repository = repository;
  }

  @Override
  public HuespedData execute() {
    String correo = consola.obtenerEntrada("Correo electrónico: ");
    LocalDate fechaNacimiento = consola.parseFecha(consola.obtenerEntrada("Fecha de nacimiento (YYYY-MM-dd): "));
    return repository.buscarHuesped(correo,fechaNacimiento);
  }
}
