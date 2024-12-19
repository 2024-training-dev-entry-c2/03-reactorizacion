package org.example.a;

import java.time.LocalTime;
import java.util.Date;
import java.util.LinkedList;

public class Reserva {
    private Cliente cliente;
    private Float precioTotal;
    private LocalTime horaLlegada;
    private Alojamiento alojamiento;
    private Integer diaInicio;
    private Integer diaFin;

    public Reserva() {
    }
    
    public boolean reservarHabitacionCliente(String nombre, String apellido, String email, String nacionalidad, String telefono, Date fechaNacimiento, LocalTime horaDeLlegada) {
        Cliente clienteSeleccionado = new Cliente(nombre, apellido, nacionalidad, telefono, email, fechaNacimiento);
        this.setCliente(clienteSeleccionado);
        this.setHoraLlegada(horaDeLlegada);
        if (cliente != null && precioTotal != 0 && horaLlegada != null && alojamiento != null && diaInicio != null && diaFin != null) {
            return true;
        }
        return false;
    }

    public void mostrarDetallesReserva() {
        System.out.println("------------------------------------------");
        System.out.println("Cliente: \n");
        getCliente().mostrarDatos();
        System.out.println("------------------------------------------");
        System.out.println("Hora de llegada: " + getHoraLlegada());
        System.out.println("Dia de inicio: " + getDiaInicio());
        System.out.println("Dia de final: " + getDiaFin());
        System.out.println("Precio total: $ " + getPrecioTotal());
        System.out.println("------------------------------------------");
        alojamiento.verAlojamiento();
        System.out.println("------------------------------------------");
    }

    // Getters and setters

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public LocalTime getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(LocalTime horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public Alojamiento getAlojamiento() {
        return alojamiento;
    }

    public void setAlojamiento(Alojamiento alojamiento) {
        this.alojamiento = alojamiento;
    }

    public void setAlojamiento(Habitacion habitacion, Hotel unHotel) {
        LinkedList<Habitacion> habitacionComprada = new LinkedList<>();
        Hotel hotelAlquilado = unHotel;
        habitacionComprada.add(habitacion);
        hotelAlquilado.setListaHabitaciones(habitacionComprada);
        this.alojamiento = unHotel;
    }

    public int getDiaInicio() {
        return diaInicio;
    }

    public void setDiaInicio(int diaInicio) {
        this.diaInicio = diaInicio;
    }

    public int getDiaFin() {
        return diaFin;
    }

    public void setDiaFin(int diaFin) {
        this.diaFin = diaFin;
    }
}
