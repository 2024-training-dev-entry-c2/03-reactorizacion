package alojamientos;

import habitaciones.Habitacion;

import java.util.ArrayList;

public class Apartamento extends Alojamiento{

    private Integer piso;
    private String numeroApartamento;

    public Apartamento(String nombre, String ciudad, Double calificacion, String descripcion,Integer piso, String numeroApartamento) {
        this.nombre=nombre;
        this.ciudad=ciudad;
        this.calificacion=calificacion;
        this.descripcion=descripcion;
        habitaciones=new ArrayList<Habitacion>();
        this.piso = piso;
        this.numeroApartamento = numeroApartamento;
        this.tipo="apartamento";
    }

    public Apartamento() {
    }

    @Override
    public void mostrarInformacion(int numHabitaciones, int diaInicio, int diaFinalizacion) {
        System.out.println("Alojamiento: " + this.nombre);
        System.out.println("Calificación: " + this.calificacion);
        System.out.println("Piso: "+ this.piso);
        System.out.println("numeroApartamento: "+ this.numeroApartamento);
        System.out.println("precio: " + calcularPrecioBase(numHabitaciones));
        System.out.println("precioBase: " + calcularAjustePrecio(calcularPrecioBase(numHabitaciones),diaInicio,diaFinalizacion));
        System.out.println("-------------------");
    }


}
