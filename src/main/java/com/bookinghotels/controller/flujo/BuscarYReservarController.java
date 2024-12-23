package com.bookinghotels.controller.flujo;

import com.bookinghotels.constants.Categoria;
import com.bookinghotels.controller.AlojamientoController;
import com.bookinghotels.controller.HuespedController;
import com.bookinghotels.controller.ReservaController;
import com.bookinghotels.interfaces.IDiaDeSol;
import com.bookinghotels.model.alojamiento.Alojamiento;
import com.bookinghotels.model.alojamiento.Habitacion;
import com.bookinghotels.model.data.HuespedData;
import com.bookinghotels.utils.CalculadoraPrecio;
import com.bookinghotels.utils.ConsolaUtils;

import java.time.LocalDate;
import java.util.List;

public class BuscarYReservarController {
  private final AlojamientoController alojamientoController;
  private final HuespedController huespedController;
  private final ReservaController reservaController;

  public BuscarYReservarController(AlojamientoController alojamientoController, HuespedController huespedController, ReservaController reservaController) {
    this.alojamientoController = alojamientoController;
    this.huespedController = huespedController;
    this.reservaController = reservaController;
  }

  public void iniciarFlujoReserva(Categoria categoria, LocalDate fechaInicio, LocalDate fechaFin, Integer cantPersonas) {
    Integer cantHabitaciones = pedirHabitaciones(categoria);

    manejoBusquedaAlojamientos(categoria, fechaInicio,  fechaFin,cantPersonas, cantHabitaciones);
    Alojamiento alojamientoSeleccionado = alojamientoController.buscarAlojamiento();
    List<Habitacion> habitacionesSeleccionadas = manejoDeSeleccionHabitaciones(alojamientoSeleccionado, categoria, cantHabitaciones, fechaInicio, fechaFin);

    HuespedData huesped = huespedController.registrarHuesped();

    String respuesta = reservaController.crearReserva(alojamientoSeleccionado, huesped, fechaInicio, fechaFin, habitacionesSeleccionadas);
    System.out.println(respuesta);
  }

  public void iniciarFlujoReservaDiaSol(LocalDate fecha, Integer cantPersonas){
    alojamientoController.buscarDiaSol(fecha, cantPersonas).forEach(IDiaDeSol::mostrarInfoDiaDeSol);
    Alojamiento alojamientoSeleccionado = alojamientoController.buscarAlojamiento();
    HuespedData huesped = huespedController.registrarHuesped();
    String respuesta = reservaController.crearReserva(alojamientoSeleccionado, huesped, fecha, cantPersonas);
    System.out.println(respuesta);
  }

  private List<Habitacion> manejoDeSeleccionHabitaciones(Alojamiento alojamientoSeleccionado, Categoria categoria, Integer cantHabitaciones, LocalDate fechaInicio, LocalDate fechaFin){
    List<Habitacion> habitacionesSeleccionadas = null;
    if(categoria.equals(Categoria.HOTEL)){
      List<Habitacion> habitaciones = manejoHabitaciones(alojamientoSeleccionado,fechaInicio,fechaFin);
      habitacionesSeleccionadas = alojamientoController.confirmarHabitaciones(habitaciones,cantHabitaciones);
    }
    return habitacionesSeleccionadas;
  }

  private Integer pedirHabitaciones(Categoria categoria){
    Integer cantidad;
    cantidad =  categoria.equals(Categoria.HOTEL) ? ConsolaUtils.obtenerEntero("¿Cuántas habitaciones necesitas?:") : 0;
    return cantidad;
  }

  private void manejoBusquedaAlojamientos(Categoria categoria, LocalDate fechaInicio, LocalDate fechaFin, Integer cantPersonas, Integer cantHabitaciones){
    List<Alojamiento> alojamientos = alojamientoController.buscarAlojamientos(categoria, fechaInicio, fechaFin, cantPersonas, cantHabitaciones);
    if (alojamientos.isEmpty()) {
      System.out.println("No hay alojamientos disponibles.");
    }
    alojamientos.forEach(alojamiento -> CalculadoraPrecio.calcularPrecios(alojamiento,fechaInicio,fechaFin));
  }

  private List<Habitacion> manejoHabitaciones(Alojamiento alojamientoSeleccionado, LocalDate fechaInicio, LocalDate fechaFin){
    List<Habitacion> habitaciones = alojamientoController.obtenerHabitaciones(alojamientoSeleccionado, fechaInicio, fechaFin);
    if (habitaciones.isEmpty()) {
      System.out.println("No hay habitaciones disponibles.");
    }
    habitaciones.forEach(Habitacion::mostrarDetalles);
    return habitaciones;
  }
}
