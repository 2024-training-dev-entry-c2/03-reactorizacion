package alojamientos;

import habitaciones.Habitacion;

import java.util.ArrayList;

public abstract class Alojamiento {

    protected String nombre;
    protected String ciudad;
    protected Double calificacion;
    protected String descripcion;
    protected Integer maximoAdultos;
    protected Integer maximoNinos;
    protected ArrayList <Habitacion> habitaciones;


    public abstract Double calcularPrecioBase();
    public abstract void mostrarInformacion();
    public abstract Boolean estaDisponible(); //para verificar si está disponible por las fechas y la habitacion, para apartamento

    public void mostrarDetallesHabitaciones(){}
    public Double calcularPrecioTotal(){
        return 0.0;
    }
    public Double calcularAjustePrecio(){
        return 0.0;
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

    public Integer getMaximoAdultos() {
        return maximoAdultos;
    }

    public void setMaximoAdultos(Integer maximoAdultos) {
        this.maximoAdultos = maximoAdultos;
    }

    public Integer getMaximoNinos() {
        return maximoNinos;
    }

    public void setMaximoNinos(Integer maximoNinos) {
        this.maximoNinos = maximoNinos;
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public static interface IDiaDeSol {
    }
}
