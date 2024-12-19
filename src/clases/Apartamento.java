package clases;
import java.util.List;

public class Apartamento extends Alojamiento {

    public Apartamento() {}

    public Apartamento(String ciudad, String nombre, Double precioBase, Double calificacion, List<Habitacion> habitaciones) {
        super(ciudad,"Apartamento",nombre,precioBase, calificacion, habitaciones);
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
