package com.bookinghotels.service;

import com.bookinghotels.model.alojamiento.Alojamiento;

import java.util.List;

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

    public Alojamiento buscarPorNombre(String nombre) {
        return alojamientos.stream()
                .filter(a -> a.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    public Alojamiento buscarPorCategoria(String categoria) {
        return alojamientos.stream()
                .filter(a -> a.getCategoria().equalsIgnoreCase(categoria))
                .findFirst()
                .orElse(null);
    }
}
