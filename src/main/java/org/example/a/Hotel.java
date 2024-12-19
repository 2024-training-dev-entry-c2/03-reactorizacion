package org.example.a;

import java.util.LinkedList;

public class Hotel extends Alojamiento {
    private LinkedList<Habitacion> listaHabitaciones;

    public Hotel(String nombre, String ciudad, float calificacion, LinkedList<Habitacion> listaHabitaciones) {
        super(nombre, ciudad, calificacion);
        this.listaHabitaciones = listaHabitaciones;
    }

    public LinkedList<Habitacion> verificarCantidadDeHabitaciones(int cantidadPersonas) {
        System.out.println("Length habitaciones " + listaHabitaciones.size());
        LinkedList<Habitacion> newListaHabitaciones = new LinkedList<>();

        for (Habitacion unaHabiatacion : newListaHabitaciones) {
            if (unaHabiatacion.getCantidad() < cantidadPersonas) {
                newListaHabitaciones.remove(unaHabiatacion);
            }
        }
        return newListaHabitaciones;
    }

    public float calcularPrecioMasBajo(int diaInicio, int diaFinal) {
        int habitacionMasBaja = 0;
        for (Habitacion unaHabitacion : listaHabitaciones) {
            if (habitacionMasBaja == 0) {
                habitacionMasBaja = unaHabitacion.getPrecio();
                continue;
            }
            if (habitacionMasBaja > unaHabitacion.getPrecio()) {
                habitacionMasBaja = unaHabitacion.getPrecio();
            }
        }
        return habitacionMasBaja == 0 ? 0 : habitacionMasBaja;
    }

    public LinkedList<Habitacion> habitacionesDisponibles(String nombreHotel, int diaInicioHospedaje, int diaFinalHospedaje, int cantAdultos, int cantNinios, int cantHabitacionesCliente) {
        if (!nombreHotel.equalsIgnoreCase(this.getNombre())) return new LinkedList<>();

        System.out.println("------------------------------------------");
        return buscarYMostrarHabitacionesDisponibles(diaInicioHospedaje, diaFinalHospedaje, cantAdultos, cantNinios, cantHabitacionesCliente);
    }

    private LinkedList<Habitacion> buscarYMostrarHabitacionesDisponibles(int diaInicioHospedaje, int diaFinalHospedaje, int cantAdultos, int cantNinios, int cantHabitacionesCliente) {
        LinkedList<Habitacion> habitacionsDisponibles = new LinkedList<>();
        for (int i = 0; i < listaHabitaciones.size(); i++) {
            if (listaHabitaciones.get(i).getCantidad() < cantHabitacionesCliente) continue;
            System.out.println("Id: " + i);
            listaHabitaciones.get(i).mostrarDatos();
            System.out.println("Precio total por su estadia: " + calcularPrecio(listaHabitaciones.get(i).getPrecio(), cantAdultos + cantNinios, diaInicioHospedaje, diaFinalHospedaje));
            System.out.println("------------------------------------------");
            habitacionsDisponibles.add(listaHabitaciones.get(i));
        }
        return habitacionsDisponibles;
    }

    public float calcularPrecio(float precio, int cantidadPersonas, int diaInicio, int diaFinal) {
        double precioFinal = precio;

        if ((diaInicio <= 10 && diaFinal >= 5)) {
            precioFinal = precio - (precio * 0.08);
        }

        if ((diaInicio <= 15 && diaFinal >= 10)) {
            precioFinal = precio + (precio * 0.10);
        }

        if ((diaInicio <= 31 && diaFinal >= 26)) {
            precioFinal = precio + (precio * 0.15);
        }

        return (float) precioFinal * cantidadPersonas;
    }

    @Override
    public void verAlojamiento() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Ciudad: " + getCiudad());
        System.out.println("Calificacion: " + getCalificacion());
    }

    // Getters and setters

    public void setListaHabitaciones(LinkedList<Habitacion> listaHabitaciones) {
        this.listaHabitaciones = listaHabitaciones;
    }
}
