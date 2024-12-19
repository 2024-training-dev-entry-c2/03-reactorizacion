package clases;

import interfaces.IReserva;

public class ReservaImplementacion implements IReserva {

    private Reserva reserva;

    public ReservaImplementacion(Reserva reserva) {
        this.reserva = reserva;
    }

    @Override
    public void confirmarReserva() {
        System.out.println("Reserva confirmada:");
        System.out.println("Cliente: " + reserva.getCliente().getNombre() + " " + reserva.getCliente().getApellido());
        System.out.println("Alojamiento: " + reserva.getAlojamiento());
        System.out.println("Habitación: " + reserva.getHabitacion().mostrarInformacion());
        System.out.println("Fechas: " + reserva.getFechaInicio() + " a " + reserva.getFechaFin());
        System.out.println("Hora de llegada: " + reserva.getHoraLlegada());
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Información de la reserva:");
        System.out.println("Cliente: " + reserva.getCliente().getNombre() + " " + reserva.getCliente().getApellido());
        System.out.println("Alojamiento: " + reserva.getAlojamiento());
        System.out.println("Habitación: " + reserva.getHabitacion().mostrarInformacion());
        System.out.println("Fechas: " + reserva.getFechaInicio() + " a " + reserva.getFechaFin());
        System.out.println("Hora de llegada: " + reserva.getHoraLlegada());
    }

    @Override
    public void cancelarReserva() {
        System.out.println("Reserva cancelada.");
    }

    @Override
    public void modificarHabitacion() {
        System.out.println("Modificando habitación...");
    }

    @Override
    public void modificarAlojamiento() {
        System.out.println("Modificando alojamiento...");
    }

    @Override
    public void setFechaInicio() {
    }

    @Override
    public void setFechaFin() {
    }

    @Override
    public void setHoraLlegada() {
    }

    @Override
    public void setCantidadHabitacion() {
    }
}
