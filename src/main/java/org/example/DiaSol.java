package org.example;

public class DiaSol {
    private Double precio;
    private String actividades;

    public DiaSol(Double precio, String actividades) {
        this.precio = precio;
        this.actividades = actividades;
    }

    public String getActividades() {
        return actividades;
    }

    public void setActividades(String actividades) {
        this.actividades = actividades;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }


}
