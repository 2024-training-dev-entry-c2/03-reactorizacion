package com.bookinghotels.service.reserva;

import com.bookinghotels.controller.AlojamientoController;
import com.bookinghotels.interfaces.ICommand;
import com.bookinghotels.model.alojamiento.Alojamiento;
import com.bookinghotels.model.alojamiento.Habitacion;
import com.bookinghotels.model.data.ReservaData;
import com.bookinghotels.repositories.ReservaRepository;
import com.bookinghotels.utils.ConsolaUtils;

import java.util.List;

public class ModificarReservaCommand implements ICommand {
  private final AlojamientoController alojamientoController;
  private final ReservaRepository repository;
  private ReservaData<?> reserva;

  public ModificarReservaCommand(ReservaRepository repository, AlojamientoController alojamientoController, ReservaData<?> reserva) {
    this.repository = repository;
    this.alojamientoController = alojamientoController;
    this.reserva = reserva;
  }

  @Override
  public ReservaData<?> execute() {
    List<Habitacion> habitacionesActuales = reserva.getHabitacionesReservadas();
    String tipo = ConsolaUtils.obtenerEntrada("Ingresa el nombre de la habitación a cambiar: ");
    Habitacion antiguaHabitacion =  habitacionesActuales.stream().filter(habitacion -> habitacion.getTipo().equalsIgnoreCase(tipo)).findFirst().orElse(null);
    alojamientoController.obtenerHabitaciones((Alojamiento) reserva.getAlojamiento(), reserva.getFechaInicio(), reserva.getFechaFin()).forEach(Habitacion::mostrarDetalles);
    String tipoNuevo = ConsolaUtils.obtenerEntrada("Ingresa el nombre de la habitación que deseas: ");
    Habitacion nuevaHabitacion =  habitacionesActuales.stream().filter(habitacion -> habitacion.getTipo().equalsIgnoreCase(tipoNuevo)).findFirst().orElse(null);
    habitacionesActuales.remove(antiguaHabitacion);
    habitacionesActuales.add(nuevaHabitacion);
    repository.modificarHabitaciones(reserva,habitacionesActuales);
    return reserva;
  }

}
