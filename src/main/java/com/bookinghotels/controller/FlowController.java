package com.bookinghotels.controller;

import com.bookinghotels.model.alojamiento.Alojamiento;
import com.bookinghotels.model.alojamiento.Habitacion;
import com.bookinghotels.model.data.HuespedData;
import com.bookinghotels.utils.CalculadoraPrecio;
import com.bookinghotels.utils.ConsolaUtils;

import java.time.LocalDate;
import java.util.List;

public class FlowController {
  private final ConsolaUtils consolaUtils;
  private final AlojamientoController alojamientoController;
  private final HuespedController huespedController;
  private final ReservaController reservaController;

  public FlowController(ConsolaUtils consolaUtils){
    this.consolaUtils = consolaUtils;
    this.alojamientoController = new AlojamientoController(this.consolaUtils);
    this.huespedController = new HuespedController(this.consolaUtils);
    this.reservaController = new ReservaController(this.consolaUtils);
  }

  public void iniciarFlujoReserva() {
    LocalDate fechaInicio = consolaUtils.parseFecha(consolaUtils.obtenerEntrada("¿Cuál es la fecha inicio? (YYYY-MM-dd): "));
    LocalDate fechaFin = consolaUtils.parseFecha(consolaUtils.obtenerEntrada("¿Cuál es la fecha fin? (YYYY-MM-dd): "));
    Integer cantPersonas = consolaUtils.obtenerEntero("¿Cuántas personas son?:");
    Integer cantHabitaciones = consolaUtils.obtenerEntero("¿Cuántas habitaciones necesitas?:");

    List<Alojamiento> alojamientos = alojamientoController.buscarAlojamientos(fechaInicio, fechaFin, cantPersonas, cantHabitaciones);
    if (alojamientos.isEmpty()) {
      System.out.println("No hay alojamientos disponibles.");
      return;
    }
    alojamientos.forEach(alojamiento -> CalculadoraPrecio.calcularPrecios(alojamiento,fechaInicio,fechaFin));

    Alojamiento alojamientoSeleccionado = alojamientoController.buscarAlojamiento();

    List<Habitacion> habitaciones = alojamientoController.obtenerHabitaciones(alojamientoSeleccionado, fechaInicio, fechaFin);
    if (habitaciones.isEmpty()) {
      System.out.println("No hay habitaciones disponibles.");
      return;
    }
    habitaciones.forEach(Habitacion::mostrarDetalles);

    List<Habitacion> habitacionesSeleccionadas = alojamientoController.confirmarHabitaciones(habitaciones,cantHabitaciones);
    HuespedData huesped = huespedController.registrarHuesped();

    reservaController.crearReserva(alojamientoSeleccionado, huesped, fechaInicio, fechaFin, habitacionesSeleccionadas);

    System.out.println("¡Reserva creada exitosamente!");
  }
}
