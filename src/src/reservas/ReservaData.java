package reservas;

import alojamientos.Alojamiento;
import clientes.ClienteData;
import habitaciones.Habitacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class ReservaData <T extends Alojamiento> {
    private T alojamiento;
    private ClienteData cliente;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String horaLLegada;
    private Habitacion habitacion;
    private Integer cantidadHabitaciones;

    public ReservaData(T alojamiento, ClienteData cliente, LocalDate fechaInicio, LocalDate fechaFin, String horaLLegada, Habitacion habitacion,Integer cantidadHabitaciones) {
        this.alojamiento = alojamiento;
        this.cliente = cliente;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.horaLLegada = horaLLegada;
        this.habitacion = habitacion;
        this.cantidadHabitaciones=cantidadHabitaciones;
    }

    public ReservaData() {
    }

    public T getAlojamiento() {
        return alojamiento;
    }

    public ClienteData getCliente() {
        return cliente;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public String getHoraLLegada() {
        return horaLLegada;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public Integer getCantidadHabitaciones() {
        return cantidadHabitaciones;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ReservaData<?> that = (ReservaData<?>) o;
        return Objects.equals(alojamiento, that.alojamiento) && Objects.equals(cliente, that.cliente) && Objects.equals(fechaInicio, that.fechaInicio) && Objects.equals(fechaFin, that.fechaFin) && Objects.equals(horaLLegada, that.horaLLegada) && Objects.equals(habitacion, that.habitacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alojamiento, cliente, fechaInicio, fechaFin, horaLLegada, habitacion);
    }
}
