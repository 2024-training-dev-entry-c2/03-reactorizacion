package alojamientos;

import habitaciones.Habitacion;

import java.util.ArrayList;

public abstract class Alojamiento {

    protected String nombre;
    protected String ciudad;
    protected Double calificacion;
    protected String descripcion;
    protected ArrayList <Habitacion> habitaciones;
    protected String tipo;



    public abstract void mostrarInformacion(int numHabitaciones,int diaInicio,int diaFinalizacion);


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

    public String getCiudad() {
        return ciudad;
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public String getTipo() {
        return tipo;
    }
}
