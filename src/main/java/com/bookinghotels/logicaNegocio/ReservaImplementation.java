package com.bookinghotels.logicaNegocio;

import com.bookinghotels.modelos.IReserva;
import com.bookinghotels.modelos.ReservaData;

import java.util.List;

public class ReservaImplementation implements IReserva {
    private List<ReservaData> reservasData;

    // Métodos
    @Override
    public void agregarReserva(ReservaData reserva) {
        reservasData.add(reserva);
    }

    @Override
    public void eliminarReserva(ReservaData reserva) {
        reservasData.remove(reserva);
    }

    @Override
    public void actualizarReserva() {
    }

    @Override
    public void mostrarReserva() {

    }
}
