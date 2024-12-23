package com.bookinghotels.controller;

import com.bookinghotels.model.alojamiento.Alojamiento;
import com.bookinghotels.model.alojamiento.Habitacion;
import com.bookinghotels.model.data.HuespedData;
import com.bookinghotels.model.data.ReservaData;
import com.bookinghotels.model.data.ReservaDiaSolData;
import com.bookinghotels.repositories.ReservaRepository;
import com.bookinghotels.service.reserva.CrearReservaCommand;
import com.bookinghotels.service.reserva.CrearReservaDiaSolCommand;
import com.bookinghotels.service.reserva.EliminarReservaCommand;
import com.bookinghotels.service.reserva.EliminarReservaDiaSolCommand;
import com.bookinghotels.service.reserva.ModificarReservaCommand;
import com.bookinghotels.service.reserva.ObtenerReservaCommand;
import com.bookinghotels.service.reserva.ObtenerReservaDiaSolCommand;

import java.time.LocalDate;
import java.util.List;

public class ReservaController {
  private ReservaRepository repository = ReservaRepository.getInstance();

  public ReservaController() {
  }

  public String crearReserva(Alojamiento alojamiento, HuespedData huesped, LocalDate fechaInicio, LocalDate fechaFin, List<Habitacion> habitacionesSeleccionadas){
    CrearReservaCommand crearReservaCommand = new CrearReservaCommand(repository, alojamiento, huesped, fechaInicio, fechaFin, habitacionesSeleccionadas);
    ReservaData<?> reservaCreada= crearReservaCommand.execute();

    return reservaCreada != null? "Reserva creada con éxito!" : "Lo siento, no hay disponibilidad para las fechas seleccionadas.";
  }

  public String crearReserva(Alojamiento alojamiento, HuespedData huesped, LocalDate fecha, Integer cantPersonas){
    CrearReservaDiaSolCommand crearReservaDiaSolCommand = new CrearReservaDiaSolCommand(repository, alojamiento, huesped, fecha, cantPersonas);
    ReservaDiaSolData reservaCreada = crearReservaDiaSolCommand.execute();

    return reservaCreada != null? "Reserva creada con éxito!" : "Lo siento, no hay disponibilidad para las fechas seleccionadas.";
  }

  public ReservaData<?> obtenerReserva(HuespedData huesped){
    ObtenerReservaCommand obtenerCommand = new ObtenerReservaCommand(repository,huesped);
    return obtenerCommand.execute();
  }
  public ReservaDiaSolData obtenerReservaDiaSol(HuespedData huesped){
    ObtenerReservaDiaSolCommand obtenerCommand = new ObtenerReservaDiaSolCommand(repository,huesped);
    return obtenerCommand.execute();
  }

  public ReservaData<?> modificarReserva(AlojamientoController alojamientoController, ReservaData<?> reserva){
    ModificarReservaCommand modificarCommand = new ModificarReservaCommand(repository, alojamientoController, reserva);
    return modificarCommand.execute();
  }

  public ReservaData<?> eliminarReserva(ReservaData<?> reserva){
    EliminarReservaCommand eliminarCommand = new EliminarReservaCommand(repository, reserva);
    return  eliminarCommand.execute();
  }

  public ReservaDiaSolData eliminarReserva(ReservaDiaSolData reserva){
    EliminarReservaDiaSolCommand eliminarCommand = new EliminarReservaDiaSolCommand(repository, reserva);
    return  eliminarCommand.execute();
  }
}
