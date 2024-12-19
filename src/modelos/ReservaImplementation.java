package modelos;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReservaImplementation implements IReserva {
private List<ReservaData> reservasData;
static Scanner scanner = new Scanner(System.in);

    public ReservaImplementation() {
        this.reservasData = new ArrayList<>();
    }

    @Override
    public void crearReserva(ReservaData reserva) {
        reservasData.add(reserva);
        System.out.println("\n¡Se ha realizado la reserva con éxito!: \n" + mostrarReserva(reserva));
        System.out.println("==========================================");
    }

    @Override
    public void actualizarReserva(ReservaData reserva) {
        boolean autenticacionExitosa = autenticarReserva(reserva);
        if (autenticacionExitosa) {
            System.out.println("\nReserva encontrada: \n" + mostrarReserva(reserva));
            actualizarHabitacion(reserva);
        } else { System.out.println("No se encontró una reserva con ese correo o fecha de nacimiento."); }
    }

    public void actualizarHabitacion(ReservaData reserva){
        System.out.println("Habitaciones actuales: ");
        for(int i = 0; i < reserva.getHabitacionesSeleccionadas().length; i ++) { System.out.println((i + 1) + ". " + reserva.getHabitacionesSeleccionadas()[i]); }
        System.out.println("Escriba el nombre de la habitación que desea cambiar:");
        String habitacionActual = scanner.nextLine();

        int indexHabitacionACambiarUsuario = -1;
        for (int i = 0; i < reserva.getHabitacionesSeleccionadas().length; i++) {
            if (reserva.getHabitacionesSeleccionadas()[i].equalsIgnoreCase(habitacionActual)) {
                indexHabitacionACambiarUsuario = i;
                break;
            }
        }
        if(indexHabitacionACambiarUsuario == -1) {System.out.println("No se encontro la habitacion"); return;}

        for (int i = 0; i < reserva.getAlojamiento().getHabitacion().size(); i++) {
            if (reserva.getAlojamiento().getHabitacion().get(i).getTiposDeHabitaciones().equalsIgnoreCase(habitacionActual)) {
                int habitaciones = reserva.getAlojamiento().getHabitacion().get(i).getHabitacionesDisponibles();
                reserva.getAlojamiento().getHabitacion().get(i).setHabitacionesDisponibles(habitaciones + 1);
            }
        }

        System.out.println("Habitaciones disponibles:");
        for (int i = 0; i < reserva.getAlojamiento().getHabitacion().size(); i++) {
            System.out.println((i + 1) + ". " + reserva.getAlojamiento().getHabitacion().get(i).getTiposDeHabitaciones());
        }
        System.out.println("Seleccione de 1 a 5 la nueva habitación:");
        int nuevaHabitacion = scanner.nextInt();
        scanner.nextLine();
        int habitaciones = reserva.getAlojamiento().getHabitacion().get(nuevaHabitacion - 1).getHabitacionesDisponibles();
        reserva.getAlojamiento().getHabitacion().get(nuevaHabitacion - 1).setHabitacionesDisponibles(habitaciones - 1);

        reserva.getHabitacionesSeleccionadas()[indexHabitacionACambiarUsuario] = reserva.getAlojamiento().getHabitacion().get(nuevaHabitacion - 1).getTiposDeHabitaciones();
        System.out.println("Habitaciones disponibles actualizadas: " + reserva.getAlojamiento().getHabitacion().get(nuevaHabitacion - 1).getHabitacionesDisponibles());
        System.out.println("La habitación ha sido cambiada exitosamente.");
    }

    public boolean autenticarReserva(ReservaData reserva){
        System.out.println("Ingrese su correo electrónico para autenticar su reserva:");
        String correo = scanner.nextLine();
        System.out.println("Ingrese su fecha de nacimiento (AAAA-MM-DD):");
        String nacimiento = scanner.nextLine();

        for (int i = 0; i < reservasData.size(); i++) {
            if (reservasData.get(i).getCliente().getCorreoUsuario().equals(correo) && reservasData.get(i).getCliente().getNacimientoUsuario().equals(nacimiento)) {
                return true;
            }
        } return false;
    }

    @Override
    public void eliminarReserva(ReservaData reserva) {
        boolean autenticacionExitosa = autenticarReserva(reserva);
        if (autenticacionExitosa) {
            System.out.println("Se ha eliminado la reserva actual.");
            for (int i = 0; i < reserva.getHabitacionesSeleccionadas().length; i++) {
                for (int j = 0; j < reserva.getAlojamiento().getHabitacion().size(); j++) {
                    if (reserva.getAlojamiento().getHabitacion().get(j).getTiposDeHabitaciones().equalsIgnoreCase(reserva.getHabitacionesSeleccionadas()[i])) {
                        int habitaciones = reserva.getAlojamiento().getHabitacion().get(j).getHabitacionesDisponibles();
                        reserva.getAlojamiento().getHabitacion().get(j).setHabitacionesDisponibles(habitaciones + 1);
                    }
                }
            }
            reservasData.remove(reserva);
        } else { System.out.println("No se encontró una reserva con ese correo o fecha de nacimiento.");}
    }

    @Override
    public String mostrarReserva(ReservaData reserva) {
        StringBuilder infoReserva = new StringBuilder();
        infoReserva.append("Reserva a nombre de: ").append(reserva.getCliente().getNombreUsuario()).append(" ").append(reserva.getCliente().getApellidoUsuario()).append("\n");
        infoReserva.append("Correo: ").append(reserva.getCliente().getCorreoUsuario()).append("\n");
        infoReserva.append("Nacionalidad: ").append(reserva.getCliente().getNacionalidadUsuario()).append("\n");
        infoReserva.append("Teléfono: ").append(reserva.getCliente().getTelefonoUsuario()).append("\n");
        infoReserva.append("Hora de llegada: ").append(reserva.getHoraLlegadaUsuario()).append("\n");
        infoReserva.append("Fecha de nacimiento: ").append(reserva.getCliente().getNacimientoUsuario()).append("\n");
        infoReserva.append("Habitaciones seleccionadas: \n");
        for (String habitacionSeleccionada : reserva.getHabitacionesSeleccionadas()) {
            infoReserva.append(habitacionSeleccionada).append("\n");
        }
        return infoReserva.toString();
    }

    // getters and setters
    public List<ReservaData> getReservaData() {
        return reservasData;
    }

    public void setReservaData(List<ReservaData> reservaData) {
        this.reservasData = reservaData;
    }
}
