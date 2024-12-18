package org.example;

public class ReservaImplementation implements IReserva {
 private  ReservaData reservaData;

    public ReservaImplementation(ReservaData reservaData) {
        this.reservaData = reservaData;
    }

    @Override
    public boolean reservar(int idReserva, String detalles) {
        return false;
    }

    @Override
    public boolean cancelarReserva(int idReserva) {
        return false;
    }

    @Override
    public boolean actualizarReserva(int idReserva, String nuevosDetalles) {
        return false;
    }
}
