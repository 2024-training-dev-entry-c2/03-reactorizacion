package org.example;

import java.time.LocalDate;

public interface IReserva {
    public boolean reservar(Cliente cliente, Alojamientos alojamientos, Habitacion habitacion, LocalDate fechaIngreso, LocalDate fechaSalida);
    boolean cancelarReserva(int idReserva);
    boolean actualizarReserva(int idReserva, String nuevosDetalles);

}
