package LogicaDeNegocios;

import alojamientos.Alojamiento;
import alojamientos.IDiaDeSol;
import habitaciones.Habitacion;

import java.util.ArrayList;

public class FiltroAlojamiento {

//    public void buscarHoteles(String ciudad, String tipoAlojamiento, int mesInicio, int diaInicio, int mesFinalizacion, int diaFinalizacion, int cantAdultos, int cantNinos, int numHabitaciones, ArrayList<Alojamiento> alojamientos){
//        if(!tipoAlojamiento.equals("dia de sol")){
//            for (int i = 0; i < alojamientos.size(); i++){
//                if(alojamientos.get(i).getCiudad().equals(ciudad) && alojamientos.get(i).getTipo().equals(tipoAlojamiento)){
//                    for(int j = 0; j < alojamientos.get(i).getHabitaciones().size(); j++){
//                        if(alojamientos.get(i).getHabitaciones().get(j).getHabitacionesDisponibles()>=numHabitaciones){
//                            alojamientos.get(i).mostrarInformacion(numHabitaciones,diaInicio,diaFinalizacion);
//                            break;
//                        }
//                    }
//                }
//            }
//        }else{
//            buscarDiaDeSol(ciudad, tipoAlojamiento, mesInicio, diaInicio, mesFinalizacion, diaFinalizacion, cantAdultos, cantNinos,numHabitaciones,alojamientos);
//        }
//    }

    public void buscarHoteles(String ciudad, String tipoAlojamiento, int mesInicio, int diaInicio, int mesFinalizacion, int diaFinalizacion, int cantAdultos, int cantNinos, int numHabitaciones, ArrayList<Alojamiento> alojamientos) {
        if (!tipoAlojamiento.equalsIgnoreCase("dia de sol")) {
            for (Alojamiento alojamiento : alojamientos) {
                if (alojamiento.getCiudad().equalsIgnoreCase(ciudad) && alojamiento.getTipo().equalsIgnoreCase(tipoAlojamiento)) {
                    for (Habitacion habitacion : alojamiento.getHabitaciones()) {
                        if (habitacion.getHabitacionesDisponibles() >= numHabitaciones) {
                            alojamiento.mostrarInformacion(numHabitaciones, diaInicio, diaFinalizacion);
                            break;
                        }
                    }
                }
            }
        } else {
            buscarDiaDeSol(ciudad, tipoAlojamiento, mesInicio, diaInicio, mesFinalizacion, diaFinalizacion, cantAdultos, cantNinos, numHabitaciones, alojamientos);
        }
    }

    public void buscarDiaDeSol(String ciudad, String tipoAlojamiento, int mesInicio, int diaInicio, int mesFinalizacion, int diaFinalizacion, int cantAdultos, int cantNinos, int numHabitaciones, ArrayList<Alojamiento> alojamientos) {
        for (Alojamiento alojamiento : alojamientos) {
            if (alojamiento.getCiudad().equalsIgnoreCase(ciudad) && alojamiento instanceof IDiaDeSol) {
                IDiaDeSol alojamientoConDiaDeSol = (IDiaDeSol) alojamiento;
                if (alojamientoConDiaDeSol.tieneDiaDeSol()) {
                    for (Habitacion habitacion : alojamiento.getHabitaciones()) {
                        if (habitacion.getHabitacionesDisponibles() >= numHabitaciones) {
                            alojamiento.mostrarInformacion(numHabitaciones, diaInicio, diaFinalizacion);
                            break;
                        }
                    }
                }
            }
        }
    }



//    public void buscarDiaDeSol(String ciudad, String tipoAlojamiento, int mesInicio, int diaInicio, int mesFinalizacion, int diaFinalizacion, int cantAdultos, int cantNinos, int numHabitaciones, ArrayList<Alojamiento> alojamientos) {
//        for (Alojamiento alojamiento : alojamientos) {
//            if (alojamiento.getCiudad().equals(ciudad) && alojamiento.getTipo().equals(tipoAlojamiento)) {
//                if (alojamiento instanceof IDiaDeSol) {
//                    IDiaDeSol alojamientoConDiaDeSol = (IDiaDeSol) alojamiento;
//                    if (alojamientoConDiaDeSol.tieneDiaDeSol()) {
//                        for (Habitacion habitacion : alojamiento.getHabitaciones()) {
//                            if (habitacion.getHabitacionesDisponibles() >= numHabitaciones) {
//                                alojamiento.mostrarInformacion(numHabitaciones, diaInicio, diaFinalizacion);
//                                break;
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }




}
