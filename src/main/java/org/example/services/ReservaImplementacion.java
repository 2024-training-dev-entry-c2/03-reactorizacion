package org.example.services;

import org.example.interfaces.IReserva;
import org.example.models.Alojamiento;
import org.example.models.Cliente;
import org.example.models.Habitacion;

import java.time.LocalDate;
import java.util.Optional;

public class ReservaImplementacion implements IReserva {

    private Cliente cliente;
    private Alojamiento alojamiento;
    private Habitacion habitacion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public ReservaImplementacion() {
    }

    public ReservaImplementacion(Cliente cliente, Alojamiento alojamiento, Habitacion habitacion, LocalDate fechaInicio, LocalDate fechaFin) {
        this.cliente = cliente;
        this.alojamiento = alojamiento;
        this.habitacion = habitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    @Override
    public void crearReserva(Cliente cliente, Alojamiento alojamiento, String tipoHabitacion, LocalDate fechaInicio, LocalDate fechaFin) {
        Optional<Habitacion> habitacionDisponible = alojamiento.getHabitaciones()
                .stream().filter(h -> h.getTipo().equalsIgnoreCase(tipoHabitacion) && h.isDisponible()).findFirst();

        if(habitacionDisponible.isEmpty()){
            throw new IllegalArgumentException("No hay habitaciones disponibles del tipo específicado.");
        }

        this.cliente = cliente;
        this.alojamiento = alojamiento;
        this.habitacion = habitacionDisponible.get();
        this.habitacion.setDisponible(false);
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;

        System.out.println("Reserva creada con éxito para " + cliente.getNombreCompleto());
    }

    @Override
    public void actualizarReserva(Cliente cliente, String nuevoTipoHabitacion) {
        if (!this.cliente.getEmail().equalsIgnoreCase(cliente.getEmail())){
            throw new IllegalArgumentException("El cliente no coincide con la reserva.");
        }

        this.habitacion.setDisponible(true);

        Optional<Habitacion> nuevaHabitacion = this.alojamiento.getHabitaciones()
                .stream().filter(h -> h.getTipo().equalsIgnoreCase(nuevoTipoHabitacion) && h.isDisponible()).findFirst();

        if(nuevaHabitacion.isEmpty()){
            throw new IllegalArgumentException("No hay habitaciones disponibles del nuevo tipo.");
        }

        this.habitacion = nuevaHabitacion.get();
        this.habitacion.setDisponible(false);

        System.out.println("Reserva actualizada con éxito para " + cliente.getNombreCompleto());
        mostrarReserva();
    }

    @Override
    public void mostrarReserva() {
        System.out.println("El cliente desea cambiar de alojamiento. La reserva actual será eliminada.");
        this.habitacion.setDisponible(true);
        this.cliente = null;
        this.alojamiento = null;
        this.habitacion = null;
        this.fechaInicio = null;
        this.fechaFin = null;

        System.out.println("La reserva ha sido eliminada. Por favor, cree una nueva reserva.");
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Alojamiento getAlojamiento() {
        return alojamiento;
    }

    public void setAlojamiento(Alojamiento alojamiento) {
        this.alojamiento = alojamiento;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
}
