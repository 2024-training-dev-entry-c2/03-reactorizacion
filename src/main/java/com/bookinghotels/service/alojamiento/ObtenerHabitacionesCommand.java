package com.bookinghotels.service.alojamiento;

import com.bookinghotels.interfaces.ICommand;
import com.bookinghotels.model.alojamiento.Alojamiento;
import com.bookinghotels.model.alojamiento.Habitacion;
import com.bookinghotels.repositories.AlojamientoRepository;

import java.time.LocalDate;
import java.util.List;

public class ObtenerHabitacionesCommand implements ICommand {
  private final AlojamientoRepository repository;
  private final Alojamiento alojamiento;
  private final LocalDate fechaInicio;
  private final LocalDate fechaFin;

  public ObtenerHabitacionesCommand(AlojamientoRepository repository, Alojamiento alojamiento, LocalDate fechaInicio, LocalDate fechaFin) {
    this.repository = repository;
    this.alojamiento = alojamiento;
    this.fechaInicio = fechaInicio;
    this.fechaFin = fechaFin;
  }

  @Override
  public List<Habitacion> execute() {
    return repository.obtenerHabitacionesDisponibles(alojamiento, fechaInicio, fechaFin);
  }
}
