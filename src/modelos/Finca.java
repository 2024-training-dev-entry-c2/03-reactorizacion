package modelos;

import java.time.LocalDate;
import java.util.ArrayList;

public class Finca extends Alojamiento implements IDiaDeSol{
    private DiaDeSolData diaDeSol;

    public Finca(String nombreAlojamiento, String ciudadDestino, Integer maxAdultos, Integer maxNinos, Double calificacion, ArrayList<Habitacion> habitacion, DiaDeSolData diaDeSol) {
        super(nombreAlojamiento, ciudadDestino, maxAdultos, maxNinos, calificacion, habitacion);
        this.diaDeSol = diaDeSol;
    }

    public Finca() {
    }

    @Override
    public void mostrarInfo(LocalDate inicioEstadia, LocalDate finEstadia, int habitacionesSolicitadas, int adultos, int ninos) {
        System.out.println("Nombre: " + getNombreAlojamiento() +
                "\nciudad: " + getCiudadDestino() +
                "\nCalificación: " + getCalificacion()
        );
        double precioTotal = calcularPrecioTotal(inicioEstadia, finEstadia, habitacionesSolicitadas);
        System.out.println("El precio base total de la estadía es: $" + precioTotal);
    }

    //sobrecarga
    public void mostrarInfo(LocalDate inicioEstadia, LocalDate finEstadia) {
        System.out.println("Nombre: " + getNombreAlojamiento() +
                "\nciudad: " + getCiudadDestino()
        );
        mostrarInfoDiaDeSol();
        System.out.println("Fecha de inicio de estadia: " + inicioEstadia);
        System.out.println("Fecha de fin de estadia: " + finEstadia);
    }

    @Override
    public void mostrarHabitacionesDisponibles() {
        super.mostrarHabitacionesDisponibles();
    }

    @Override
    public Boolean tenerDiaDeSol() {
        if (diaDeSol != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String mostrarInfoDiaDeSol() {
        StringBuilder infoActividadesYExtras = new StringBuilder();
        System.out.println("Actividades disponibles:");
        for (String actividad : diaDeSol.getActividades().split(",")) { // Dividimos por comas
            System.out.println("- " + actividad.trim());
        }
        System.out.println("Extras disponibles:");
        for (String extra : diaDeSol.getExtras().split(",")) { // Dividimos por comas
            System.out.println("- " + extra.trim());
        }
        return infoActividadesYExtras.toString();
    }

    // getters and setters
    public DiaDeSolData getDiaDeSol() {
        return diaDeSol;
    }

    public void setDiaDeSol(DiaDeSolData diaDeSol) {
        this.diaDeSol = diaDeSol;
    }
}
