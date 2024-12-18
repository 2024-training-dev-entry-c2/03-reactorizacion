package reservas;

public class ReservaImplementation implements IReserva {

    private ReservaData reserva;

    public ReservaImplementation(ReservaData reserva) {
        this.reserva = reserva;
    }

    @Override
    public void agregarReserva() {

    }

    @Override
    public void eliminarReserva() {

    }

    @Override
    public void actualizarReserva() {

    }

    @Override
    public void mostrarReserva() {

    }

    public ReservaData getReserva() {
        return reserva;
    }

    public void setReserva(ReservaData reserva) {
        this.reserva = reserva;
    }
}
