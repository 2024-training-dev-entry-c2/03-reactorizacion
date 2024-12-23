package org.example.models;

import java.util.List;

public class Apartament extends Accommodation {
    private Double price;
    private Integer numberRooms;

    public Apartament(
      String type,
      String name,
      String city,
      String description,
      Double rating,
      Double price,
      Integer numberRooms
    ) {
        super(type, name, city, description, rating);
        this.price = price;
        this.numberRooms = numberRooms;
    }

    @Override
    public String viewAccommodation() {
        return String.format(
          """
          *************************************************************
          ***                 Apartamentos Disponibles                ***
          *************************************************************
      
           Nombre:              %s
           Ciudad:              %s
           Descripción:         %s
           Calificación:         %.1f
          💲 Precio por noche:    $%.2f
           Habitaciones:        %d disponibles
      
          *************************************************************
          %s
          *************************************************************
          """,
          this.getName(),
          this.getCity(),
          this.getDescription(),
          this.getRating()
        );

    }

    public Double getPrice() {
        return price;
    }

    public Integer getNumberRooms() {
        return numberRooms;
    }
}
