package com.bookinghotels.interfaces;


import com.bookinghotels.model.alojamiento.Habitacion;
import com.bookinghotels.model.data.ReservaData;

import java.time.LocalDate;

public interface IReserva {
    void agregarReserva(ReservaData reserva);
    void eliminarReserva(ReservaData reserva);
    void actualizarReserva(String correo, LocalDate fechaNacimiento, Habitacion habitacionACambiar, Habitacion nuevaHabitacion);
    void mostrarReserva(String correo, LocalDate fechaNacimiento);
}
