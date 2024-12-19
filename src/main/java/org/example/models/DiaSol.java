package org.example.models;

import java.util.List;

public class DiaSol extends Alojamiento {
    private boolean incluyeAlmuerzo;
    private List<String> actividades;

    public DiaSol() {
    }

    public DiaSol(String nombre, String ubicacion, float calificacion, List<Habitacion> habitaciones, boolean incluyeAlmuerzo, List<String> actividades) {
        super(nombre, ubicacion, calificacion, habitaciones);
        this.incluyeAlmuerzo = incluyeAlmuerzo;
        this.actividades = actividades;
    }

    public boolean isIncluyeAlmuerzo() {
        return incluyeAlmuerzo;
    }

    public void setIncluyeAlmuerzo(boolean incluyeAlmuerzo) {
        this.incluyeAlmuerzo = incluyeAlmuerzo;
    }

    public List<String> getActividades() {
        return actividades;
    }

    public void setActividades(List<String> actividades) {
        this.actividades = actividades;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Día de Sol: " + getNombre() + ", Ubicación: " + getUbicacion() +
                ", Calificación: " + getCalificacion() + " estrellas, Almuerzo incluido: " +
                (incluyeAlmuerzo ? "Sí" : "No") + ", Actividades: " + String.join(", ", actividades));
    }
}
