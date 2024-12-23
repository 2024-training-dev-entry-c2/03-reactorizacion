package com.bookinghotels.service.alojamiento;

import com.bookinghotels.interfaces.ICommand;
import com.bookinghotels.interfaces.IDiaDeSol;
import com.bookinghotels.repositories.AlojamientoRepository;
import com.bookinghotels.utils.ConsolaUtils;

import java.time.LocalDate;
import java.util.List;

public class BuscarDiaSolCommand implements ICommand {
  private final AlojamientoRepository repository;
  private final LocalDate fecha;
  private final Integer cantPersonas;

  public BuscarDiaSolCommand(AlojamientoRepository repository, LocalDate fecha, Integer cantPersonas) {
    this.repository = repository;
    this.fecha = fecha;
    this.cantPersonas = cantPersonas;
  }


  @Override
  public List<IDiaDeSol> execute() {
    String ciudad = ConsolaUtils.obtenerEntrada("Indica la ciudad: ");
    return repository.buscarDiaSol(ciudad, fecha,cantPersonas);
  }
}
