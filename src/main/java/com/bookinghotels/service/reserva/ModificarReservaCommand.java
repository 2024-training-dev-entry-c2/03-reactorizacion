package com.bookinghotels.service.reserva;

import com.bookinghotels.controller.AlojamientoController;
import com.bookinghotels.interfaces.ICommand;
import com.bookinghotels.model.alojamiento.Alojamiento;
import com.bookinghotels.model.alojamiento.Habitacion;
import com.bookinghotels.model.data.ReservaData;
import com.bookinghotels.repositories.ReservaRepository;

import java.util.List;

public class ModificarReservaCommand implements ICommand {
  private final AlojamientoController alojamientoController;
  private final ReservaRepository repository;
  private ReservaData<?> reserva;

  public ModificarReservaCommand( ReservaRepository repository, AlojamientoController alojamientoController, ReservaData<?> reserva) {
    this.alojamientoController = alojamientoController;
    this.repository = repository;
    this.reserva = reserva;
  }

  @Override
  public ReservaData<?> execute() {
    List<Habitacion> habitacionesActuales = alojamientoController.obtenerHabitaciones((Alojamiento) reserva.getAlojamiento(), reserva.getFechaInicio(), reserva.getFechaFin());
    habitacionesActuales.forEach(habitacion -> System.out.println("- " + habitacion.getTipo()));
    //String tipo =
    //repository.eliminarReserva(reserva);
    return null;
  }
}
