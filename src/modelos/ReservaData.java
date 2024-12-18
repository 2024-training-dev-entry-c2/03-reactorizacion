package modelos;

import java.time.LocalDate;

public class ReservaData <T> {

    private T alojamientos;
    private ClienteData cliente;
    private String horaLlegadaUsuario;
    private String nacimientoUsuario;
    private String[] habitacionesSeleccionadas;
    private LocalDate inicioEstadia;
    private LocalDate finEstadia;

    public ReservaData(T alojamientos, ClienteData cliente, String horaLlegadaUsuario, String nacimientoUsuario, String[] habitacionesSeleccionadas, LocalDate inicioEstadia, LocalDate finEstadia) {
        this.alojamientos = alojamientos;
        this.cliente = cliente;
        this.horaLlegadaUsuario = horaLlegadaUsuario;
        this.nacimientoUsuario = nacimientoUsuario;
        this.habitacionesSeleccionadas = habitacionesSeleccionadas;
        this.inicioEstadia = inicioEstadia;
        this.finEstadia = finEstadia;
    }

    public ReservaData() {
    }

    // getters and setters
    public ClienteData getCliente() {
        return cliente;
    }

    public void setCliente(ClienteData cliente) {
        this.cliente = cliente;
    }

    public String getHoraLlegadaUsuario() {
        return horaLlegadaUsuario;
    }

    public void setHoraLlegadaUsuario(String horaLlegadaUsuario) {
        this.horaLlegadaUsuario = horaLlegadaUsuario;
    }

    public String getNacimientoUsuario() {
        return nacimientoUsuario;
    }

    public void setNacimientoUsuario(String nacimientoUsuario) {
        this.nacimientoUsuario = nacimientoUsuario;
    }

    public T getAlojamientos() {
        return alojamientos;
    }

    public void setAlojamientos(T alojamientos) {
        this.alojamientos = alojamientos;
    }

    public String[] getHabitacionesSeleccionadas() {
        return habitacionesSeleccionadas;
    }

    public void setHabitacionesSeleccionadas(String[] habitacionesSeleccionadas) {
        this.habitacionesSeleccionadas = habitacionesSeleccionadas;
    }

    public LocalDate getInicioEstadia() {
        return inicioEstadia;
    }

    public void setInicioEstadia(LocalDate inicioEstadia) {
        this.inicioEstadia = inicioEstadia;
    }

    public LocalDate getFinEstadia() {
        return finEstadia;
    }

    public void setFinEstadia(LocalDate finEstadia) {
        this.finEstadia = finEstadia;
    }
}
