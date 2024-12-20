package com.bookinghotels.controller;

import com.bookinghotels.model.alojamiento.Alojamiento;
import com.bookinghotels.model.alojamiento.Habitacion;
import com.bookinghotels.model.data.HuespedData;
import com.bookinghotels.model.data.ReservaData;
import com.bookinghotels.service.ReservaService;

import java.time.LocalDate;
import java.util.List;

public class ReservaController {
    private ReservaService reservaService;

    // Constructor
    public ReservaController(List<ReservaData<?>> reservas) {
        this.reservaService = new ReservaService(reservas);
    }

    // Métodos
    public String crearReserva(Alojamiento alojamiento, HuespedData huesped, LocalDate fechaInicio, LocalDate fechaFin, List<Habitacion> habitacionesReservadas) {
        boolean reservaCreada = reservaService.crearReserva(alojamiento, huesped, fechaInicio, fechaFin, habitacionesReservadas);

        if (reservaCreada) {
            return "Reserva creada con éxito!";
        } else {
            return "Lo siento, no hay disponibilidad para las fechas seleccionadas.";
        }
    }
}
