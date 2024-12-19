package org.example;

public class DiaSol {
    private Double precio;
    private String actividades;

    public DiaSol(double precio, String actividades) {
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

    public void setPrecio(double precio) {
        this.precio = precio;
    }


}
