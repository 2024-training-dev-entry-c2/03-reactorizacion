
package com.bookinghotels.controller;

import com.bookinghotels.constants.Categoria;
import com.bookinghotels.interfaces.IDiaDeSol;
import com.bookinghotels.model.alojamiento.Alojamiento;
import com.bookinghotels.model.alojamiento.Habitacion;
import com.bookinghotels.repositories.AlojamientoRepository;
import com.bookinghotels.service.alojamiento.BuscarAlojamientoCommand;
import com.bookinghotels.service.alojamiento.BuscarAlojamientosCommand;
import com.bookinghotels.service.alojamiento.BuscarDiaSolCommand;
import com.bookinghotels.service.alojamiento.ConfirmarHabitacionesCommand;
import com.bookinghotels.service.alojamiento.ObtenerHabitacionesCommand;

import java.time.LocalDate;
import java.util.List;

public class AlojamientoController {
  private AlojamientoRepository repository = AlojamientoRepository.getInstance();

  public AlojamientoController() {

  }

  public List<Alojamiento> buscarAlojamientos(Categoria categoria, LocalDate fechaInicio, LocalDate fechaFin, Integer cantPersonas, Integer cantHabitaciones){
    BuscarAlojamientosCommand buscarCommand =  new BuscarAlojamientosCommand(repository, categoria, fechaInicio, fechaFin, cantPersonas, cantHabitaciones);
    return buscarCommand.execute();
  }

  public Alojamiento buscarAlojamiento(){
    BuscarAlojamientoCommand buscarCommand = new BuscarAlojamientoCommand(repository);
    return buscarCommand.execute();
  }

  public List<IDiaDeSol> buscarDiaSol( LocalDate fecha, Integer cantPersonas){
    BuscarDiaSolCommand buscarCommand = new BuscarDiaSolCommand(repository,fecha, cantPersonas);
    return buscarCommand.execute();
  }

  public List<Habitacion> obtenerHabitaciones(Alojamiento alojamiento, LocalDate fechaInicio, LocalDate fechaFin){
    ObtenerHabitacionesCommand obtenerHabCommand = new ObtenerHabitacionesCommand(repository, alojamiento, fechaInicio, fechaFin);
    return obtenerHabCommand.execute();
  }

  public List<Habitacion> confirmarHabitaciones(List<Habitacion> habitacionesDisponibles, Integer cantHabitaciones){
     ConfirmarHabitacionesCommand confirmarCommand = new ConfirmarHabitacionesCommand(habitacionesDisponibles,cantHabitaciones);
     return confirmarCommand.execute();
  }

}

