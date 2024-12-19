package modelos;

import java.time.LocalDate;

public interface IReserva {

    public void crearReserva(ReservaData reserva);

    public void actualizarReserva(ReservaData reserva);

    public void eliminarReserva(ReservaData reserva);

    public String mostrarReserva(ReservaData reserva);
}
