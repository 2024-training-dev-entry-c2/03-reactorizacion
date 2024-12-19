package alojamientos;

import habitaciones.Habitacion;

import java.util.ArrayList;

public class Finca extends Alojamiento implements IDiaDeSol{

    private DiaDeSolData diaDeSol;

    public Finca(DiaDeSolData diaDeSol) {
        this.diaDeSol = diaDeSol;
    }

    public Finca(String nombre, String ciudad, Double calificacion, String descripcion, ArrayList<Habitacion> habitaciones) {
        this.nombre=nombre;
        this.ciudad=ciudad;
        this.calificacion=calificacion;
        this.descripcion=descripcion;
        this.habitaciones=habitaciones;
    }


    @Override
    public void mostrarInformacion(int numHabitaciones, int diaInicio, int diaFinalizacion) {
        System.out.println("Alojamiento: " + this.nombre);
        System.out.println("Calificación: " + this.calificacion);
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

}
