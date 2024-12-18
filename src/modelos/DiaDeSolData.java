package modelos;

import java.util.ArrayList;

public class DiaDeSolData {
    private String actividades;
    private ArrayList<String> extras;

    public DiaDeSolData(String actividades, ArrayList<String> extras) {
        this.actividades = actividades;
        this.extras = extras;
    }

    public DiaDeSolData() {
    }

    // getters and setters
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
}
