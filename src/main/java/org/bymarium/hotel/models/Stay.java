package org.bymarium.hotel.models;

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

    public Stay(Float basePrice, AccommodationType type) {
        this.basePrice = basePrice;
        this.type = type;
    }

    public Stay() {
    }

    @Override
    public String printAccommodation() {
        String result = "\n********** ALOJAMIENTO **********\n";

        result += "Ciudad: " + getCity() + "\n";
        result += "Tipo de alojamiento: " + getType() + "\n";
        result += "Nombre: " + getName() + "\n";
        result += "Descripción: " + getDescription() + "\n";
        result += "Calificación: " + getRate() + "\n";
        result += "Precio por noche: " + getBasePrice() + "\n";

    result += "\n********** HABITACIONES **********\n";
        int index = 1;
        for (Service service : getServices()) {
            result += "Habitación " + index + ". \n";
            result += service.printService();
            result += "----\n";
            index++;
        }

        return result;
    }

    public Float getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Float basePrice) {
        this.basePrice = basePrice;
    }

    public AccommodationType getType() {
        return type;
    }

    public void setType(AccommodationType type) {
        this.type = type;
    }
}
