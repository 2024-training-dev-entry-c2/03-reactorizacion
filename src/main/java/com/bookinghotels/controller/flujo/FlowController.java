package com.bookinghotels.controller.flujo;

import com.bookinghotels.constants.Categoria;
import com.bookinghotels.controller.AlojamientoController;
import com.bookinghotels.controller.HuespedController;
import com.bookinghotels.controller.ReservaController;
import com.bookinghotels.utils.ConsolaUtils;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlowController {
  private final AlojamientoController alojamientoController;
  private final HuespedController huespedController;
  private final ReservaController reservaController;
  private final List<String> categorias = Stream.of(Categoria.values()).map(Categoria::getCategoria).toList();

  public FlowController(){
    this.alojamientoController = new AlojamientoController();
    this.huespedController = new HuespedController();
    this.reservaController = new ReservaController();
  }

  public void iniciarFlujo(){
    int opcion;
    do {
      System.out.println("\n----- Menú -----\n1. Buscar y reservar alojamiento\n2. Modificar reserva\n3. Salir.\n----------------");
      opcion = ConsolaUtils.obtenerEntero("Ingresa la opción: ");
      if(opcion != 3) manejoOpciones(opcion);
    }while (opcion != 3);

  }

  public void manejoOpciones(Integer opcion){
    if(opcion == 1) obtenerDatosIniciales();
    if(opcion == 2) obtenerDatosModificar();
  }

  private void obtenerDatosIniciales(){
    System.out.println("\n-----------\n" +getCategorias() + "\n-----------");
    Categoria categoria = getCategoria(ConsolaUtils.obtenerEntero("Ingresa la categoria: "));
    Integer cantPersonas = ConsolaUtils.obtenerEntero("¿Cuántas personas son?:");
    LocalDate fechaInicio = ConsolaUtils.parseFecha(ConsolaUtils.obtenerEntrada("¿Cuál es la fecha inicio? (YYYY-MM-dd): "));
    BuscarYReservarController controller = new BuscarYReservarController(alojamientoController,huespedController,reservaController);
    if(categoria.equals(Categoria.DIA_SOL)){
      controller.iniciarFlujoReservaDiaSol(fechaInicio,cantPersonas);
    }else{
      LocalDate fechaFin = ConsolaUtils.parseFecha(ConsolaUtils.obtenerEntrada("¿Cuál es la fecha fin? (YYYY-MM-dd): "));
      controller.iniciarFlujoReserva(categoria, fechaInicio, fechaFin, cantPersonas);
    }
  }

  private void obtenerDatosModificar(){
    ModificarReservaController modificarReservaController = new ModificarReservaController(alojamientoController, huespedController, reservaController);
    modificarReservaController.iniciarFlujo();
  }



  public String getCategorias(){
    return this.categorias.stream().map(categoria -> (categorias.lastIndexOf(categoria) + 1) + ". " + categoria).collect(Collectors.joining("\n"));
  }

  public Categoria getCategoria(Integer opcion){
    Map<Integer,Categoria> categoriaMap = new HashMap<>();
    categoriaMap.put(1, Categoria.APARTAMENTO);
    categoriaMap.put(2, Categoria.FINCA);
    categoriaMap.put(3, Categoria.HOTEL);
    categoriaMap.put(4, Categoria.DIA_SOL);
    return categoriaMap.get(opcion);
  }
}
