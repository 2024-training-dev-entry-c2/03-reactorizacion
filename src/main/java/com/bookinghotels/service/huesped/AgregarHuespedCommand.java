package com.bookinghotels.service.huesped;

import com.bookinghotels.interfaces.ICommand;
import com.bookinghotels.model.data.HuespedData;
import com.bookinghotels.repositories.HuespedRepository;
import com.bookinghotels.utils.ConsolaUtils;

import java.time.LocalDate;

public class AgregarHuespedCommand implements ICommand {
  private HuespedRepository repository;

  public AgregarHuespedCommand( HuespedRepository repository) {
    this.repository = repository;
  }

  @Override
  public HuespedData execute() {
    String nombre = ConsolaUtils.obtenerEntrada("Nombre: ");
    String apellido = ConsolaUtils.obtenerEntrada("Apellido: ");
    LocalDate fechaNacimiento = ConsolaUtils.parseFecha(ConsolaUtils.obtenerEntrada("Fecha de nacimiento (YYYY-MM-dd): "));
    String numCelular = ConsolaUtils.obtenerEntrada("Número de celular: ");
    String correo = ConsolaUtils.obtenerEntrada("Correo electrónico: ");
    String nacionalidad = ConsolaUtils.obtenerEntrada("Nacionalidad: ");
    HuespedData huespedData = new HuespedData(nombre, apellido, fechaNacimiento, numCelular, correo, nacionalidad);
    repository.addHuesped(huespedData);
    return huespedData;
  }
}
