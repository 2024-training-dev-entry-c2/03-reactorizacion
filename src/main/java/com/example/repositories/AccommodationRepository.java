package com.example.repositories;

import com.example.models.Accommodation;
import com.example.constants.AccommodationType;
import com.example.models.DayPass;
import com.example.models.Room;
import com.example.models.Service;
import com.example.models.Stay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccommodationRepository {
    private static AccommodationRepository instance;
    private List<Accommodation> accommodations;
    private List<String> cities;

    private AccommodationRepository() {
        cities = new ArrayList<String>();
        initialize();
    }

    public static AccommodationRepository getInstance() {
        if (instance == null) {
            instance = new AccommodationRepository();
        }
        return instance;
    }

    private void initialize() {
        accommodations = Arrays.asList(
                new Stay("Gran Hotel Madrid", 4.5f, "MADRID", "Lujoso hotel en el centro de la ciudad", Arrays.asList(
                        new Room("Suite", "Habitación de lujo con sala de estar", 10, "Suite", 200.0f),
                        new Room("Doble", "Habitación doble con vistas a la ciudad", 5, "Doble", 150.0f),
                        new Room("Individual", "Habitación individual cómoda y económica", 3, "Individual", 100.0f),
                        new Room("Familiar", "Habitación espaciosa para toda la familia", 7, "Familiar", 250.0f),
                        new Room("Deluxe", "Habitación con servicios exclusivos", 2, "Deluxe", 300.0f)),
                        200.0f, AccommodationType.HOTEL),

                new Stay("Hotel Sol", 3.8f, "BARCELONA", "Hotel acogedor cerca de la playa", Arrays.asList(
                        new Room("Familiar", "Habitación ideal para familias grandes", 8, "Familiar", 180.0f),
                        new Room("Doble", "Habitación doble con balcón", 6, "Doble", 120.0f),
                        new Room("Individual", "Habitación económica y cómoda", 5, "Individual", 90.0f),
                        new Room("Suite", "Habitación con sala de estar y vistas al mar", 4, "Suite", 220.0f),
                        new Room("Penthouse", "Ático de lujo con terraza privada", 3, "Penthouse", 300.0f)),
                        150.0f, AccommodationType.HOTEL),

                new Stay("Villa del Mar", 5.0f, "VALENCIA", "Exclusiva villa con vistas al mar", Arrays.asList(
                        new Room("Villa", "Villa privada con piscina", 4, "Villa", 300.0f),
                        new Room("Doble", "Habitación doble frente al mar", 3, "Doble", 250.0f),
                        new Room("Suite", "Suite con terraza y jacuzzi", 5, "Suite", 400.0f),
                        new Room("Individual", "Habitación económica para viajeros", 2, "Individual", 200.0f),
                        new Room("Deluxe", "Habitación de lujo con vista panorámica", 6, "Deluxe", 500.0f)),
                        300.0f, AccommodationType.HOTEL),

                new Stay("Hotel Medellin", 4.5f, "MEDELLIN", "Hotel en el centro de la ciudad", Arrays.asList(
                        new Room("Suite", "Habitación de lujo con sala de estar", 10, "Suite", 200.0f),
                        new Room("Doble", "Habitación doble con vistas a la ciudad", 5, "Doble", 150.0f),
                        new Room("Individual", "Habitación individual cómoda y económica", 3, "Individual", 100.0f),
                        new Room("Familiar", "Habitación espaciosa para toda la familia", 7, "Familiar", 250.0f),
                        new Room("Deluxe", "Habitación con servicios exclusivos", 2, "Deluxe", 300.0f)),
                        200.0f, AccommodationType.HOTEL),

                new Stay("Apartamento Centro", 3.5f, "MEDELLIN", "Apartamento en el centro de la ciudad", Arrays.asList(
                        new Service("Habitaciones con litera", "Apartamento con 3 habitaciones con 5 literas."),
                        new Service("Sala de estar", "Apartamento con amplia sala de estar."),
                        new Service("Wi-Fi gratuito", "Conexión a internet de alta velocidad para trabajar."),
                        new Service("Parking ", "Parking privado para los huéspedes.")),
                        200.0f, AccommodationType.APARTMENT),

                new Stay("Apartamento Poblado", 4.8f, "MEDELLIN", "Apartamento en el barrio el poblado", Arrays.asList(
                        new Service("Suit matrimonial", "Apartamento con habitación principal con cama matrimonial QueenSize."),
                        new Service("Sala de estar", "Apartamento con amplia sala de estar."),
                        new Service("Vista panorámica a la ciudad", "Ofrece una vista panorámica a la ciudad."),
                        new Service("Gimnasio privado", "Gimnasio con máquinas de última generación."),
                        new Service("Parking ", "Parking privado para los huéspedes y hasta dos invitados más.")),
                        250.0f, AccommodationType.APARTMENT),

                new Stay("Apartamento Suba", 3.5f, "BOGOTA", "Apartamento en el barrio suba", Arrays.asList(
                        new Service("Habitaiones dobles", "Apartamento con 2 habitaciones dobles."),
                        new Service("Wi-Fi gratuito", "Conexión a internet de alta velocidad para trabajar."),
                        new Service("Gimnasio privado", "Gimnasio con máquinas de última generación."),
                        new Service("Parking ", "Parking privado para los huéspedes.")),
                        150.0f, AccommodationType.APARTMENT),

                new Stay("Apartamento Madrid", 4.5f, "MADRID", "Apartamento en el centro de la ciudad", Arrays.asList(
                        new Service("Habitaciones con litera", "Apartamento con 3 habitaciones con 5 literas."),
                        new Service("Sala de estar", "Apartamento con amplia sala de estar."),
                        new Service("Wi-Fi gratuito", "Conexión a internet de alta velocidad para trabajar."),
                        new Service("Parking ", "Parking privado para los huéspedes.")),
                        225.5f, AccommodationType.APARTMENT),

                new DayPass("Polideportivo Madrid", 4.5f, "MADRID", "DayPass en el centro de la ciudad", Arrays.asList(
                        new Service("Piscina", "Acceso a la piscina olimpica y de niños"),
                        new Service("Gimnasio", "gimnasio con maquinas, peso libre con entrenador disponible de 8am a 8pm"),
                        new Service("Restaurante", "Restaurante con menú del día y carta"),
                        new Service("Spa", "Spa con sauna, jacuzzi y masajes")),
                        50.0f),

                new DayPass("Campo de mini golf", 3.8f, "BARCELONA", "DayPass en el campo de mini golf", Arrays.asList(
                        new Service("Mini golf", "Acceso a las canchas de mini golf"),
                        new Service("Restaurante", "Restaurante con menú del día y carta"),
                        new Service("Bar", "Bar con bebidas y snacks"),
                        new Service("Zona de juegos", "Zona de juegos para niños")),
                        30.0f),

                new DayPass("Parque acuático", 5.0f, "VALENCIA", "DayPass en el parque acuático", Arrays.asList(
                        new Service("Piscinas", "Acceso a las piscinas y toboganes"),
                        new Service("Restaurante", "Restaurante con menú del día y carta"),
                        new Service("Bar", "Bar con bebidas y snacks"),
                        new Service("Zona de juegos", "Zona de juegos para niños")),
                        40.0f),

                new DayPass("Cabalgatas piedras blancas", 4.5f, "MEDELLIN", "DayPass en el campo de cabalgatas", Arrays.asList(
                        new Service("Cabalgatas", "Acceso a las cabalgatas por el campo"),
                        new Service("Restaurante", "Restaurante con menú del día y carta"),
                        new Service("Bar", "Bar con bebidas y snacks"),
                        new Service("Zona de juegos", "Zona de juegos para niños")),
                        35.0f)
        );

        for (Accommodation accommodation : accommodations) {
            if (cities.contains(accommodation.getCity())) {
                continue;
            }
            cities.add(accommodation.getCity());
        }
    }

    public List<DayPass> getDayPasses() {
        List<DayPass> dayPasses = new ArrayList<>();
        for (Accommodation accommodation : accommodations) {
            if (accommodation instanceof DayPass) {
                dayPasses.add((DayPass) accommodation);
            }
        }
        return dayPasses;
    }

    public List<Stay> getStays() {
        List<Stay> stays = new ArrayList<>();
        for (Accommodation accommodation : accommodations) {
            if (accommodation instanceof Stay) {
                stays.add((Stay) accommodation);
            }
        }
        return stays;
    }

    public static void setInstance(AccommodationRepository instance) {
        AccommodationRepository.instance = instance;
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public List<Accommodation> getAccommodations() {
        return accommodations;
    }

    public void setAccommodations(List<Accommodation> accommodations) {
        this.accommodations = accommodations;
    }
}
