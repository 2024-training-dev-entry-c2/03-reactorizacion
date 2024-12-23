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

public class BuscarAlojamientosCommand implements ICommand {
  private final AlojamientoRepository repository;
  private final ConsolaUtils consola;
  private final LocalDate fechaInicio;
  private final LocalDate fechaFin;
  private final Integer cantPersonas;
  private final Integer cantHabitaciones;
  private final List<String> categorias = List.of(Categoria.values()).stream().map((categoria) -> categoria.getCategoria()).toList();


  public BuscarAlojamientosCommand(AlojamientoRepository repository, LocalDate fechaInicio, LocalDate fechaFin, Integer cantPersonas, Integer cantHabitaciones, ConsolaUtils consola) {
    this.repository = repository;
    this.fechaInicio = fechaInicio;
    this.fechaFin = fechaFin;
    this.cantPersonas = cantPersonas;
    this.cantHabitaciones = cantHabitaciones;
    this.consola = consola;
  }

  @Override
  public List<Alojamiento> execute(){
    String ciudad = consola.obtenerEntrada("Indica la ciudad: ");
    Categoria categoria = getCategoria(consola.obtenerEntero("Elige el número del tipo de alojamiento\n" + getCategorias()));
    return repository.buscarAlojamientos(categoria, ciudad, fechaInicio, fechaFin, cantPersonas, cantHabitaciones);
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
