package com.bookinghotels.service.alojamiento;

import com.bookinghotels.interfaces.ICommand;
import com.bookinghotels.model.alojamiento.Alojamiento;
import com.bookinghotels.repositories.AlojamientoRepository;
import com.bookinghotels.utils.ConsolaUtils;

public class BuscarAlojamientoCommand implements ICommand {
  private final AlojamientoRepository repository;

  public BuscarAlojamientoCommand(AlojamientoRepository repository) {
    this.repository = repository;
  }

  @Override
  public Alojamiento execute() {
    String nombre = ConsolaUtils.obtenerEntrada("Ingresa el nombre del alojamiento: ");
    return repository.buscarAlojamiento(nombre);
  }
}
