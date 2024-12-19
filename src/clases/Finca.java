package clases;
import java.util.List;

public class Finca extends Alojamiento {

    public Finca() {}

    public Finca(String ciudad, String nombre, Double precioBase, Double calificacion, List<Habitacion> habitaciones)  {
        super(ciudad,"Finca",nombre,precioBase, calificacion, habitaciones);
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