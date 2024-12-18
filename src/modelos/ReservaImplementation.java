package modelos;

public class ReservaImplementation implements IReserva {

    private ReservaData reserva;

    public ReservaImplementation(ReservaData reserva) {
        this.reserva = reserva;
    }

    public ReservaImplementation() {
    }

    @Override
    public void crearReserva() {

    }

    @Override
    public void actualizarReserva() {

    }

    @Override
    public void eliminarReserva() {

    }

    @Override
    public String mostrarReserva() {
        return "";
    }

    // getters and setters
    public ReservaData getReserva() {
        return reserva;
    }

    public void setReserva(ReservaData reserva) {
        this.reserva = reserva;
    }
}
