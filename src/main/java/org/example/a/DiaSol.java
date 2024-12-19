package org.example.a;

import java.util.LinkedList;

public class DiaSol {
    private LinkedList<String> actividades;
    private Boolean incluyeAlmuerzo;

    public DiaSol(LinkedList<String> actividades, boolean incluyeAlmuerzo) {
        this.actividades = actividades;
        this.incluyeAlmuerzo = incluyeAlmuerzo;
    }


    public void mostrarDatos() {
        System.out.println("Incluye almuerzo: " + isIncluyeAlmuerzo());
        System.out.println("Actividades: ");
        for (int i = 0; i < getActividades().size(); i++) {
            System.out.println((i + 1) + " - " + getActividades().get(i));
        }
    }

    // Getters and setters

    public LinkedList<String> getActividades() {
        return actividades;
    }

    public boolean isIncluyeAlmuerzo() {
        return incluyeAlmuerzo;
    }

}
