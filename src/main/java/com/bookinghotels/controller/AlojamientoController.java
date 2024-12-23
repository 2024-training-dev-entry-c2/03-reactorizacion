
package com.bookinghotels.controller;

import com.bookinghotels.model.alojamiento.Alojamiento;
import com.bookinghotels.model.alojamiento.Habitacion;
import com.bookinghotels.repositories.AlojamientoRepository;
import com.bookinghotels.service.alojamiento.BuscarAlojamientoCommand;
import com.bookinghotels.service.alojamiento.BuscarAlojamientosCommand;
import com.bookinghotels.service.alojamiento.ConfirmarHabitacionesCommand;
import com.bookinghotels.service.alojamiento.ObtenerHabitacionesCommand;
import com.bookinghotels.utils.ConsolaUtils;

import java.time.LocalDate;
import java.util.List;

public class AlojamientoController {
  private AlojamientoRepository repository = AlojamientoRepository.getInstance();
  private ConsolaUtils consolaUtils;

  public AlojamientoController(ConsolaUtils consolaUtils) {
    this.consolaUtils = consolaUtils;
  }

  public List<Alojamiento> buscarAlojamientos(LocalDate fechaInicio, LocalDate fechaFin, Integer cantPersonas, Integer cantHabitaciones){
    BuscarAlojamientosCommand buscarCommand =  new BuscarAlojamientosCommand(repository, fechaInicio, fechaFin, cantPersonas, cantHabitaciones, consolaUtils);
    return buscarCommand.execute();
  }

  public Alojamiento buscarAlojamiento(){
    BuscarAlojamientoCommand buscarCommand = new BuscarAlojamientoCommand(repository,consolaUtils);
    return buscarCommand.execute();
  }

  public List<Habitacion> obtenerHabitaciones(Alojamiento alojamiento, LocalDate fechaInicio, LocalDate fechaFin){
    ObtenerHabitacionesCommand obtenerHabCommand = new ObtenerHabitacionesCommand(repository, alojamiento, fechaInicio, fechaFin, consolaUtils);
    return obtenerHabCommand.execute();
  }

  public List<Habitacion> confirmarHabitaciones(List<Habitacion> habitacionesDisponibles, Integer cantHabitaciones){
     ConfirmarHabitacionesCommand confirmarCommand = new ConfirmarHabitacionesCommand(repository,consolaUtils,habitacionesDisponibles,cantHabitaciones);
     return confirmarCommand.execute();
  }

}

