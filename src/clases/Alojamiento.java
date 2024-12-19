package clases;
import java.util.List;

public abstract class Alojamiento {
    String ciudad;
    String tipoAlojamiento;
    List<Habitacion> habitaciones;
    Double calificacion;
    String nombre;
    Double precioBase;

    public Alojamiento(){};

    public Alojamiento(String ciudad, String tipoAlojamiento, String nombre, Double precioBase, Double calificacion, List<Habitacion> habitaciones) {
        this.ciudad = ciudad;
        this.tipoAlojamiento = tipoAlojamiento;
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.calificacion = calificacion;
        this.habitaciones = habitaciones;
    }

    public abstract String mostrarInformacion();

    void actualizarReservas() {
        System.out.println("Reservas actualizadas para " + nombre);
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getTipoAlojamiento() {
        return tipoAlojamiento;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecioBase() {
        return precioBase;
    }

}