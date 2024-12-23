package com.bookinghotels.controller;

import com.bookinghotels.model.alojamiento.Alojamiento;
import com.bookinghotels.model.alojamiento.Habitacion;
import com.bookinghotels.model.data.HuespedData;
import com.bookinghotels.model.data.ReservaData;
import com.bookinghotels.repositories.ReservaRepository;
import com.bookinghotels.service.reserva.CrearReservaCommand;
import com.bookinghotels.utils.ConsolaUtils;

import java.time.LocalDate;
import java.util.List;

public class ReservaController {
  private ReservaRepository repository = ReservaRepository.getInstance();
  private ConsolaUtils consolaUtils;

  public ReservaController(ConsolaUtils consolaUtils) {
    this.consolaUtils = consolaUtils;
  }

  public String crearReserva(Alojamiento alojamiento, HuespedData huesped, LocalDate fechaInicio, LocalDate fechaFin, List<Habitacion> habitacionesSeleccionadas){
    CrearReservaCommand crearReservaCommand = new CrearReservaCommand(repository, alojamiento, huesped, fechaInicio, fechaFin, habitacionesSeleccionadas, consolaUtils);
    ReservaData<?> reservaCreada= crearReservaCommand.execute();

    return reservaCreada != null? "Reserva creada con éxito!" : "Lo siento, no hay disponibilidad para las fechas seleccionadas.";
  }
}
