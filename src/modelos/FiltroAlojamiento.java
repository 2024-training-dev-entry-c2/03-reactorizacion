package modelos;

import java.time.LocalDate;
import java.util.Scanner;

public class FiltroAlojamiento {

    public static void buscarAlojamiento(Alojamiento[] alojamientos, String ciudad, String tipo, LocalDate inicioEstadia, LocalDate finEstadia, int adultos, int ninos, int habitaciones) {
        boolean alojamientoEncontrado = false;

        // calculando los dias de estadia
        long diferenciaEnDias = finEstadia.toEpochDay() - inicioEstadia.toEpochDay();

        // el alojamiento debe ser de un dia o mas
        if (diferenciaEnDias <= 0) {
            System.out.println("Debe alojarse como minimo un dia");
            return;
        }

        // Recorremos el arreglo de alojamientos
        for (int i = 0; i < alojamientos.length; i++) {
            Alojamiento alojamiento = alojamientos[i];

            int totalHabitacionesDisponibles = 0;
            for (int j = 0; j < alojamientos[i].getHabitaciones().length; j++) {
                totalHabitacionesDisponibles += alojamientos[i].getHabitaciones()[j].getHabitacionesDisponibles();
            }

            // Verificamos si la ciudad y el tipo coinciden con los proporcionados por el usuario
            if (((tipo.equalsIgnoreCase("Dia de Sol") &&
                    alojamiento.ofreceDiaDeSol) || alojamiento.getClass().getSimpleName().equalsIgnoreCase(tipo)) &&
                    alojamiento.getCiudadDestino().equalsIgnoreCase(ciudad) &&
                    alojamiento.getMaxAdultos() >= adultos &&
                    alojamiento.getMaxNinos() >= ninos &&
                    totalHabitacionesDisponibles >= habitaciones) {
                alojamientoEncontrado = true;
                alojamiento.mostrarInfo(inicioEstadia, finEstadia, habitaciones, adultos, ninos, alojamiento.incluyeRefrigerio, alojamiento.incluyeAlmuerzo);
                System.out.println("--------------------------");
            }
        }

        if (!alojamientoEncontrado) {
            System.out.println("No se encontraron alojamientos que coincidan con los criterios proporcionados.");
        }

        if (alojamientoEncontrado) {
            // solicito al usuario seleccionar un alojamiento
            Scanner scanner = new Scanner(System.in);
            System.out.println("Seleccione el alojamiento que desea (ingrese el nombre del alojamiento):");
            String hotelSeleccionadoPorUsuario = scanner.nextLine();

            // confirmar las habitaciones para el alojamiento seleccionado
            confirmarHabitaciones(alojamientos, hotelSeleccionadoPorUsuario, inicioEstadia, finEstadia, adultos, ninos, habitaciones);

            // Llamar al metodo para hacer la reserva
            System.out.println("Para proceder con la reserva, ingrese los siguientes datos:");
            // declaro las variables de datos del usuario que ingresara en el metodo
            String nombreUsuario = "", apellidoUsuario = "", correoUsuario = "", nacionalidadUsuario = "", horaLlegadaUsuario = "", nacimientoUsuario = "";
            int telefonoUsuario = 0;

            // confirmo si el usuario desea continuar con la reserva
            System.out.println("¿Desea continuar con la reserva? (Por favor digite Si o No)");
            String respuesta = scanner.nextLine();

            if (respuesta.equalsIgnoreCase("Si")) {
                // pido al usuario ingresar nuevamente cuantas habitaciones quiere reservar
                System.out.println("Ingrese nuevamente el número de habitaciones que desea reservar");
                int cantidadHabitaciones = scanner.nextInt();
                scanner.nextLine();

                // muestro los tipos de habitaciones disponibles segun el alojamiento que habia escogido el usuario
                System.out.println("Tipos de habitaciones disponibles:");
                for (int i = 0; i < alojamientos[hotelSeleccionadoPorUsuarioIndex].getHabitaciones().length; i++) {
                    System.out.println((i + 1) + ". " + alojamientos[hotelSeleccionadoPorUsuarioIndex].getHabitaciones()[i].getTiposDeHabitaciones());
                }

                // almaceno la cantidad de habitaciones que el usuario ingreso
                String[] habitacionesSeleccionadas = new String[cantidadHabitaciones];

                // el usuario debe seleccionar el tipo de habitacion por cada habitacion que quiera
                for (int i = 0; i < cantidadHabitaciones; i++) {
                    System.out.println("Seleccione el tipo de habitación #" + (i + 1) + ":");
                    int habitacionSeleccionada = scanner.nextInt();
                    scanner.nextLine();

                    // validando la seleccion. solo hay 5 tipos
                    if (habitacionSeleccionada < 1 || habitacionSeleccionada > alojamientos[hotelSeleccionadoPorUsuarioIndex].getHabitaciones().length) {
                        System.out.println("Opción no válida. Intente de nuevo.");
                        i--;
                        continue;
                    }

                    int habitacionseleccionadaIndex = habitacionSeleccionada - 1;
                    // almaceno la seleccion del usuario
                    habitacionesSeleccionadas[i] = alojamientos[hotelSeleccionadoPorUsuarioIndex].getHabitaciones()[habitacionseleccionadaIndex].getTiposDeHabitaciones();

                    // actualizo las habitaciones que quedan disponibles
                    alojamientos[hotelSeleccionadoPorUsuarioIndex].getHabitaciones()[habitacionseleccionadaIndex].removerHabitacionesDisponibles(1);
                    System.out.println("Habitaciones disponibles actualizadas: " + alojamientos[hotelSeleccionadoPorUsuarioIndex].getHabitaciones()[habitacionseleccionadaIndex].habitacionesDisponibles);
                }

                // solicito los datos de usuario
                System.out.println("Ingrese su nombre:");
                nombreUsuario = scanner.nextLine();

                System.out.println("Ingrese su apellido:");
                apellidoUsuario = scanner.nextLine();

                System.out.println("Ingrese su correo:");
                correoUsuario = scanner.nextLine();

                System.out.println("Ingrese su fecha de nacimiento con el formatio AAAA-MM-DD:");
                nacimientoUsuario = scanner.nextLine();

                System.out.println("Ingrese su nacionalidad:");
                nacionalidadUsuario = scanner.nextLine();

                System.out.println("Ingrese su teléfono:");
                telefonoUsuario = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Ingrese la hora de llegada (HH:mm):");
                horaLlegadaUsuario = scanner.nextLine();

                reservarAlojamiento(nombreUsuario, apellidoUsuario, correoUsuario, nacionalidadUsuario, telefonoUsuario, horaLlegadaUsuario, habitacionesSeleccionadas, nacimientoUsuario, inicioEstadia, finEstadia);

            } else {
                System.out.println("La reserva no se realizó.");
            }
        } else {
            System.out.println("No se encontraron alojamientos que coincidan con su busqueda. Intente nuevamente");
        }
    }
}
