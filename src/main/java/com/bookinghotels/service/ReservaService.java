package com.bookinghotels.service;

import com.bookinghotels.model.alojamiento.Alojamiento;
import com.bookinghotels.model.alojamiento.Habitacion;
import com.bookinghotels.model.data.HuespedData;
import com.bookinghotels.model.data.ReservaData;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ReservaService {
    private List<ReservaData<?>> reservas;

    // Constructor
    public ReservaService(List<ReservaData<?>> reservas) {
        this.reservas = reservas;
    }

    //Métodos
    public boolean crearReserva(Alojamiento alojamiento, HuespedData huesped, LocalDate fechaInicio, LocalDate fechaFin, List<Habitacion> habitacionesReservadas) {
        boolean disponible = alojamiento.estaDisponible(fechaInicio, fechaFin, habitacionesReservadas.size(), habitacionesReservadas.size(), reservas);

        if (disponible) {
            ReservaData<?> nuevaReserva = new ReservaData<>(alojamiento, huesped, fechaInicio, fechaFin, null, habitacionesReservadas);
            reservas.add(nuevaReserva);
            return true;
        }
        return false;
    }

    public List<ReservaData<?>> buscarReservasPorHuesped(HuespedData huesped) {
        return reservas.stream()
                .filter(reserva -> reserva.getHuesped().equals(huesped))
                .collect(Collectors.toList());
    }

    public List<ReservaData<?>> buscarReservasPorAlojamiento(Alojamiento alojamiento) {
        return reservas.stream()
                .filter(reserva -> reserva.getAlojamiento().equals(alojamiento))
                .collect(Collectors.toList());
    }

}
