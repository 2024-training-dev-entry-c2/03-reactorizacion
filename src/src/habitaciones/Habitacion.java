package habitaciones;

public class Habitacion {

    String tipo;
    String descripcion;
    Double precioPorNoche;
    Integer HabitacionesDisponibles;
    Integer capacidad;


    public Habitacion(String tipo, String descripcion, Integer capacidad, Integer habitacionesDisponibles, Double precioPorNoche) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.capacidad = capacidad;
        HabitacionesDisponibles = habitacionesDisponibles;
        this.precioPorNoche = precioPorNoche;
    }

    public Habitacion() {
    }

    public void mostrarDetalles(){
        System.out.println("=== Habitación " + this.tipo + " ===");
        System.out.println("Características: " + this.descripcion);
        System.out.println("capacidad: " + this.capacidad+"personas");
        System.out.println("Precio: $" + this.precioPorNoche);
        System.out.println("--------------------------------");
    }


    public String getTipo() {
        return tipo;
    }

    public Double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public Integer getHabitacionesDisponibles() {
        return HabitacionesDisponibles;
    }

}
