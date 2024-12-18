package alojamientos;

import java.util.ArrayList;

public class DiaDeSolData {

   private String actividades;
   private ArrayList<String> extras;
   private Double precio;

    public DiaDeSolData(String actividades, ArrayList<String> extras, Double precio) {
        this.actividades = actividades;
        this.extras = extras;
        this.precio = precio;
    }

    public String getActividades() {
        return actividades;
    }

    public void setActividades(String actividades) {
        this.actividades = actividades;
    }

    public ArrayList<String> getExtras() {
        return extras;
    }

    public void setExtras(ArrayList<String> extras) {
        this.extras = extras;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
