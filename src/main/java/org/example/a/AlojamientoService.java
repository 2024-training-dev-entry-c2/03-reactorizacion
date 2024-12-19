package org.example.a;

import java.util.LinkedList;

public class AlojamientoService extends BookingService {
    public static AlojamientoControladoraImplementacion controladoraApp = new AlojamientoControladoraImplementacion();
    public static LinkedList<Habitacion> habitacionesDisponibles;

    public static void seleccionarAlojamiento() {
        String nombreCiudad = elegirNombreCiudad();
        var alojamiento = elegirAlojamiento();
        int cantHabitaciones = ingresarNumero("Ingrese la cantidad de habitaciones: ");
        int cantAdultos = ingresarCantidadPersonas("Adultos");
        int cantNinios = ingresarCantidadPersonas("Ninios");
        int inicioHospedaje = ingresarFecha("Ingrese la fecha de inicio del hospedaje");
        int finalHospedaje = ingresarFecha("Ingrese la fecha final del hospedaje");
        procesarAlojamiento(alojamiento, nombreCiudad, cantHabitaciones, cantAdultos, cantNinios, inicioHospedaje, finalHospedaje);
        ResevaService.realizarConfirmacionReserva(inicioHospedaje, finalHospedaje);
    }

    private static void procesarAlojamiento(Alojamiento alojamiento, String nombreCiudad, int cantHabitaciones, int cantAdultos, int cantNinios, int inicioHospedaje, int finalHospedaje) {
        controladoraApp.filtrarPorParametros(nombreCiudad, alojamiento, cantHabitaciones, inicioHospedaje, finalHospedaje, cantAdultos, cantNinios);
        if (alojamiento instanceof Hotel) {
            procesarHotel((Hotel) alojamiento, cantHabitaciones, cantAdultos, cantNinios, inicioHospedaje, finalHospedaje);
        } else if (alojamiento instanceof Finca) {
            procesarFinca((Finca) alojamiento, cantAdultos, cantNinios, inicioHospedaje, finalHospedaje);
        }
    }

    private static void procesarHotel(Hotel unHotel, int cantHabitaciones, int cantAdultos, int cantNinios, int inicioHospedaje, int finalHospedaje) {
        habitacionesDisponibles = unHotel.habitacionesDisponibles(
                unHotel.getNombre(), inicioHospedaje, finalHospedaje, cantAdultos, cantNinios, cantHabitaciones
        );
        seleccionarHabitacion(habitacionesDisponibles, unHotel);
    }

    private static void procesarFinca(Finca unFinca, int cantAdultos, int cantNinios, int inicioHospedaje, int finalHospedaje) {
        ReservaController.getReserva().setAlojamiento(unFinca);
        ReservaController.getReserva().setPrecioTotal(
                unFinca.calcularPrecio(unFinca.getPrecioNoche(), cantAdultos + cantNinios, inicioHospedaje, finalHospedaje)
        );
    }

    public static void actualizarHabitacion(LinkedList<Habitacion> habitacionesDisponibles) {

        Alojamiento alojamientoReservado = ReservaController.getReserva().getAlojamiento();

        if (alojamientoReservado instanceof Hotel) {
            for (int i = 0; i < habitacionesDisponibles.size(); i++) {
                System.out.println("Id: " + i);
                habitacionesDisponibles.get(i).mostrarDatos();
            }
            selecionarHabitacionAActualizar(alojamientoReservado);
        } else {
            seleccionarAlojamiento();
        }
    }

    public static void selecionarHabitacionAActualizar(Alojamiento alojamientoReservado) {
        while (true) {
            try {
                int idHabitacion = ingresarNumero("Ingrese la id de la habitacion a reservar: ");
                seleccionarHabitacion(habitacionesDisponibles, (Hotel) alojamientoReservado);
                ReservaController.getReserva().setAlojamiento(habitacionesDisponibles.get(idHabitacion), (Hotel) alojamientoReservado);
                return;
            } catch (Exception e) {
                System.out.println("Habitacion no encontrada");
            }
        }
    }

    public static String elegirNombreCiudad() {
        while (true) {
            System.out.println("-----------------------------");
            System.out.println("BIENVENIDO A Booking Hoteles");
            System.out.println("Realize su reserva de habitaciones");
            System.out.println("Elija la ciudad de el hotel al que desea viajar");
            String ciudad = ingresarTexto("Escriba el nombre de la ciudad ");
            if (controladoraApp.buscarCiudadNombre(ciudad)) return ciudad;
        }
    }

    public static Alojamiento elegirAlojamiento() {
        String[] tipoAlojamiento = {"Hotel", "Finca", "Apartamento"};
        while (true) {
            for (String tipo : tipoAlojamiento) {
                controladoraApp.mostrarTodosAlojamientos(tipo);
                int num = ingresarNumero("Eliga una opción (id para elegir " + tipo + ", o -1 para continuar): ");
                Alojamiento alojamientoElegido = controladoraApp.econtrarAlojamientos(tipo, num);
                if (alojamientoElegido != null) return alojamientoElegido;
            }
        }
    }

    public static int ingresarCantidadPersonas(String tipoPersona) {
        System.out.println("-----------------------------");
        int cantPersonas = ingresarNumeroPositivo("Ingrese la cantidad de " + tipoPersona + " a ingresar: ");
        System.out.println("-----------------------------");
        return cantPersonas;
    }

    public static void seleccionarHabitacion(LinkedList<Habitacion> habitacionesDisponibles, Hotel hotelAResevar) {
        while (true) {
            System.out.println("-----------------------------");
            try {
                int idHabitacion = ingresarNumero("Ingrese la id de la habitacion a reservar: ");
                ReservaController.getReserva().setAlojamiento(habitacionesDisponibles.get(idHabitacion), hotelAResevar);
                ReservaController.getReserva().setPrecioTotal(habitacionesDisponibles.get(idHabitacion).getPrecio());
                return;
            } catch (Exception _) {
                System.out.println("Habitacion no encontrada");
            }
        }
    }

    public static boolean gestionarOpciones(int num) {
        switch (num) {
            case 0 -> {
                return true;
            }
            case 1 -> actualizarHabitacion(habitacionesDisponibles);
            case 2 -> seleccionarAlojamiento();
        }
        return false;
    }


}
