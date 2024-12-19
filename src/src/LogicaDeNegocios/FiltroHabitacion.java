package LogicaDeNegocios;

import alojamientos.Alojamiento;
import habitaciones.Habitacion;

import java.util.ArrayList;

public class FiltroHabitacion {

    public void confirmarHabitaciones(String nombreHotel, int mesInicio, int diaInicio, int mesFinalizacion, int diaFinalizacion, int cantAdultos, int cantNinos, int numHabitaciones, ArrayList<Alojamiento> alojamientos) {
        for (Alojamiento alojamiento : alojamientos) {
            if (alojamiento.getNombre().equalsIgnoreCase(nombreHotel)) {
                boolean habitacionesEncontradas = false;

                for (Habitacion habitacion : alojamiento.getHabitaciones()) {
                    if (habitacion.getHabitacionesDisponibles() >= numHabitaciones) {
                        System.out.println("==== Detalles de la habitación ====");
                        habitacion.mostrarDetalles();
                        habitacionesEncontradas = true;
                    }
                }

                if (!habitacionesEncontradas) {
                    System.out.println("No hay habitaciones disponibles con la cantidad solicitada en este alojamiento.");
                }

                return;
            }
        }

        System.out.println("No se encontró ningún alojamiento con el nombre especificado.");
    }



}
