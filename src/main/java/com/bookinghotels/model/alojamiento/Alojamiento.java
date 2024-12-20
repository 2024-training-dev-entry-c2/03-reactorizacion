package com.bookinghotels.model.alojamiento;

import com.bookinghotels.model.data.ReservaData;

import java.time.LocalDate;
import java.util.List;

public abstract class Alojamiento {
    protected String nombre;
    protected String ciudad;
    protected String categoria;
    protected Float calificacion;
    protected Integer maxPersonas;
    protected List<Habitacion> habitaciones;

    // Constructor
    public Alojamiento(String nombre, String ciudad, String categoria, Float calificacion, Integer maxPersonas) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.categoria = categoria;
        this.calificacion = calificacion;
        this.maxPersonas = maxPersonas;
    }

    // Métodos Abstractos
    public abstract  boolean estaDisponible(LocalDate fechaInicio, LocalDate fechaFin, Integer cantPersonas, Integer cantHabitaciones, List<ReservaData<?>> reservas);
    public abstract void getDetalles();

    // Métodos concretos}
    public void agregarHabitacion (Habitacion habitacion){
        habitaciones.add(habitacion);
    }

    public boolean cumpleCapacidad(Integer cantPersonas) {
        return cantPersonas <= this.maxPersonas;
    }

    public boolean noHayConflictoDeFechas(LocalDate fechaInicio, LocalDate fechaFin, List<ReservaData<?>> reservas) {
        return reservas.stream().allMatch(reserva ->
                fechaFin.isBefore(reserva.getFechaInicio()) || fechaInicio.isAfter(reserva.getFechaFin())
        );
    }

    //Getters y Setters
    public void getDetallesBasicos(){
        System.out.println(this.nombre);
        System.out.println("Calificación: " + this.calificacion);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Float calificacion) {
        this.calificacion = calificacion;
    }

    public Integer getMaxPersonas() {
        return maxPersonas;
    }

    public void setMaxPersonas(Integer maxPersonas) {
        this.maxPersonas = maxPersonas;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(List<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }
}
