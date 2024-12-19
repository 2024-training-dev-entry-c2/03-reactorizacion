package LogicaDeNegocios;

import alojamientos.Alojamiento;
import alojamientos.IDiaDeSol;
import habitaciones.Habitacion;

import java.util.ArrayList;

public class FiltroAlojamiento {


    public void buscarAlojamientos(String ciudad, String tipoAlojamiento, int mesInicio, int diaInicio, int mesFinalizacion, int diaFinalizacion, int cantAdultos, int cantNinos, int numHabitaciones, ArrayList<Alojamiento> alojamientos) {
        for (Alojamiento alojamiento : alojamientos) {
            if (alojamiento.getCiudad().equalsIgnoreCase(ciudad) && validarTipoAlojamiento(alojamiento, tipoAlojamiento)) {
                if (esAlojamientoConDiaDeSol(tipoAlojamiento, alojamiento)) {
                    mostrarHabitacionesDisponibles(alojamiento, numHabitaciones, diaInicio, diaFinalizacion);
                } else if (!tipoAlojamiento.equalsIgnoreCase("dia de sol")) {
                    mostrarHabitacionesDisponibles(alojamiento, numHabitaciones, diaInicio, diaFinalizacion);
                }
            }
        }
    }

    private boolean validarTipoAlojamiento(Alojamiento alojamiento, String tipoAlojamiento) {
        return tipoAlojamiento.equalsIgnoreCase("dia de sol")
                ? alojamiento instanceof IDiaDeSol
                : alojamiento.getTipo().equalsIgnoreCase(tipoAlojamiento);
    }

    private boolean esAlojamientoConDiaDeSol(String tipoAlojamiento, Alojamiento alojamiento) {
        return tipoAlojamiento.equalsIgnoreCase("dia de sol") && alojamiento instanceof IDiaDeSol && ((IDiaDeSol) alojamiento).tieneDiaDeSol();
    }

    private void mostrarHabitacionesDisponibles(Alojamiento alojamiento, int numHabitaciones, int diaInicio, int diaFinalizacion) {
        for (Habitacion habitacion : alojamiento.getHabitaciones()) {
            if (habitacion.getHabitacionesDisponibles() >= numHabitaciones) {
                alojamiento.mostrarInformacion(numHabitaciones, diaInicio, diaFinalizacion);
                break;
            }
        }
    }

}
