package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservaVisualizacion {

    private final List<ReservaData> reservas = new ArrayList<>();

    public ReservaData crearReserva(String nombre, String apellido, String nacionalidad, String email, LocalDate fechaNacimiento, Alojamientos alojamiento, Habitacion habitacion, float telefono) {
        Cliente cliente = new Cliente(nombre,apellido,nacionalidad,telefono,email,fechaNacimiento);
        ReservaData reservacion= new ReservaData(cliente,fechaNacimiento,fechaNacimiento,habitacion,alojamiento);
        ReservaImplementation reservaImplementation = new ReservaImplementation(reservacion);
        reservas.add(reservacion);
        return reservacion;
    }

    public ReservaData autenticarReserva(String email, LocalDate fechaNacimiento) {

        return null;
    }
    public void cancelarReserva() {
    }

}
