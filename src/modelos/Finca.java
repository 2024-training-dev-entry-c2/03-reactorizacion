package modelos;

import java.util.ArrayList;

public class Finca extends Alojamiento implements IDiaDeSol{
    private DiaDeSolData diaDeSol;

    public Finca(String nombreAlojamiento, String ciudadDestino, Integer maxAdultos, Float calificacion, Integer maxNinos, ArrayList<Habitacion> habitacion, DiaDeSolData diaDeSol) {
        super(nombreAlojamiento, ciudadDestino, maxAdultos, calificacion, maxNinos, habitacion);
        this.diaDeSol = diaDeSol;
    }

    public Finca() {
    }

    @Override
    public Boolean tenerDiaDeSol() {
        return null;
    }

    @Override
    public String mostrarInfoDiaDeSol() {
        return "";
    }

    // getters and setters
    public DiaDeSolData getDiaDeSol() {
        return diaDeSol;
    }

    public void setDiaDeSol(DiaDeSolData diaDeSol) {
        this.diaDeSol = diaDeSol;
    }
}
