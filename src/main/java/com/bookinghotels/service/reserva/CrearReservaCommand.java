package com.bookinghotels.service.reserva;

import com.bookinghotels.interfaces.ICommand;
import com.bookinghotels.model.alojamiento.Habitacion;
import com.bookinghotels.model.data.HuespedData;
import com.bookinghotels.model.data.ReservaData;
import com.bookinghotels.repositories.ReservaRepository;
import com.bookinghotels.utils.ConsolaUtils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class CrearReservaCommand<T> implements ICommand {
  private final ReservaRepository repository;
  private T alojamiento;
  private HuespedData huesped;
  private LocalDate fechaInicio;
  private LocalDate fechaFin;
  private List<Habitacion> habitacionesSeleccionadas;

  public CrearReservaCommand(ReservaRepository repository, T alojamiento, HuespedData huesped, LocalDate fechaInicio, LocalDate fechaFin, List<Habitacion> habitacionesSeleccionadas) {
    this.repository = repository;
    this.alojamiento = alojamiento;
    this.huesped = huesped;
    this.fechaInicio = fechaInicio;
    this.fechaFin = fechaFin;
    this.habitacionesSeleccionadas = habitacionesSeleccionadas;
  }


  @Override
  public ReservaData<?> execute() {
    LocalTime horaLlegada= ConsolaUtils.parseHora(ConsolaUtils.obtenerEntrada("Ingresa la hora estimada de llegada (HH:mm): "));
    ReservaData<?> reserva = new ReservaData<>(this.alojamiento,this.huesped,this.fechaInicio,this.fechaFin,horaLlegada,habitacionesSeleccionadas);
    repository.addReserva(reserva);
    return reserva;
  }

}
