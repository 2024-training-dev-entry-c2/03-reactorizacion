package org.example.data;

import org.example.models.*;
import org.example.services.ReservaImplementacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Data {
    public static List<Alojamiento> propiedades = new ArrayList<>();
    public static List<ReservaImplementacion> reservas = new ArrayList<>();

    static {
        List<Habitacion> habitacionesHotel = new ArrayList<>();
        habitacionesHotel.add(new Habitacion("Doble", 2, 150.0, true));
        habitacionesHotel.add(new Habitacion("Suite", 4, 300.0, true));
        Hotel hotelCaribe = new Hotel("Hotel Caribe", "Cartagena", 5, habitacionesHotel);

        List<Habitacion> habitacionesFinca = new ArrayList<>();
        habitacionesFinca.add(new Habitacion("Familiar", 6, 200.0, true));
        Finca fincaPalmas = new Finca("Finca Las Palmas", "Guatapé", 4, habitacionesFinca, true);

        List<Habitacion> habitacionesApartamento = new ArrayList<>();
        habitacionesApartamento.add(new Habitacion("Doble", 2, 100.0, true));
        Apartamento apartamentoCentral = new Apartamento("Apartamento Central", "Medellín", 4, habitacionesApartamento, 10, true);

        List<Habitacion> habitacionesDiaSol = new ArrayList<>();
        habitacionesDiaSol.add(new Habitacion("Día Completo", 0, 50.0, true));
        List<String> actividades = List.of("Piscina", "Comida típica", "Juegos al aire libre");
        DiaSol diaDeSol = new DiaSol("Resort Playa", "Cartagena", 5, habitacionesDiaSol, true, actividades);

        propiedades.add(hotelCaribe);
        propiedades.add(fincaPalmas);
        propiedades.add(apartamentoCentral);
        propiedades.add(diaDeSol);

        //Realizo prueba de ejemplo para corroborar información
        Cliente clientePrueba = new Cliente("Juan", "Pérez", "juan.perez@email.com", "Colombiana", "3001234567", LocalDate.of(1990, 5, 15));
        ReservaImplementacion reservaPrueba = new ReservaImplementacion(
                clientePrueba,
                hotelCaribe,
                habitacionesHotel.get(0),
                LocalDate.of(2024, 1, 10),
                LocalDate.of(2024, 1, 15)
        );
        reservas.add(reservaPrueba);
    }
}
