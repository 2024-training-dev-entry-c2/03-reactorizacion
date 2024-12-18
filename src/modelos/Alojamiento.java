package modelos;

import java.util.ArrayList;

public class Alojamiento {

    protected String nombreAlojamiento;
    protected String ciudadDestino;
    protected Integer maxAdultos;
    protected Integer maxNinos;
    protected Double calificacion;
    protected ArrayList<Habitacion> habitacion;

    public Alojamiento(String nombreAlojamiento, String ciudadDestino, Integer maxAdultos, Integer maxNinos, Double calificacion, ArrayList<Habitacion> habitacion) {
        this.nombreAlojamiento = nombreAlojamiento;
        this.ciudadDestino = ciudadDestino;
        this.maxAdultos = maxAdultos;
        this.calificacion = calificacion;
        this.maxNinos = maxNinos;
        this.habitacion = habitacion;
    }

    public Alojamiento() {
    }

    // getters and setters
    public String getNombreAlojamiento() {
        return nombreAlojamiento;
    }

    public void setNombreAlojamiento(String nombreAlojamiento) {
        this.nombreAlojamiento = nombreAlojamiento;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public Integer getMaxNinos() {
        return maxNinos;
    }

    public void setMaxNinos(Integer maxNinos) {
        this.maxNinos = maxNinos;
    }

    public Integer getMaxAdultos() {
        return maxAdultos;
    }

    public void setMaxAdultos(Integer maxAdultos) {
        this.maxAdultos = maxAdultos;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public ArrayList<Habitacion> getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(ArrayList<Habitacion> habitacion) {
        this.habitacion = habitacion;
    }
}
