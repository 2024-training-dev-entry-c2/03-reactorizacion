package modelos;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Alojamiento {

    protected String nombreAlojamiento;
    protected String ciudadDestino;
    protected Integer maxAdultos;
    protected Integer maxNinos;
    protected Double calificacion;
    protected ArrayList<Habitacion> habitacion;

    public Alojamiento(String nombreAlojamiento, String ciudadDestino, Integer maxAdultos, Integer maxNinos, Double calificacion, ArrayList<Habitacion> habitacion) {
        this.nombreAlojamiento = nombreAlojamiento;
        this.ciudadDestino = ciudadDestino;
        this.maxAdultos = maxAdultos;
        this.calificacion = calificacion;
        this.maxNinos = maxNinos;
        this.habitacion = habitacion;
    }

    public Alojamiento() {
    }

    public abstract void mostrarInfo(LocalDate inicioEstadia, LocalDate finEstadia, int habitacionesSolicitadas, int adultos, int ninos);

    public abstract void mostrarInfo(LocalDate inicioEstadia, LocalDate finEstadia);

    public void mostrarHabitacionesDisponibles() {
        for (Habitacion habitacion : habitacion) {
            habitacion.mostrarHabitacionesDisponibles();
        }
    }

    public double calcularPrecioTotal(LocalDate inicioEstadia, LocalDate finEstadia, int habitacionesSolicitadas) {
        long diferenciaEnDias = finEstadia.toEpochDay() - inicioEstadia.toEpochDay();

        if (diferenciaEnDias <= 0) {
            System.out.println("Debe alojarse como mínimo un día");
            return 0.0;
        }

        double precioBase = habitacion.get(0).getPrecioPorNochePorTipoHabitacion();
        double totalPrecioBase = precioBase * habitacionesSolicitadas * diferenciaEnDias;

        double incrementoPrecio = 0.0;
        double descuentoPrecio = 0.0;

        if (ultimosCincoDiasDelMes(inicioEstadia, finEstadia)) {
            incrementoPrecio = totalPrecioBase * 0.15;
            totalPrecioBase += incrementoPrecio;
        }

        if (diasEntreElDiezYQuince(inicioEstadia, finEstadia)) {
            incrementoPrecio = totalPrecioBase * 0.10;
            totalPrecioBase += incrementoPrecio;
        }

        if (diasEntreElCincoYDiez(inicioEstadia, finEstadia)) {
            descuentoPrecio = totalPrecioBase * 0.08;
            totalPrecioBase -= descuentoPrecio;
        }

        return totalPrecioBase;
    }

    private static boolean ultimosCincoDiasDelMes(LocalDate inicioEstadia, LocalDate finEstadia) {

        // obteniendo el ultimo dia del mes para la fecha de fin estadia
        int lastDayOfMonth = finEstadia.lengthOfMonth();

        // verificando si los ultimos 5 dias del mes estan dentro del rango de fechas
        return (finEstadia.getDayOfMonth() >= lastDayOfMonth - 4 || inicioEstadia.getDayOfMonth() >= lastDayOfMonth - 4 );
    }

    private static boolean diasEntreElDiezYQuince(LocalDate inicioEstadia, LocalDate finEstadia) {

        // verificando si alguna de las fechas cae entre el 10 y el 15 del mes
        return ((inicioEstadia.getDayOfMonth() <= 15 && inicioEstadia.getDayOfMonth() >= 10) ||
                (finEstadia.getDayOfMonth() <= 15 && finEstadia.getDayOfMonth() >= 10));
    }

    private static boolean diasEntreElCincoYDiez(LocalDate inicioEstadia, LocalDate finEstadia) {

        // verificando si alguna de las fechas cae entre el 5 y el 10 del mes
        return ((inicioEstadia.getDayOfMonth() <= 10 && inicioEstadia.getDayOfMonth() >= 5) ||
                (finEstadia.getDayOfMonth() <= 10 && finEstadia.getDayOfMonth() >= 5));
    }

    // getters and setters
    public String getNombreAlojamiento() {
        return nombreAlojamiento;
    }

    public void setNombreAlojamiento(String nombreAlojamiento) {
        this.nombreAlojamiento = nombreAlojamiento;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public Integer getMaxNinos() {
        return maxNinos;
    }

    public void setMaxNinos(Integer maxNinos) {
        this.maxNinos = maxNinos;
    }

    public Integer getMaxAdultos() {
        return maxAdultos;
    }

    public void setMaxAdultos(Integer maxAdultos) {
        this.maxAdultos = maxAdultos;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public ArrayList<Habitacion> getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(ArrayList<Habitacion> habitacion) {
        this.habitacion = habitacion;
    }
}
