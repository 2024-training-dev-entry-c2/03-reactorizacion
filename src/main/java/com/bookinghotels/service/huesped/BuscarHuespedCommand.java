package com.bookinghotels.service.huesped;

import com.bookinghotels.interfaces.ICommand;
import com.bookinghotels.repositories.HuespedRepository;
import com.bookinghotels.utils.ConsolaUtils;

import java.time.LocalDate;

public class BuscarHuespedCommand implements ICommand {
  private HuespedRepository repository;
  private final ConsolaUtils consola;

  public BuscarHuespedCommand(ConsolaUtils consola, HuespedRepository repository) {
    this.consola = consola;
    this.repository = repository;
  }

  @Override
  public void execute() {
    String correo = consola.obtenerEntrada("Correo electrónico: ");
    LocalDate fechaNacimiento = consola.parseFecha(consola.obtenerEntrada("Fecha de nacimiento (YYYY-MM-dd): "));
    repository.buscarHuesped(correo,fechaNacimiento).toString();
  }
}
