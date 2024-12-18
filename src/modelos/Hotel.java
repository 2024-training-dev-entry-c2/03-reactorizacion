package modelos;

import java.util.ArrayList;

public class Hotel extends Alojamiento implements IDiaDeSol{
    private DiaDeSolData diaDeSol;
    private boolean servicioHabitacion;

    public Hotel(String nombreAlojamiento, String ciudadDestino, Integer maxAdultos, Float calificacion, Integer maxNinos, ArrayList<Habitacion> habitacion, DiaDeSolData diaDeSol, boolean servicioHabitacion) {
        super(nombreAlojamiento, ciudadDestino, maxAdultos, calificacion, maxNinos, habitacion);
        this.diaDeSol = diaDeSol;
        this.servicioHabitacion = servicioHabitacion;
    }

    public Hotel() {
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

    public boolean isServicioHabitacion() {
        return servicioHabitacion;
    }

    public void setServicioHabitacion(boolean servicioHabitacion) {
        this.servicioHabitacion = servicioHabitacion;
    }
}
