package modelos;

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

    // getters and setters
    public Integer getNumeroPiso() {
        return numeroPiso;
    }

    public void setNumeroPiso(Integer numeroPiso) {
        this.numeroPiso = numeroPiso;
    }

    public String getNumeroApartamento() {
        return numeroApartamento;
    }

    public void setNumeroApartamento(String numeroApartamento) {
        this.numeroApartamento = numeroApartamento;
    }
}
