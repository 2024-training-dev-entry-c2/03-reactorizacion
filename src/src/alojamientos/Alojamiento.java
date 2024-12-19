package alojamientos;

import habitaciones.Habitacion;

import java.util.ArrayList;

public abstract class Alojamiento {

    protected String nombre;
    protected String ciudad;
    protected Double calificacion;
    protected String descripcion;
    protected ArrayList <Habitacion> habitaciones;



//    public abstract Double calcularPrecioBase(int cantHabitaciones);
    public abstract void mostrarInformacion(int numHabitaciones,int diaInicio,int diaFinalizacion);
    public abstract Boolean estaDisponible(); //para verificar si está disponible por las fechas y la habitacion, para apartamento

    public void mostrarDetallesHabitaciones(){
        System.out.println("====HABITACIONES====");
        for (int i = 0; i < habitaciones.size(); i++) {
            habitaciones.get(i).mostrarDetalles();
        }
    }

    public Double calcularPrecioBase(int cantHabitaciones) {
        Double precioBase = obtenerPrecioMenorDeHabitacion() * cantHabitaciones;
        return  precioBase;
    }

    public Double calcularAjustePrecio(double precioBase,int diaInicio,int diaFinalizacion){
        Double precioAjustado=0.0;
        if (diaInicio >= 26 && diaFinalizacion <= 31) {
            precioAjustado = (precioBase * 0.15)+precioBase;
        } else if (diaInicio >= 10 && diaFinalizacion <= 15) {
            precioAjustado = precioBase * 0.10+precioBase;
        } else if (diaInicio >= 5 && diaFinalizacion <= 10) {
            precioAjustado = precioBase * 0.08-precioBase;
        } else {
           return precioAjustado;
        }
        return precioAjustado;
    }


    public Double obtenerPrecioMenorDeHabitacion(){
        double precioMinimo = Double.MAX_VALUE;
        for (int i = 0; i < habitaciones.size(); i++) {
            if(habitaciones.get(i).getPrecioPorNoche() < precioMinimo)
                precioMinimo = habitaciones.get(i).getPrecioPorNoche();
        }
        return precioMinimo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }


}
