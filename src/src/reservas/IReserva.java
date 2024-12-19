package reservas;

public interface IReserva {

    public void agregarReserva(ReservaData reserva);
    public void eliminarReserva(ReservaData reserva);
    public void actualizarReserva(ReservaData reserva);
    public void mostrarReserva(String correo, String fechaNacimiento);

}
