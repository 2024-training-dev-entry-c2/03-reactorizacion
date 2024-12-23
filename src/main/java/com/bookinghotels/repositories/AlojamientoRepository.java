package com.bookinghotels.repositories;

import com.bookinghotels.constants.Categoria;
import com.bookinghotels.interfaces.IDiaDeSol;
import com.bookinghotels.model.alojamiento.Alojamiento;
import com.bookinghotels.model.alojamiento.Apartamento;
import com.bookinghotels.model.alojamiento.DiaDeSol;
import com.bookinghotels.model.alojamiento.Finca;
import com.bookinghotels.model.alojamiento.Habitacion;
import com.bookinghotels.model.alojamiento.Hotel;
import com.bookinghotels.model.data.ReservaData;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AlojamientoRepository {
  private static AlojamientoRepository instance;
  private List<Alojamiento> alojamientos;

  private AlojamientoRepository() {
    alojamientos = new ArrayList<>();
    cargarDatosIniciales();
    System.out.println(alojamientos);
  }

  public static synchronized AlojamientoRepository getInstance() {
    if (instance == null) {
      instance = new AlojamientoRepository();
    }
    return instance;
  }

  public void addAlojamiento(Alojamiento alojamiento){ // lo mantengo para uso futuro
    alojamientos.add(alojamiento);
  }

  public List<Alojamiento> buscarAlojamientos(Categoria categoria, String ciudad, LocalDate fechaInicio, LocalDate fechaFin, Integer cantPersonas, Integer cantHabitaciones) {
    List<ReservaData<?>> reservas = ReservaRepository.getInstance().getReservas();

    return alojamientos.stream()
      .filter(alojamiento -> cumpleDisponibilidad(alojamiento, fechaInicio, fechaFin, cantPersonas, cantHabitaciones, reservas))
      .filter(alojamiento -> cumpleCategoriaCiudad(alojamiento, categoria, ciudad))
      .toList();
  }

  public Alojamiento buscarAlojamiento(String nombre){
    return alojamientos.stream()
      .filter(alojamiento -> alojamiento.getNombre().equalsIgnoreCase(nombre))
      .findFirst()
      .orElse(null);
  }

  public List<IDiaDeSol> buscarDiaSol(String ciudad, LocalDate fecha, Integer cantPersonas) {
    return alojamientos.stream()
      .filter(aloj -> esDiaDeSolYCumpleCriterios(aloj, ciudad, cantPersonas))
      .map(this::convertirADiaDeSol)
      .collect(Collectors.toList());
  }

  private boolean esDiaDeSolYCumpleCriterios(Object aloj, String ciudad, Integer cantPersonas) {
    if (!(aloj instanceof IDiaDeSol iDiaDeSol)) {
      return false;
    }
    return cumpleCiudad((Alojamiento) iDiaDeSol, ciudad) &&
      iDiaDeSol.getDiaSol().estaDisponible(cantPersonas);
  }

  private IDiaDeSol convertirADiaDeSol(Object aloj) {
    return (IDiaDeSol) aloj;
  }


  public List<Habitacion> obtenerHabitacionesDisponibles(Alojamiento alojamiento, LocalDate fechaInicio, LocalDate fechaFin) {
    List<ReservaData<?>> reservas = ReservaRepository.getInstance().getReservas();
    return alojamiento.obtenerHabitacionesDisponibles(fechaInicio, fechaFin, reservas);
  }

  private boolean cumpleDisponibilidad(Alojamiento alojamiento, LocalDate fechaInicio, LocalDate fechaFin, Integer cantPersonas, Integer cantHabitaciones, List<ReservaData<?>> reservas) {
    return alojamiento.estaDisponible(fechaInicio, fechaFin, cantPersonas, cantHabitaciones, reservas);
  }

  private boolean cumpleCategoriaCiudad(Alojamiento alojamiento, Categoria categoria, String ciudad){
    return cumpleCategoria(alojamiento, categoria) && cumpleCiudad(alojamiento,ciudad);
  }

  private boolean cumpleCategoria(Alojamiento alojamiento, Categoria categoria) {
    return alojamiento.getCategoria().equals(categoria);
  }

  private boolean cumpleCiudad(Alojamiento alojamiento, String ciudad) {
    return alojamiento.getCiudad().equalsIgnoreCase(ciudad);
  }

  private void cargarDatosIniciales(){
    Hotel hotel1 = new Hotel("Hotel Caribe Real","Cartagena", 4.8f,
      new DiaDeSol("snorking, yoga", new ArrayList<String>(){{
        add("Almuerzo");
        add("Cena");
      }}, 45000f, 30), false);

    hotel1.agregarHabitacion(new Habitacion("Habitación Estándar", "Cómoda y funcional, con cama doble y vista al jardín.", 250000.0f, 8, 2));
    hotel1.agregarHabitacion(new Habitacion("Habitación Premium", "Cama king-size, minibar, y balcón con vista al mar.", 400000.0f, 5, 2));
    hotel1.agregarHabitacion(new Habitacion("Habitación Familiar", "Capacidad para 4 personas, con dos camas queen y sala de estar.", 600000.0f, 4, 4));
    hotel1.agregarHabitacion(new Habitacion("Suite Nupcial", "Lujo total, jacuzzi privado y champaña de bienvenida.", 800000.0f, 2, 2));
    hotel1.agregarHabitacion(new Habitacion("Habitación Económica", "Espacio básico con cama doble y baño privado.", 150000.0f, 10, 2));
    alojamientos.add(hotel1);

    alojamientos.add(new Apartamento("Apartamento Costa Brisa", "Santa Marta", 4.6f, 5, "2", "201B", 400000.0f));
    alojamientos.add(new Finca("Finca La Montaña", "Manizales", 4.7f, 6, null, 700000.0f));

  }
}
