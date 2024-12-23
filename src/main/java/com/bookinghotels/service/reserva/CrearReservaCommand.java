package com.bookinghotels.service.reserva;

import com.bookinghotels.interfaces.ICommand;
import com.bookinghotels.model.alojamiento.Alojamiento;
import com.bookinghotels.model.alojamiento.Habitacion;
import com.bookinghotels.model.data.HuespedData;
import com.bookinghotels.model.data.ReservaData;
import com.bookinghotels.repositories.ReservaRepository;
import com.bookinghotels.utils.ConsolaUtils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class CrearReservaCommand implements ICommand {
  private final ReservaRepository repository;
  private final ConsolaUtils consola;
  private Alojamiento alojamiento;
  private HuespedData huesped;
  private LocalDate fechaInicio;
  private LocalDate fechaFin;
  private List<Habitacion> habitacionesSeleccionadas;

  public CrearReservaCommand(ReservaRepository repository, Alojamiento alojamiento, HuespedData huesped, LocalDate fechaInicio, LocalDate fechaFin, List<Habitacion> habitacionesSeleccionadas, ConsolaUtils consola) {
    this.repository = repository;
    this.alojamiento = alojamiento;
    this.huesped = huesped;
    this.fechaInicio = fechaInicio;
    this.fechaFin = fechaFin;
    this.habitacionesSeleccionadas = habitacionesSeleccionadas;
    this.consola = consola;
  }


  @Override
  public ReservaData<?> execute() {
    LocalTime horaLlegada= consola.parseHora(consola.obtenerEntrada("Ingresa la hora estimada de llegada (HH:mm): "));
    ReservaData<?> reserva = new ReservaData<>(this.alojamiento,this.huesped,this.fechaInicio,this.fechaFin,horaLlegada,habitacionesSeleccionadas);
    repository.addReserva(reserva);
    return reserva;
  }

}
