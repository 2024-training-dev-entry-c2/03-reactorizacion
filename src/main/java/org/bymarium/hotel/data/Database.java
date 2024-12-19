package org.bymarium.hotel.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bymarium.hotel.models.*;

public class Database {
  private static Database instance;
  private List<Accommodation> accommodations;
  private final List<Booking> bookings = new ArrayList<>();

  private Database() {
    initialize();
  }

  public static Database getInstance() {
    if (instance == null) {
      instance = new Database();
    }

    return instance;
  }

  public List<Accommodation> getAccommodations() {
    return accommodations;
  }

  private void initialize() {
    accommodations = Arrays.asList(
      new Stay("Gran Hotel Madrid", 4.5f, "Madrid", "Lujoso hotel en el centro de la ciudad", Arrays.asList(
        new Room("Suite", "Habitación de lujo con sala de estar", 10, "Suite", 200.0f),
        new Room("Doble", "Habitación doble con vistas a la ciudad", 5, "Doble", 150.0f),
        new Room("Individual", "Habitación individual cómoda y económica", 3, "Individual", 100.0f),
        new Room("Familiar", "Habitación espaciosa para toda la familia", 7, "Familiar", 250.0f),
        new Room("Deluxe", "Habitación con servicios exclusivos", 2, "Deluxe", 300.0f)),
        200.0f, AccommodationType.HOTEL),

      new Stay("Hotel Sol", 3.8f, "Barcelona", "Hotel acogedor cerca de la playa", Arrays.asList(
        new Room("Familiar", "Habitación ideal para familias grandes", 8, "Familiar", 180.0f),
        new Room("Doble", "Habitación doble con balcón", 6, "Doble", 120.0f),
        new Room("Individual", "Habitación económica y cómoda", 5, "Individual", 90.0f),
        new Room("Suite", "Habitación con sala de estar y vistas al mar", 4, "Suite", 220.0f),
        new Room("Penthouse", "Ático de lujo con terraza privada", 3, "Penthouse", 300.0f)),
        150.0f, AccommodationType.FARM),

      new Stay("Villa del Mar", 4.0f, "Valencia", "Exclusiva villa con vistas al mar", Arrays.asList(
        new Room("Villa", "Villa privada con piscina", 4, "Villa", 300.0f),
        new Room("Doble", "Habitación doble frente al mar", 3, "Doble", 250.0f),
        new Room("Suite", "Suite con terraza y jacuzzi", 5, "Suite", 400.0f),
        new Room("Individual", "Habitación económica para viajeros", 2, "Individual", 200.0f),
        new Room("Deluxe", "Habitación de lujo con vista panorámica", 6, "Deluxe", 500.0f)),
        300.0f, AccommodationType.APARTMENT)
    );
  }
}
