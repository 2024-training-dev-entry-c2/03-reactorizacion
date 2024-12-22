package com.bookinghotels.service.alojamiento;

import com.bookinghotels.constants.Categoria;
import com.bookinghotels.interfaces.ICommand;
import com.bookinghotels.model.alojamiento.Alojamiento;
import com.bookinghotels.model.alojamiento.Habitacion;
import com.bookinghotels.repositories.AlojamientoRepository;
import com.bookinghotels.utils.ConsolaUtils;

import java.time.LocalDate;
import java.util.List;

public class ObtenerHabitacionesCommand implements ICommand {
  private final AlojamientoRepository repository;
  private final ConsolaUtils consola;
  private final List<String> categorias = List.of(Categoria.values()).stream().map((categoria) -> categoria.getCategoria()).toList();

  public ObtenerHabitacionesCommand(AlojamientoRepository repository, ConsolaUtils consola) {
    this.repository = repository;
    this.consola = consola;
  }

  @Override
  public void execute() {
    String nombre = consola.obtenerEntrada("Ingresa el nombre del alojamiento: ");
    Alojamiento alojamiento = repository.buscarAlojamiento(nombre);
    LocalDate fechaInicio = consola.parseFecha(consola.obtenerEntrada("¿Cuál es la fecha inicio?(YYYY-MM-dd): "));
    LocalDate fechaFin = consola.parseFecha(consola.obtenerEntrada("¿Cuál es la fecha fin?(YYYY-MM-dd): "));
    repository.obtenerHabitacionesDisponibles(alojamiento, fechaInicio, fechaFin).forEach(Habitacion::mostrarDetalles);
  }
}
