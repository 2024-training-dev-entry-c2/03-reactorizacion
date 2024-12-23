package com.bookinghotels.service.reserva;

import com.bookinghotels.interfaces.ICommand;
import com.bookinghotels.model.alojamiento.Alojamiento;
import com.bookinghotels.model.data.HuespedData;
import com.bookinghotels.model.data.ReservaDiaSolData;
import com.bookinghotels.repositories.ReservaRepository;
import com.bookinghotels.utils.ConsolaUtils;

import java.time.LocalDate;
import java.time.LocalTime;

public class CrearReservaDiaSolCommand implements ICommand {
  private final ReservaRepository repository;
  private Alojamiento alojamiento;
  private HuespedData huesped;
  private LocalDate fecha;
  private Integer cantPersonas;

  public CrearReservaDiaSolCommand(ReservaRepository repository, Alojamiento alojamiento, HuespedData huesped, LocalDate fecha, Integer cantPersonas){
    this.repository = repository;
    this.alojamiento = alojamiento;
    this.huesped = huesped;
    this.fecha = fecha;
    this.cantPersonas = cantPersonas;
  }

  @Override
  public ReservaDiaSolData execute() {
    LocalTime horaLlegada= ConsolaUtils.parseHora(ConsolaUtils.obtenerEntrada("Ingresa la hora estimada de llegada (HH:mm): "));
    ReservaDiaSolData reserva = new ReservaDiaSolData(this.alojamiento,this.huesped,this.fecha,this.cantPersonas,horaLlegada);
    repository.addReserva(reserva);
    return reserva;
  }
}
