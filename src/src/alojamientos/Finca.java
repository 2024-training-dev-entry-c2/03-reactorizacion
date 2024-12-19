package alojamientos;

import habitaciones.Habitacion;

import java.util.ArrayList;

public class Finca extends Alojamiento implements IDiaDeSol{

    private DiaDeSolData diaDeSol;


    public Finca(String nombre, String ciudad, Double calificacion, String descripcion,DiaDeSolData diaDeSol) {
        this.nombre=nombre;
        this.ciudad=ciudad;
        this.calificacion=calificacion;
        this.descripcion=descripcion;
        habitaciones=new ArrayList<Habitacion>();
        this.diaDeSol = diaDeSol;
        this.tipo="finca";
    }

    public Finca(String nombre, String ciudad, Double calificacion, String descripcion) {
        this.nombre=nombre;
        this.ciudad=ciudad;
        this.calificacion=calificacion;
        this.descripcion=descripcion;
        habitaciones=new ArrayList<Habitacion>();
        this.tipo="finca";
    }

    public Finca() {
    }

    @Override
    public void mostrarInformacion(int numHabitaciones, int diaInicio, int diaFinalizacion) {
        System.out.println("Alojamiento: " + this.nombre);
        System.out.println("Calificación: " + this.calificacion);
        System.out.println("precio: " + calcularPrecioBase(numHabitaciones));
        System.out.println("precioBase: " + calcularAjustePrecio(calcularPrecioBase(numHabitaciones),diaInicio,diaFinalizacion));
        if(tieneDiaDeSol()){
            this.mostrarInfoDiaDeSol();
        }
        System.out.println("-------------------");
    }


    @Override
    public Boolean tieneDiaDeSol() {
        return diaDeSol != null;
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

}
