package org.example;

public interface IReserva {
    boolean reservar(int idReserva, String detalles);
    boolean cancelarReserva(int idReserva);
    boolean actualizarReserva(int idReserva, String nuevosDetalles);
}
