package alojamientos;

import habitaciones.Habitacion;

import java.util.ArrayList;

public class Hotel extends Alojamiento implements IDiaDeSol{

    private DiaDeSolData diaDeSol;
    private Boolean servicioHabitacion;

    public Hotel(String nombre, String ciudad, Double calificacion, String descripcion ,DiaDeSolData diaDeSol, Boolean servicioHabitacion) {
        this.nombre=nombre;
        this.ciudad=ciudad;
        this.calificacion=calificacion;
        this.descripcion=descripcion;
        this.diaDeSol = diaDeSol;
        this.servicioHabitacion = servicioHabitacion;
        habitaciones=new ArrayList<Habitacion>();
    }

    public Hotel(String nombre, String ciudad, Double calificacion, String descripcion) {
        this.nombre=nombre;
        this.ciudad=ciudad;
        this.calificacion=calificacion;
        this.descripcion=descripcion;
        habitaciones=new ArrayList<Habitacion>();
    }


    @Override
    public void mostrarInformacion(int numHabitaciones,int diaInicio,int diaFinalizacion) {
        System.out.println("Alojamiento: " + this.nombre);
        System.out.println("Calificación: " + this.calificacion);
        if(getServicioHabitacion()){
            System.out.println("Cuenta con servicio a la habitacion");
        }
        System.out.println("precio: " + calcularPrecioBase(numHabitaciones));
        System.out.println("+precioBase" + calcularAjustePrecio(calcularPrecioBase(numHabitaciones),diaInicio,diaFinalizacion));
        if(tieneDiaDeSol()){
            this.mostrarInfoDiaDeSol();
        }
        System.out.println("-------------------");
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
