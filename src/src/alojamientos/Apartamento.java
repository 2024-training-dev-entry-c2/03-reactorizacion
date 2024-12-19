package alojamientos;

import habitaciones.Habitacion;

import java.util.ArrayList;

public class Apartamento extends Alojamiento implements IDiaDeSol{

    private Integer piso;
    private String numeroApartamento;

    public Apartamento(String nombre, String ciudad, Double calificacion, String descripcion, ArrayList<Habitacion> habitaciones,Integer piso, String numeroApartamento) {
        this.nombre=nombre;
        this.ciudad=ciudad;
        this.calificacion=calificacion;
        this.descripcion=descripcion;
        this.habitaciones=habitaciones;
        this.piso = piso;
        this.numeroApartamento = numeroApartamento;
    }


    @Override
    public Double calcularPrecioBase() {
        return 0.0;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Alojamiento: " + this.nombre);
        System.out.println("Calificación: " + this.calificacion);
        System.out.println("Piso: "+ this.piso);
        System.out.println("numeroApartamento: "+ this.numeroApartamento);
        //System.out.println("precio: " + calcularPrecioBase(numHabitaciones));
        //System.out.println("Precio Total: " + calcularDescuentoOAumento(diaInicio,diaFinalizacion));
        System.out.println("-------------------");
    }

    @Override
    public Boolean estaDisponible() {
        return true;
    }

    @Override
    public Boolean tieneDiaDeSol() {
        return true;
    }

    @Override
    public void mostrarInfoDiaDeSol() {

    }

    @Override
    public double calcularPrecioBaseDiaSol() {
        return 0;
    }

    public Integer getPiso() {
        return piso;
    }

    public void setPiso(Integer piso) {
        this.piso = piso;
    }

    public String getNumeroApartamento() {
        return numeroApartamento;
    }

    public void setNumeroApartamento(String numeroApartamento) {
        this.numeroApartamento = numeroApartamento;
    }
}
