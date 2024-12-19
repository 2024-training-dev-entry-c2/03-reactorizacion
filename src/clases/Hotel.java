package clases;
import java.util.List;

public class Hotel extends Alojamiento {

    public Hotel(String ciudad, String nombre, Double precioBase, Double calificacion, List<Habitacion> habitaciones) {
        super(ciudad, "Hotel", nombre, precioBase, calificacion, habitaciones);
    }


    double calcularPrecioTotal() {

        return getPrecioBase() * 1.2;
    }

    public String mostrarInformacion() {
        return "Hotel: " + getNombre() +
                " en " + getCiudad() +
                " Tipo: " + getTipoAlojamiento() +
                " Precio base: " + getPrecioBase() +
                " Calificación: " + getCalificacion() +
                "\nHabitaciones: " + getHabitaciones();
    }

}
