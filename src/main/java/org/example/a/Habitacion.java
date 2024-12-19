package org.example.a;

public class Habitacion {
    private String titulo;
    private String descripcion;
    private Integer cantidad;
    private Integer precio;

    public Habitacion(String titulo, String descripcion, int cantidad, int precio) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public void mostrarDatos() {
        System.out.println("Titulo: " + getTitulo());
        System.out.println("Descripcion : " + getDescripcion());
        System.out.println("Cantidad: " + getCantidad());
        System.out.println("Precio: $ " + getPrecio());
    }

    // Getters and setters

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getPrecio() {
        return precio;
    }

}
