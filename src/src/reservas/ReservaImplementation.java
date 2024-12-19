package reservas;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class ReservaImplementation implements IReserva {

    private ArrayList<ReservaData>  reservas;
    private Integer indice;

    public ReservaImplementation() {
    }

    @Override
    public void agregarReserva(ReservaData reserva) {
        this.reservas.add(reserva);
    }

    @Override
    public void eliminarReserva(ReservaData reserva) {
        this.reservas.remove(reserva);
    }

    @Override
    public void actualizarReserva(ReservaData reserva) {
        if(encontrarReserva(reserva)){
            this.reservas.set(this.indice,reserva);
        }
    }

    @Override
    public void mostrarReserva(ReservaData reserva) {
        if(encontrarReserva(reserva)){
            System.out.println("****Reserva Encontrada****");
            System.out.println("Alojamiento: "+reserva.getAlojamiento().getNombre());
            System.out.println("Cliente: "+reserva.getCliente().getNombre()+" "+reserva.getCliente().getApellido());
            System.out.println("Habitacion:"+ reserva.getHabitacion());
            System.out.println("Cantidad de habitaciones:"+reserva.getCantidadHabitaciones());
            System.out.println("Fecha inicio:"+reserva.getFechaInicio());
            System.out.println("Fecha Fin:"+reserva.getFechaFin());
            System.out.println("Hora llegada:"+reserva.getHoraLLegada());
        }else{
            System.out.println("Reserva no encontrada");
        }
    }

    public Boolean encontrarReserva(ReservaData reserva){
        for (int i = 0; i < this.reservas.size(); i++) {
            String correoRecibido = reserva.getCliente().getCorreo();
            String fechaCumpleañosRecibida = reserva.getCliente().getFechaNacimiento();
            if (reservas.get(i).getCliente().getCorreo().equals(correoRecibido) && reservas.get(i).getCliente().getFechaNacimiento().equals(fechaCumpleañosRecibida)) {
                this.indice=i;
                return true;
            }
        }
        return false;
    }

}
