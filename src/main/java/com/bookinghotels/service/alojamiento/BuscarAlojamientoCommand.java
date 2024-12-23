package com.bookinghotels.service.alojamiento;

import com.bookinghotels.interfaces.ICommand;
import com.bookinghotels.model.alojamiento.Alojamiento;
import com.bookinghotels.repositories.AlojamientoRepository;
import com.bookinghotels.utils.ConsolaUtils;

public class BuscarAlojamientoCommand implements ICommand {
  private final AlojamientoRepository repository;
  private final ConsolaUtils consola;

  public BuscarAlojamientoCommand(AlojamientoRepository repository, ConsolaUtils consola) {
    this.repository = repository;
    this.consola = consola;
  }

  @Override
  public Alojamiento execute() {
    String nombre = consola.obtenerEntrada("Ingresa el nombre del alojamiento: ");
    return repository.buscarAlojamiento(nombre);
  }
}
