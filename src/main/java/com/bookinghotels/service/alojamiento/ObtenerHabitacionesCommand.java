package com.bookinghotels.service.alojamiento;

import com.bookinghotels.constants.Categoria;
import com.bookinghotels.interfaces.ICommand;
import com.bookinghotels.model.alojamiento.Alojamiento;
import com.bookinghotels.model.alojamiento.Habitacion;
import com.bookinghotels.repositories.AlojamientoRepository;
import com.bookinghotels.utils.ConsolaUtils;

import java.time.LocalDate;
import java.util.List;

public class ObtenerHabitacionesCommand implements ICommand {
  private final AlojamientoRepository repository;
  private final Alojamiento alojamiento;
  private final ConsolaUtils consola;
  private final LocalDate fechaInicio;
  private final LocalDate fechaFin;
  private final List<String> categorias = List.of(Categoria.values()).stream().map((categoria) -> categoria.getCategoria()).toList();

  public ObtenerHabitacionesCommand(AlojamientoRepository repository, Alojamiento alojamiento, LocalDate fechaInicio, LocalDate fechaFin, ConsolaUtils consola) {
    this.repository = repository;
    this.alojamiento = alojamiento;
    this.consola = consola;
    this.fechaInicio = fechaInicio;
    this.fechaFin = fechaFin;
  }

  @Override
  public List<Habitacion> execute() {
    return repository.obtenerHabitacionesDisponibles(alojamiento, fechaInicio, fechaFin);
  }
}
