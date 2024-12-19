package org.example;

import java.time.LocalDate;

public interface IReserva {
    public Boolean reservar(Cliente cliente, Alojamientos alojamientos, Habitacion habitacion, LocalDate fechaIngreso, LocalDate fechaSalida);
    Boolean cancelarReserva(Habitacion habitacion);
    Boolean  actualizarReserva(Habitacion habitacion);


}
