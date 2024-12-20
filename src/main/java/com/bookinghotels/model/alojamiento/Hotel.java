package com.bookinghotels.model.alojamiento;


import com.bookinghotels.model.data.ReservaData;

import java.time.LocalDate;
import java.util.List;

public class Hotel extends Alojamiento{
    private DiaDeSol diaDeSol;
    private Boolean servicioHabitaicon;

    // Constructor
    public Hotel(String nombre, String ciudad, String categoria, Float calificacion, Integer maxPersonas, DiaDeSol diaDeSol, Boolean servicioHabitaicon) {
        super(nombre, ciudad, categoria, calificacion, maxPersonas);
        this.diaDeSol = diaDeSol;
        this.servicioHabitaicon = servicioHabitaicon;
    }

    // Métodos
    @Override
    public boolean estaDisponible(LocalDate fechaInicio, LocalDate fechaFin, Integer cantPersonas, Integer cantHabitaciones, List<ReservaData<?>> reservas) {
        return false;
    }

    @Override
    public void getDetalles() {
        getDetallesBasicos();
        String servicio = this.servicioHabitaicon == true ? "Incluido" : "No tiene";
        System.out.println("Servicio a la habitación: " + servicio);
    }

    // Getter y Setters
    public DiaDeSol getDiaDeSol() {
        return diaDeSol;
    }

    public void setDiaDeSol(DiaDeSol diaDeSol) {
        this.diaDeSol = diaDeSol;
    }

    public Boolean getServicioHabitaicon() {
        return servicioHabitaicon;
    }

    public void setServicioHabitaicon(Boolean servicioHabitaicon) {
        this.servicioHabitaicon = servicioHabitaicon;
    }
}
