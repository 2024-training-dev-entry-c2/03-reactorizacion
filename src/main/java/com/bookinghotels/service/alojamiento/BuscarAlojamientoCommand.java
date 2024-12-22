package com.bookinghotels.service.alojamiento;

import com.bookinghotels.constants.Categoria;
import com.bookinghotels.interfaces.ICommand;
import com.bookinghotels.model.alojamiento.Alojamiento;
import com.bookinghotels.repositories.AlojamientoRepository;
import com.bookinghotels.utils.ConsolaUtils;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BuscarAlojamientoCommand implements ICommand {
  private final AlojamientoRepository repository;
  private final ConsolaUtils consola;
  private final List<String> categorias = List.of(Categoria.values()).stream().map((categoria) -> categoria.getCategoria()).toList();

  public BuscarAlojamientoCommand(AlojamientoRepository repository, ConsolaUtils consola) {
    this.repository = repository;
    this.consola = consola;
  }

  @Override
  public void execute(){
    Categoria categoria = getCategoria(consola.obtenerEntero("Elige el número del tipo de alojamiento\n" + getCategorias())-1);
    String ciudad = consola.obtenerEntrada("Indica la ciudad: ");
    LocalDate fechaInicio = consola.parseFecha(consola.obtenerEntrada("¿Cuál es la fecha inicio?(YYYY-MM-dd): "));
    LocalDate fechaFin = consola.parseFecha(consola.obtenerEntrada("¿Cuál es la fecha fin?(YYYY-MM-dd): "));
    Integer cantPersonas = consola.obtenerEntero("¿Cuántas personas son?:");
    Integer cantHabitaciones = consola.obtenerEntero("¿Cuántas habitaciones necesitas?:");

    repository.buscarAlojamientos(categoria, ciudad, fechaInicio, fechaFin, cantPersonas, cantHabitaciones).forEach(Alojamiento::getDetalles);
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
