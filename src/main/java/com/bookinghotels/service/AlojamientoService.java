package com.bookinghotels.service;

import com.bookinghotels.model.alojamiento.Alojamiento;
import com.bookinghotels.model.alojamiento.Habitacion;
import com.bookinghotels.model.data.ReservaData;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class AlojamientoService {
    private List<Alojamiento> alojamientos;

    //Constructor
    public AlojamientoService(List<Alojamiento> alojamientos) {
        this.alojamientos = alojamientos;
    }

    //Métodos
    public List<Alojamiento> obtenerAlojamientos() {
        return alojamientos;
    }

    public List<Alojamiento> buscarAlojamientos(String categoria, String ciudad, LocalDate fechaInicio, LocalDate fechaFin, Integer cantPersonas, List<ReservaData<?>> reservas) {
        return alojamientos.stream()
                .filter(a -> a.getCategoria().equalsIgnoreCase(categoria))
                .filter(a -> a.getCiudad().equalsIgnoreCase(ciudad))
                .filter(a -> a.estaDisponible(fechaInicio, fechaFin, cantPersonas, 1, reservas))
                .collect(Collectors.toList());
    }

    public List<Habitacion> obtenerHabitacionesDisponibles(Alojamiento alojamiento, LocalDate fechaInicio, LocalDate fechaFin, List<ReservaData<?>> reservas) {
        return alojamiento.obtenerHabitacionesDisponibles(fechaInicio, fechaFin, reservas);
    }
}
