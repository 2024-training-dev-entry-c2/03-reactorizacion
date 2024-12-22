package com.bookinghotels.service.huesped;

import com.bookinghotels.interfaces.ICommand;
import com.bookinghotels.model.data.HuespedData;
import com.bookinghotels.repositories.HuespedRepository;
import com.bookinghotels.utils.ConsolaUtils;

import java.time.LocalDate;

public class AgregarHuespedCommand implements ICommand {
  private HuespedRepository repository;
  private final ConsolaUtils consola;

  public AgregarHuespedCommand(ConsolaUtils consola, HuespedRepository repository) {
    this.consola = consola;
    this.repository = repository;
  }

  @Override
  public void execute() {
    String nombre = consola.obtenerEntrada("Nombre: ");
    String apellido = consola.obtenerEntrada("Apellido: ");
    LocalDate fechaNacimiento = consola.parseFecha(consola.obtenerEntrada("Fecha de nacimiento (YYYY-MM-dd): "));
    String numCelular = consola.obtenerEntrada("Número de celular: ");
    String correo = consola.obtenerEntrada("Correo electrónico: ");
    String nacionalidad = consola.obtenerEntrada("Nacionalidad: ");
    HuespedData huespedData = new HuespedData(nombre, apellido, fechaNacimiento, numCelular, correo, nacionalidad);
    repository.addHuesped(huespedData);
  }
}
