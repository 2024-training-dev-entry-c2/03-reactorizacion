package org.example.interfaces;

import org.example.models.Alojamiento;
import org.example.models.Cliente;

import java.time.LocalDate;

public interface IReserva {
    void crearReserva(Cliente cliente, Alojamiento alojamiento, String tipoHabitacion, LocalDate fechaInicio, LocalDate fechaFin);
    void actualizarReserva(Cliente cliente, String nuevoTipoHabitacion);
    void mostrarReserva();
}
