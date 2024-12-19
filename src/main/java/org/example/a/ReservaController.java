package org.example.a;

public class ReservaController {
    private static Cliente cliente;
    private static Reserva reserva = new Reserva();

    public ReservaController() {
    }

    public static Reserva getReserva() {
        return reserva;
    }

}
