package org.example.a;

import java.time.LocalTime;
import java.util.Date;

public class ResevaService extends BookingService {

    public static void realizarConfirmacionReserva(int inicioHospedaje, int finalHospedaje) {
        System.out.println("///////////////////////////////////////////////////////////////////////////////////");
        limpiarConsola();
        System.out.println("Realizando confirmacion de la reservacion");
        Keyboard.nextLine();
        String nombre = ingresarTexto("Ingrese su nombre: ");
        String apellido = ingresarTexto("Ingrese su apellido: ");
        String email = ingresarTexto("Ingrese su email: ");
        String nacionalidad = ingresarTexto("Ingrese su nacionalidad: ");
        Date fechaNacimiento = ingresarNacimientoFecha();
        String telefono = ingresarTexto("Ingrese su telefono: ");
        LocalTime horaLlegada = ingresarHoraDeLlegada();
        ReservaController.getReserva().setDiaInicio(inicioHospedaje);
        ReservaController.getReserva().setDiaFin(finalHospedaje);
        boolean reservaCompletada = ReservaController.getReserva().reservarHabitacionCliente(
                nombre, apellido, email, nacionalidad, telefono, fechaNacimiento, horaLlegada
        );
        if (!reservaCompletada) {
            System.out.println("ERROR");
            return;
        }
        System.out.println("\nSe ha realizado la reserva con exito");
        ReservaController.getReserva().mostrarDetallesReserva();
        actulizacionReserva(fechaNacimiento, email);
    }

    public static void actulizacionReserva(Date fechaNacimiento, String emailUsuario) {
        boolean salir = false;
        while (!salir) {
            String cambiar = ingresarTexto("Deceas cambiar tu reserva? (Y/N): ");
            if (!cambiar.equalsIgnoreCase("y")) return;
            if (!confirmarIdentidad(fechaNacimiento, emailUsuario)) continue;
            gestionarCambiosReserva();
        }
    }

    public static void gestionarCambiosReserva() {
        boolean salirBucle = false;
        while (!salirBucle) {
            System.out.println("------------------------------------------------");
            System.out.println("Que desea cambiar: ");
            System.out.println("0. Salir");
            System.out.println("1. Cambiar Habitacion");
            System.out.println("2. Cambiar Alojamiento");
            int num = ingresarNumero("");
            salirBucle = AlojamientoService.gestionarOpciones(num);
        }
    }

    public static boolean confirmarIdentidad(Date fechaNacimiento, String emailUsuario) {
        System.out.println("------------------------------------------------");
        System.out.println("Para confirmar su identidad necesitamos algunos datos");
        if (!verificarFechaNacimiento(fechaNacimiento)) return false;
        if (!verificarEmail(emailUsuario)) return false;
        System.out.println("Logramos comprobar su identidad");
        return true;
    }

    public static boolean verificarFechaNacimiento(Date fechaNacimiento) {
        System.out.println("ingrese su fecha de nacimiento: ");
        Date fechaIngresada = ingresarNacimientoFecha();
        if (!fechaIngresada.equals(fechaNacimiento)) {
            mostrarError();
            return false;
        }
        return true;
    }

    public static boolean verificarEmail(String emailUsuario) {
        String emailIngresado = ingresarTexto("ingrese su email: ");
        if (!emailIngresado.equalsIgnoreCase(emailUsuario)) {
            mostrarError();
            return false;
        }
        return true;
    }

    public static void mostrarError() {
        limpiarConsola();
        System.out.println("ERROR con los datos ingresados");
    }
}
