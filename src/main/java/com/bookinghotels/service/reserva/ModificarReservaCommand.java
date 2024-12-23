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
    List<Habitacion> habitacionesActuales = obtenerHabitacionesActuales();
    Habitacion antiguaHabitacion = obtenerAntiguaHabitacion(habitacionesActuales);
    List<Habitacion> habitacionesDisponibles = obtenerHabitacionesDisponibles();
    mostrarHabitacionesDisponibles(habitacionesDisponibles);
    Habitacion nuevaHabitacion = obtenerNuevaHabitacion(habitacionesDisponibles);
    actualizarHabitaciones(habitacionesActuales, antiguaHabitacion, nuevaHabitacion);
    return reserva;
  }

  private List<Habitacion> obtenerHabitacionesActuales() {
    return reserva.getHabitacionesReservadas();
  }

  private Habitacion obtenerAntiguaHabitacion(List<Habitacion> habitacionesActuales) {
    String tipo = ConsolaUtils.obtenerEntrada("Ingresa el nombre de la habitación a cambiar: ");
    return habitacionesActuales.stream()
      .filter(habitacion -> habitacion.getTipo().equalsIgnoreCase(tipo))
      .findFirst()
      .orElse(null);
  }

  private List<Habitacion> obtenerHabitacionesDisponibles() {
    return alojamientoController.obtenerHabitaciones(
      (Alojamiento) reserva.getAlojamiento(),
      reserva.getFechaInicio(),
      reserva.getFechaFin()
    );
  }

  private void mostrarHabitacionesDisponibles(List<Habitacion> habitacionesDisponibles) {
    habitacionesDisponibles.forEach(Habitacion::mostrarDetalles);
  }

  private Habitacion obtenerNuevaHabitacion(List<Habitacion> habitacionesDisponibles) {
    String tipoNuevo = ConsolaUtils.obtenerEntrada("Ingresa el nombre de la habitación que deseas: ");
    return habitacionesDisponibles.stream()
      .filter(habitacion -> habitacion.getTipo().equalsIgnoreCase(tipoNuevo))
      .findFirst()
      .orElse(null);
  }

  private void actualizarHabitaciones(List<Habitacion> habitacionesActuales, Habitacion antiguaHabitacion, Habitacion nuevaHabitacion) {
    habitacionesActuales.remove(antiguaHabitacion);
    habitacionesActuales.add(nuevaHabitacion);
    repository.modificarHabitaciones(reserva, habitacionesActuales);
  }

}
