package com.bookinghotels.repositories;

import com.bookinghotels.constants.Categoria;
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

  public List<Alojamiento> getAlojamientos(){
    return alojamientos;
  }

  public void addAlojamiento(Alojamiento alojamiento){
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
