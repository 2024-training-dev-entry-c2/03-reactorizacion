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

        System.out.println("Nombre: " + getNombre());
        System.out.println("Ciudad: " + getCiudad());
        System.out.println("Calificacion: " + getCalificacion());
        System.out.println("Precio por noche: " + getPrecioNoche());
        System.out.println("Cantidad de habitaciones: " + getCantidadHabitaciones());
        System.out.println("Descripcion: " + getDescripcion());
        getDiaSol().mostrarDatos();
    }

    // Getters and setters

    public DiaSol getDiaSol() {
        return diaSol;
    }

    public void setDiaSol(DiaSol diaSol) {
        this.diaSol = diaSol;
    }

    public float getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(float precioNoche) {
        this.precioNoche = precioNoche;
    }

    public int getCantidadHabitaciones() {
        return cantidadHabitaciones;
    }

    public void setCantidadHabitaciones(int cantidadHabitaciones) {
        this.cantidadHabitaciones = cantidadHabitaciones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
