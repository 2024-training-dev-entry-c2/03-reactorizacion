package modelos;

public class DiaDeSolData {
    private String actividades;
    private String extras;

    public DiaDeSolData(String actividades, String extras) {
        this.actividades = actividades;
        this.extras = extras;
    }

    public DiaDeSolData() {
    }

    // getters and setters
    public String getActividades() {
        return actividades;
    }

    public String getExtras() {
        return extras;
    }
}
