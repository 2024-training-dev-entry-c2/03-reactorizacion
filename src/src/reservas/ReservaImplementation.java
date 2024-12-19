package reservas;

import alojamientos.Alojamiento;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class ReservaImplementation implements IReserva {

    private ArrayList<ReservaData>  reservas;
    private Integer indice;

    public ReservaImplementation() {
        reservas = new ArrayList<>();
    }

    @Override
    public void agregarReserva(ReservaData reserva) {
        this.reservas.add(reserva);
        System.out.println("Se ha realizado la reserva con éxito");
    }

    @Override
    public void eliminarReserva(ReservaData reserva) {
        this.reservas.remove(reserva);
    }

    @Override
    public void mostrarReserva(String correo, String fechaNacimiento) {
        if(encontrarReserva(correo,fechaNacimiento)){
            System.out.println("****Reserva Encontrada****");
            System.out.println("Alojamiento: "+reservas.get(indice).getAlojamiento().getNombre());
            System.out.println("Cliente: "+reservas.get(indice).getCliente().getNombre()+" "+reservas.get(indice).getCliente().getApellido());
            System.out.println("Habitacion:"+ reservas.get(indice).getHabitacion().getTipo());
            System.out.println("Cantidad de habitaciones:"+reservas.get(indice).getCantidadHabitaciones());
            System.out.println("Fecha inicio:"+reservas.get(indice).getFechaInicio());
            System.out.println("Fecha Fin:"+reservas.get(indice).getFechaFin());
            System.out.println("Hora llegada:"+reservas.get(indice).getHoraLLegada());
        }else{
            System.out.println("Reserva no encontrada");
        }
    }

    public Boolean encontrarReserva(String correo, String fechaNacimiento){
        for (int i = 0; i < this.reservas.size(); i++) {
            String correoRecibido = correo;
            String fechaCumpleañosRecibida = fechaNacimiento;
            if (reservas.get(i).getCliente().getCorreo().equals(correoRecibido) && reservas.get(i).getCliente().getFechaNacimiento().equals(fechaCumpleañosRecibida)) {
                this.indice=i;
                return true;
            }
        }
        return false;
    }

    public Integer getIndice() {
        return indice;
    }

    public ArrayList<ReservaData> getReservas() {
        return reservas;
    }
}
