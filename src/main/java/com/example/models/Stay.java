package com.example.models;

import com.example.constants.AccommodationType;

import java.util.List;

public class Stay extends Accommodation {
  private Float basePrice;
  private AccommodationType type;

  public Stay(
          String name,
          Float rate,
          String city,
          String description,
          List<Service> services,
          Float basePrice,
          AccommodationType type
  ) {
    super(name, rate, city, description, services);
    this.basePrice = basePrice;
    this.type = type;
  }

  @Override
  public void describe() {
    System.out.println(
            "Alojamiento: " + this.getName() +
                    "\n Calificación: " + this.getRate() +
                    "\n Descripción: " + this.getDescription() +
                    "\n Precio base: " + this.getBasePrice() +
                    "\n Tipo: " + this.getType() +
                    "\n Servicios:"
    );
    for (Service service : this.getServices()) {
      service.describe();
    }
  }

  public Float getBasePrice() {
    return basePrice;
  }

  public AccommodationType getType() {
    return type;
  }
}