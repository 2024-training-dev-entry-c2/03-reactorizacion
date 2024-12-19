package alojamientos;

import habitaciones.Habitacion;

import java.util.ArrayList;

public class Hotel extends Alojamiento implements IDiaDeSol{

    private DiaDeSolData diaDeSol;
    private Boolean servicioHabitacion;

    public Hotel(String nombre, String ciudad, Double calificacion, String descripcion, ArrayList<Habitacion> habitaciones,DiaDeSolData diaDeSol, Boolean servicioHabitacion) {
        this.nombre=nombre;
        this.ciudad=ciudad;
        this.calificacion=calificacion;
        this.descripcion=descripcion;
        this.habitaciones=habitaciones;
        this.diaDeSol = diaDeSol;
        this.servicioHabitacion = servicioHabitacion;
    }

    public Hotel(String nombre, String ciudad, Double calificacion, String descripcion, ArrayList<Habitacion> habitaciones) {
        this.nombre=nombre;
        this.ciudad=ciudad;
        this.calificacion=calificacion;
        this.descripcion=descripcion;
        this.habitaciones=habitaciones;
    }

    @Override
    public Double calcularPrecioBase() {
        return 0.0;
    }

    @Override
    public void mostrarInformacion() {

    }

    @Override
    public Boolean estaDisponible() {
        return true;
    }

    @Override
    public Boolean tieneDiaDeSol() {
        if(diaDeSol!=null){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void mostrarInfoDiaDeSol() {
        System.out.println("***********");
        if(tieneDiaDeSol()){
            System.out.println("--Info dia de sol--");
            System.out.println("Actividades: "+diaDeSol.getActividades());
            System.out.println("Incluye: "+ diaDeSol.getExtras());
            System.out.println("precio por servicio de dia de sol"+ diaDeSol.getPrecio());
        }
    }

    @Override
    public double calcularPrecioBaseDiaSol() {
        return 0;
    }

    public DiaDeSolData getDiaDeSol() {
        return diaDeSol;
    }

    public void setDiaDeSol(DiaDeSolData diaDeSol) {
        this.diaDeSol = diaDeSol;
    }

    public Boolean getServicioHabitacion() {
        return servicioHabitacion;
    }

    public void setServicioHabitacion(Boolean servicioHabitacion) {
        this.servicioHabitacion = servicioHabitacion;
    }
}
