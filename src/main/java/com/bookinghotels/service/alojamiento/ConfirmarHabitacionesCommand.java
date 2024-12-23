package com.bookinghotels.service.alojamiento;

import com.bookinghotels.interfaces.ICommand;
import com.bookinghotels.model.alojamiento.Habitacion;
import com.bookinghotels.utils.ConsolaUtils;

import java.util.ArrayList;
import java.util.List;

public class ConfirmarHabitacionesCommand implements ICommand {
  private List<Habitacion> habitaciones;
  private List<Habitacion> habitacionesSeleccionadas;
  private Integer contadorHabitaciones;

  public ConfirmarHabitacionesCommand(List<Habitacion> habitaciones, Integer cantHabitaciones) {
    this.habitaciones = habitaciones;
    this.habitacionesSeleccionadas = new ArrayList<>();
    this.contadorHabitaciones = cantHabitaciones;
  }

  @Override
  public List<Habitacion> execute() {
    habitaciones.forEach(habitacion -> {
      if (Boolean.FALSE.equals(verificarCompletado())) {
        solicitarCantidadHabitacion(habitacion);
      }
    });
    return habitacionesSeleccionadas;
  }

  private void solicitarCantidadHabitacion(Habitacion habitacion) {
    Integer cantHabitaciones = ConsolaUtils.obtenerEntero("Ingresa la cantidad de '" + habitacion.getTipo() + "' que deseas: ");
    if (verificarLimiteHabitaciones(cantHabitaciones)) {
      agregarHabitaciones(habitacion, cantHabitaciones);
    } else {
      int habitacionesRestantes = contadorHabitaciones;
      agregarHabitaciones(habitacion, habitacionesRestantes);
    }
  }

  private Boolean verificarLimiteHabitaciones(Integer cantHabitaciones) {
    return cantHabitaciones <= this.contadorHabitaciones;
  }

  private Boolean verificarCompletado() {
    return this.contadorHabitaciones == 0;
  }

  private void agregarHabitaciones(Habitacion habitacion, Integer cantHabitaciones){
    for (int i = 0; i < cantHabitaciones; i++) {
      habitacionesSeleccionadas.add(habitacion);
      contadorHabitaciones--;
    }
  }
}
