package com.bookinghotels.controller.flujo;

import com.bookinghotels.controller.AlojamientoController;
import com.bookinghotels.controller.HuespedController;
import com.bookinghotels.controller.ReservaController;
import com.bookinghotels.model.alojamiento.Hotel;
import com.bookinghotels.model.data.HuespedData;
import com.bookinghotels.model.data.ReservaData;
import com.bookinghotels.utils.ConsolaUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class ModificarReservaController {
  private final AlojamientoController alojamientoController;
  private final HuespedController huespedController;
  private final ReservaController reservaController;

  public ModificarReservaController(AlojamientoController alojamientoController, HuespedController huespedController, ReservaController reservaController) {
    this.alojamientoController = alojamientoController;
    this.huespedController = huespedController;
    this.reservaController = reservaController;
  }

  public void iniciarFlujo(){
    HuespedData huesped = huespedController.buscarHuesped();
    ReservaData reserva = reservaController.obtenerReserva(huesped);
    reserva.mostrarDetalles();
    manejarOpciones(reserva);

  }

  private void manejarOpciones(ReservaData reserva){
    System.out.println("\n-----------");
    if(reserva.getAlojamiento() instanceof Hotel) System.out.println("1. Cambiar habitaciones. ");
    System.out.println("2. Cambiar alojamiento");
    System.out.println("\n-----------");
    Integer opcion = ConsolaUtils.obtenerEntero("Indica la opción: ");
    ejecutarOpciones(opcion,reserva);
  }

  private void ejecutarOpciones(Integer opcion, ReservaData reserva) {
    Map<Integer, BiConsumer<ReservaData, Void>> opciones = new HashMap<>();
    opciones.put(1, (reservaData, v) -> {
      reservaController.modificarReserva(alojamientoController, reservaData);
      reservaData.mostrarDetalles();
    });
    opciones.put(2, (reservaData, v) -> {
      reservaController.eliminarReserva(reservaData);
      System.out.println("Reserva eliminada. Realiza una nueva reserva.");
    });

    opciones.getOrDefault(opcion, (reservaData, v) -> System.out.println("Opción no válida.")).accept(reserva, null);
  }

}

