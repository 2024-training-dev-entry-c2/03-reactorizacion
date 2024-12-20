package com.bookinghotels.model.alojamiento;


import com.bookinghotels.model.data.ReservaData;

import java.time.LocalDate;
import java.util.List;

public class Finca extends Alojamiento{
    private DiaDeSol diaDeSol;
    private Float precioPorNoche;

    //Constructor
    public Finca(String nombre, String ciudad, String categoria, Float calificacion, Integer maxPersonas, DiaDeSol diaDeSol, Float precioPorNoche) {
        super(nombre, ciudad, categoria, calificacion, maxPersonas);
        this.diaDeSol = diaDeSol;
        this.precioPorNoche = precioPorNoche;
    }

    @Override
    public boolean estaDisponible(LocalDate fechaInicio, LocalDate fechaFin, Integer cantPersonas, Integer cantHabitaciones, List<ReservaData<?>> reservas) {
        return cumpleCapacidad(cantPersonas) && noHayConflictoDeFechas(fechaInicio, fechaFin, reservas);
    }

    @Override
    public void getDetalles() {
        getDetallesBasicos();
        System.out.println("Precio por noche: $" + precioPorNoche);
    }

    // Getters y Setters

    public DiaDeSol getDiaDeSol() {
        return diaDeSol;
    }

    public void setDiaDeSol(DiaDeSol diaDeSol) {
        this.diaDeSol = diaDeSol;
    }

    public Float getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(Float precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }
}
