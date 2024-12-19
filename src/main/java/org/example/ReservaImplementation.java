package org.example;

import java.time.LocalDate;

public class ReservaImplementation implements IReserva {


    private ReservaData reservaData;

    public ReservaImplementation(ReservaData reservaData) {
        this.reservaData = reservaData;
    }

    public ReservaImplementation() {
    }

    @Override
    public Boolean reservar(Cliente cliente, Alojamientos alojamientos, Habitacion habitacion, LocalDate fechaIngreso, LocalDate fechaSalida, Integer cantidadHabitaciones) {
        if ((fechaIngreso == null || fechaSalida == null || fechaIngreso.isAfter(fechaSalida) || fechaIngreso.isBefore(LocalDate.now()))
                && habitacion.estaDisponible(fechaIngreso, fechaSalida, cantidadHabitaciones)) {
            System.out.println("Las fechas de ingreso y salida son inválidas o están en el pasado.");
            return false;
        }
        if (reservaData == null) {
            reservaData = new ReservaData(cliente, fechaIngreso, fechaSalida, habitacion, alojamientos);
        }
        reservaData.setCliente(cliente);
        reservaData.setFechaIngreso(fechaIngreso);
        reservaData.setFechaSalida(fechaSalida);
        reservaData.setHabitacion(habitacion);
        reservaData.setAlojamiento(alojamientos);
        habitacion.agregarReserva(reservaData, cantidadHabitaciones);

        System.out.println("Reserva realizada con éxito para el cliente: " + cliente.getNombre());

        return true;
    }

    @Override
    public Boolean cancelarReserva(Habitacion habitacion) {
        habitacion.cancelado();
        if (reservaData != null && reservaData.getHabitacion().equals(habitacion)) {
            // Limpiar los datos de la reserva
            reservaData.setCliente(null);
            reservaData.setFechaIngreso(null);
            reservaData.setFechaSalida(null);
            reservaData.setHabitacion(null);
            reservaData.setAlojamiento(null);
            System.out.println("La reserva ha sido cancelada y los datos han sido eliminados.");
            return true;
        } else {
            System.out.println("No se puede cancelar la reserva, la habitación no está asociada.");
            return false;
        }
    }

    @Override
    public Boolean actualizarReserva(Habitacion habitacion) {
        if (habitacion.getTipo().isBlank()) {
            System.out.println("Habitacion no encontrada");
        }

        reservaData.setHabitacion(habitacion);
        habitacion.cancelado();


        return false;
    }

    public ReservaData getReservaData() {
        return reservaData;
    }

    public void setReservaData(ReservaData reservaData) {
        this.reservaData = reservaData;
    }

}
