package alojamientos;

import java.util.ArrayList;

public class DiaDeSolData {

   private String actividades;
   private String extras;
   private Double precio;

    public DiaDeSolData(String actividades, String extras, Double precio) {
        this.actividades = actividades;
        this.extras = extras;
        this.precio = precio;
    }

    public DiaDeSolData() {
    }

    public String getActividades() {
        return actividades;
    }

    public String getExtras() {
        return extras;
    }

    public Double getPrecio() {
        return precio;
    }

}
