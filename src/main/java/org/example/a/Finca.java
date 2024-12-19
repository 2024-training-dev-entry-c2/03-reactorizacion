package org.example.a;

public class Finca extends Alojamiento {
    private DiaSol diaSol;
    private Float precioNoche;
    private Integer cantidadHabitaciones;
    private String descripcion;

    public Finca(String nombre, String ciudad, float calificacion, DiaSol diaSol, float precioNoche, int cantidadHabitaciones, String descripcion) {
        super(nombre, ciudad, calificacion);
        this.diaSol = diaSol;
        this.precioNoche = precioNoche;
        this.cantidadHabitaciones = cantidadHabitaciones;
        this.descripcion = descripcion;
    }


    @Override
    public float calcularPrecioMasBajo(int diaInicio, int diaFinal) {
        return 0;
    }

    @Override
    public float calcularPrecio(float precio, int cantidadPersonas, int diaInicio, int diaFinal) {
        System.out.println(diaFinal + diaInicio);
        // Implementation for calculating hotel price
        return 2;
    }

    @Override
    public void verAlojamiento() {
        if(getDiaSol() == null) {
            System.out.println("No hay dia de sol");
            return;
        }

        System.out.println("Nombre: " + getNombre() +
                "\nCiudad: " + getCiudad() +
                "\nCalificación: " + getCalificacion() +
                "\nPrecio por noche: " + getPrecioNoche() +
                "\nCantidad de habitaciones: " + getCantidadHabitaciones() +
                "\nDescripción: " + getDescripcion());

        getDiaSol().mostrarDatos();
    }

    // Getters and setters

    public DiaSol getDiaSol() {
        return diaSol;
    }

    public float getPrecioNoche() {
        return precioNoche;
    }

    public int getCantidadHabitaciones() {
        return cantidadHabitaciones;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
