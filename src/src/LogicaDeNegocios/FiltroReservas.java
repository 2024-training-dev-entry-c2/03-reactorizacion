package LogicaDeNegocios;

import alojamientos.Alojamiento;
import reservas.ReservaData;


import java.util.ArrayList;
import java.util.Scanner;

public class FiltroReservas {

    public Alojamiento encontrarAlojamiento(ArrayList<Alojamiento> alojamientos,String nombreAlojamiento){
        for (int i = 0; i < alojamientos.size(); i++) {
            if (alojamientos.get(i).getNombre().equals(nombreAlojamiento)) {
                return alojamientos.get(i);
            }
        }
        return null;
    }

    public void acomodarReserva(ReservaData reserva){
        Scanner scanner = new Scanner(System.in);
        mostrarHabitacionSeleccionada(reserva);
        mostrarHabitacionesDisponibles(reserva);

        int tipoHabitacion = 0;
        System.out.print("Ingrese el tipo de habitacion que busca (estandar[0], deluxe[1], suite2], familiar[3], economical[4]: ");
        tipoHabitacion = scanner.nextInt();
        scanner.nextLine();
    }

    public void mostrarHabitacionSeleccionada(ReservaData reserva){
        System.out.println(".........");
        System.out.println("Usted tiene: "+reserva.getCantidadHabitaciones()+" de tipo "+reserva.getHabitacion().getTipo());
    }

    public void mostrarHabitacionesDisponibles(ReservaData reserva){
        System.out.println("--HABITACIONES DISPONIBLES EN EL ALOJAMIENTO--");
        for (int i = 0; i <  reserva.getAlojamiento().getHabitaciones().size(); i++) {
            if(reserva.getAlojamiento().getHabitaciones().get(i).getHabitacionesDisponibles()>=reserva.getCantidadHabitaciones()){
                reserva.getAlojamiento().getHabitaciones().get(i).mostrarDetalles();
            }
        }
    }

}
