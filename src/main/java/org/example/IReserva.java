package org.example;

import java.time.LocalDate;

public interface IReserva {
    public boolean reservar(Cliente cliente, Alojamientos alojamientos, Habitacion habitacion, LocalDate fechaIngreso, LocalDate fechaSalida);
    boolean cancelarReserva(Habitacion habitacion);
    boolean  actualizarReserva(Habitacion habitacion);


}
