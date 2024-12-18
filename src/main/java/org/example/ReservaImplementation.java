package org.example;

import java.time.LocalDate;

public class ReservaImplementation implements IReserva {
 private  ReservaData reservaData;

    public ReservaImplementation(ReservaData reservaData) {
        this.reservaData = reservaData;
    }


    @Override
    public boolean reservar(Cliente cliente, Alojamientos alojamientos, Habitacion habitacion, LocalDate fechaIngreso, LocalDate fechaSalida) {

        if (fechaIngreso == null || fechaSalida == null || fechaIngreso.isAfter(fechaSalida)) {
            System.out.println("Las fechas de ingreso y salida son inválidas.");
            return false;
        }
        if (!habitacion.estaDisponible(fechaIngreso, fechaSalida)) {
            System.out.println("La habitación no está disponible en las fechas seleccionadas.");
            return false;
        }
        ReservaData reserva = new ReservaData(cliente, fechaIngreso, fechaSalida, habitacion, alojamientos);
        System.out.println("Reserva realizada con éxito para el cliente: " + cliente.getNombre());
        habitacion.agregarReserva(reserva);

        return true;
    }

    @Override
    public boolean cancelarReserva(int idReserva) {
        return false;
    }

    @Override
    public boolean actualizarReserva(int idReserva, String nuevosDetalles) {
       return false;
    }

}
