package com.bookinghotels.interfaces;

import com.bookinghotels.modelos.Habitacion;
import com.bookinghotels.modelos.ReservaData;

import java.time.LocalDate;

public interface IReserva {
    void agregarReserva(ReservaData reserva);
    void eliminarReserva(ReservaData reserva);
    void actualizarReserva(String correo, LocalDate fechaNacimiento, Habitacion habitacionACambiar, Habitacion nuevaHabitacion);
    void mostrarReserva(String correo, LocalDate fechaNacimiento);
}
