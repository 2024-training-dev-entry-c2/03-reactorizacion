package org.bymarium.hotel.models;

public enum AccommodationType {
    HOTEL("Hotel"),
    FARM("Finca"),
    APARTMENT("Apartamento"),
    DAYPASS("Día de Sol");

    private final String spanishName;

    AccommodationType(String spanishName) {
        this.spanishName = spanishName;
    }

    public static AccommodationType getAccommodationTypeByName(String accommodationType) {
        for (AccommodationType type : AccommodationType.values()) {
            if (type.getSpanishName().equalsIgnoreCase(accommodationType)) {
                return type;
            }
        }
        return null;
    }

    public String getSpanishName() {
        return this.spanishName;
    }
}