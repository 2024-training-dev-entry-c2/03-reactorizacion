package modelos;

import java.time.LocalDate;
import java.util.ArrayList;

public class Apartamento extends Alojamiento{

    private Integer numeroPiso;
    private String numeroApartamento;

    public Apartamento(String nombreAlojamiento, String ciudadDestino, Integer maxAdultos, Integer maxNinos, Double calificacion, ArrayList<Habitacion> habitacion, Integer numeroPiso, String numeroApartamento) {
        super(nombreAlojamiento, ciudadDestino, maxAdultos, maxNinos, calificacion, habitacion);
        this.numeroPiso = numeroPiso;
        this.numeroApartamento = numeroApartamento;
    }

    public Apartamento() {
    }

    @Override
    public void mostrarInfo(LocalDate inicioEstadia, LocalDate finEstadia, int habitacionesSolicitadas, int adultos, int ninos) {
        System.out.println("Nombre: " + getNombreAlojamiento() +
                "\nciudad: " + getCiudadDestino() +
                "\nCalificación: " + getCalificacion() +
                "\nNumero de piso: " + getNumeroPiso() +
                "\nNumero de apartamento: " + getNumeroApartamento()
        );
        double precioTotal = calcularPrecioTotal(inicioEstadia, finEstadia, habitacionesSolicitadas);
        System.out.println("El precio base total de la estadía es: $" + precioTotal);
    }

    //sobrecarga
    public void mostrarInfo(LocalDate inicioEstadia, LocalDate finEstadia) {
        System.out.println("Nombre: " + getNombreAlojamiento() +
                "\nciudad: " + getCiudadDestino()
        );
        System.out.println("Fecha de inicio de estadia: " + inicioEstadia);
        System.out.println("Fecha de fin de estadia: " + finEstadia);
    }

    @Override
    public void mostrarHabitacionesDisponibles() {
        super.mostrarHabitacionesDisponibles();
    }

    // getters and setters
    public Integer getNumeroPiso() {
        return numeroPiso;
    }

    public String getNumeroApartamento() {
        return numeroApartamento;
    }

}
