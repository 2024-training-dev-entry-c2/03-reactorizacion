package com.bookinghotels.controller.flujo;

import com.bookinghotels.controller.AlojamientoController;
import com.bookinghotels.controller.HuespedController;
import com.bookinghotels.controller.ReservaController;
import com.bookinghotels.model.alojamiento.Hotel;
import com.bookinghotels.model.data.HuespedData;
import com.bookinghotels.model.data.ReservaData;
import com.bookinghotels.utils.ConsolaUtils;

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
    ModificarReservaController controller = new ModificarReservaController(alojamientoController,huespedController,reservaController);
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

  private void ejecutarOpciones(Integer opcion, ReservaData reserva){
    if(opcion == 1){
      reservaController.modificarReserva(alojamientoController,reserva);
      reserva.mostrarDetalles();
    }else if(opcion == 2){
      reservaController.eliminarReserva(reserva);
    }
  }

}
