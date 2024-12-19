package modelos;

public class Habitacion {

    private String tiposDeHabitaciones;
    private String caracteristicasHabitaciones;
    private Double precioPorNochePorTipoHabitacion;
    private Integer habitacionesDisponibles;

    public Habitacion(String tiposDeHabitaciones, String caracteristicasHabitaciones, Double precioPorNochePorTipoHabitacion, Integer habitacionesDisponibles) {
        this.tiposDeHabitaciones = tiposDeHabitaciones;
        this.caracteristicasHabitaciones = caracteristicasHabitaciones;
        this.precioPorNochePorTipoHabitacion = precioPorNochePorTipoHabitacion;
        this.habitacionesDisponibles = habitacionesDisponibles;
    }

    public Habitacion() {
    }

    public void mostrarHabitacionesDisponibles() {
        System.out.println("Tipo de habitacion: " + tiposDeHabitaciones + "\nCaracterísticas: " + caracteristicasHabitaciones +
                "\nPrecio por noche: " + precioPorNochePorTipoHabitacion + "\nNumero de habitaciones disponibles: " + habitacionesDisponibles + "\n***********************************");
    }

    // getters and setters
    public String getTiposDeHabitaciones() {
        return tiposDeHabitaciones;
    }

    public void setTiposDeHabitaciones(String tiposDeHabitaciones) {
        this.tiposDeHabitaciones = tiposDeHabitaciones;
    }

    public String getCaracteristicasHabitaciones() {
        return caracteristicasHabitaciones;
    }

    public void setCaracteristicasHabitaciones(String caracteristicasHabitaciones) {
        this.caracteristicasHabitaciones = caracteristicasHabitaciones;
    }

    public Double getPrecioPorNochePorTipoHabitacion() {
        return precioPorNochePorTipoHabitacion;
    }

    public void setPrecioPorNochePorTipoHabitacion(Double precioPorNochePorTipoHabitacion) {
        this.precioPorNochePorTipoHabitacion = precioPorNochePorTipoHabitacion;
    }

    public Integer getHabitacionesDisponibles() {
        return habitacionesDisponibles;
    }

    public void setHabitacionesDisponibles(Integer habitacionesDisponibles) {
        this.habitacionesDisponibles = habitacionesDisponibles;
    }
}
