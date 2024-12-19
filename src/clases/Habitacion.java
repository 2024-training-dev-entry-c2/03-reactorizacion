package clases;
import java.time.LocalDate;

public class Habitacion {
     String descripcion;
     String tipoHabitacion;
     Double precioBase;
     Integer capacidadMayores;
     Integer capacidadMenores;
     LocalDate disponibilidad;

    public Habitacion() {}

    public Habitacion(String descripcion, String tipoHabitacion, Double precioBase, Integer capacidadMayores, Integer capacidadMenores) {
        this.descripcion = descripcion;
        this.tipoHabitacion = tipoHabitacion;
        this.precioBase = precioBase;
        this.capacidadMayores = capacidadMayores;
        this.capacidadMenores = capacidadMenores;
    }

    public String mostrarInformacion() {
        return "Tipo " + getTipoHabitacion() + " descripcion" + getDescripcion();
    }

    @Override
    public String toString() {
        return "Habitación {" +
                "Descripción='" + descripcion + '\'' +
                ", Tipo='" + tipoHabitacion + '\'' +
                ", Precio Base=" + precioBase +
                ", Capacidad Mayores=" + capacidadMayores +
                ", Capacidad Menores=" + capacidadMenores +
                '}';
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public int getCapacidadMayores() {
        return capacidadMayores;
    }



}