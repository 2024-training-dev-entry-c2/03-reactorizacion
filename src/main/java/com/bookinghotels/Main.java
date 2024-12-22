package com.bookinghotels;

import com.bookinghotels.repositories.AlojamientoRepository;
import com.bookinghotels.service.alojamiento.BuscarAlojamientoCommand;
import com.bookinghotels.service.alojamiento.ObtenerHabitacionesCommand;
import com.bookinghotels.utils.ConsolaUtils;


public class Main {

    public static void main(String[] args) {
        ConsolaUtils consolaUtils = new ConsolaUtils();
        AlojamientoRepository alojamientoRepository = AlojamientoRepository.getInstance();

        mostrarLogo();

        BuscarAlojamientoCommand buscarAlojamientoCommand = new BuscarAlojamientoCommand(alojamientoRepository, consolaUtils);
        buscarAlojamientoCommand.execute();
        ObtenerHabitacionesCommand obtenerHabitacionesCommand = new ObtenerHabitacionesCommand(alojamientoRepository, consolaUtils);
        obtenerHabitacionesCommand.execute();
    }

    public static void  mostrarLogo(){
        System.out.println("\n         ___|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|___    ");
        System.out.println("        |                                     |    ");
        System.out.println("        |      Bienvenido(a) a Book Stay      |    ");
        System.out.println("        |_____________________________________|    ");
        System.out.println("               |     |     |     |     |          \n");
    }
}
