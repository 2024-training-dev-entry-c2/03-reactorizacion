package com.bookinghotels.service.alojamiento;

import com.bookinghotels.constants.Categoria;
import com.bookinghotels.interfaces.ICommand;
import com.bookinghotels.model.alojamiento.Alojamiento;
import com.bookinghotels.repositories.AlojamientoRepository;
import com.bookinghotels.utils.ConsolaUtils;

import java.time.LocalDate;
import java.util.List;

public class BuscarAlojamientosCommand implements ICommand {
  private final AlojamientoRepository repository;
  private final LocalDate fechaInicio;
  private final LocalDate fechaFin;
  private final Integer cantPersonas;
  private final Integer cantHabitaciones;
  private final Categoria categoria;


  public BuscarAlojamientosCommand(AlojamientoRepository repository, Categoria categoria, LocalDate fechaInicio, LocalDate fechaFin, Integer cantPersonas, Integer cantHabitaciones) {
    this.repository = repository;
    this.categoria = categoria;
    this.fechaInicio = fechaInicio;
    this.fechaFin = fechaFin;
    this.cantPersonas = cantPersonas;
    this.cantHabitaciones = cantHabitaciones;
  }

  @Override
  public List<Alojamiento> execute(){
    String ciudad = ConsolaUtils.obtenerEntrada("Indica la ciudad: ");
    return repository.buscarAlojamientos(categoria, ciudad, fechaInicio, fechaFin, cantPersonas, cantHabitaciones);
  }

}
