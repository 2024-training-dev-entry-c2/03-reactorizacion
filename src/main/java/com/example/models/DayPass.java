package com.example.models;

import java.util.List;

public class DayPass extends Accommodation {
    private Float personPrice;

    public DayPass(
            String name,
            Float rate,
            String city,
            String description,
            List<Service> services,
            Float personPrice
    ) {
        super(name, rate, city, description, services);
        this.personPrice = personPrice;
    }

    @Override
    public void describe() {
        System.out.println(
                "Stay: " + this.getName() +
                        "\nRate: " + this.getRate() +
                        "\nCity: " + this.getCity() +
                        "\nDescription: " + this.getDescription() +
                        "\nPrecio por persona: " + this.getPersonPrice() +
                        "\nServicios incluídos:"
        );
        for (Service service : this.getServices()) {
            System.out.println("  - " + service.getName() + ": " + service.getDescription());
        }
    }

    public Float getPersonPrice() {
        return personPrice;
    }

    public void setPersonPrice(Float personPrice) {
        this.personPrice = personPrice;
    }
}