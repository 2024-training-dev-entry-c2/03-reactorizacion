package LogicaDeNegocios;

import alojamientos.Alojamiento;

import java.util.ArrayList;

public class FiltroReservas {

    public Alojamiento encontrarAlojamiento(ArrayList<Alojamiento> alojamientos,String nombreAlojamiento){
        for (int i = 0; i < alojamientos.size(); i++) {
            if (alojamientos.get(i).getNombre().equals(nombreAlojamiento)) {
                return alojamientos.get(i);
            }
        }
        return null;
    }




}
