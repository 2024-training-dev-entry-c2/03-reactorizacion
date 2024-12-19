package org.example;

import java.time.LocalDate;

public class DatosConsulta {

    private final LocalDate fechaInicio;
    private final LocalDate fechaFin;
    private final Integer cantidadAdultos;
    private final Integer cantidadNinos;
    private final Integer cantidadHabitaciones;


    public DatosConsulta(LocalDate fechaInicio, LocalDate fechaFin, Integer cantidadAdultos, Integer cantidadNinos, Integer cantidadHabitaciones) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cantidadAdultos = cantidadAdultos;
        this.cantidadNinos = cantidadNinos;
        this.cantidadHabitaciones = cantidadHabitaciones;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public Integer getCantidadAdultos() {
        return cantidadAdultos;
    }

    public Integer getCantidadNinos() {
        return cantidadNinos;
    }

    public Integer getCantidadHabitaciones() {
        return cantidadHabitaciones;
    }
}
