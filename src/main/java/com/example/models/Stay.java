package com.example.models;

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
                "Stay: " + this.getName() +
                        "\nRate: " + this.getRate() +
                        "\nCity: " + this.getCity() +
                        "\nDescription: " + this.getDescription() +
                        "\nPrecio base: " + this.getBasePrice() +
                        "\nType: " + this.getType() +
                        "\nHabitaciones:"
        );
        for (Service service : this.getServices()) {
            System.out.println("  - " + service.getName() + ": " + service.getDescription());
        }
    }

    public Float getBasePrice() {
        return basePrice;
    }

    public AccommodationType getType() {
        return type;
    }
}