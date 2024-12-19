package lib;

public enum AccommodationType {
    HOTEL,
    APARTMENT,
    LAND,
    SUNNYDAY;

    public static AccommodationType getAccomodationType(int choice) {
        return switch (choice) {
            case 1 -> HOTEL;
            case 2 -> APARTMENT;
            case 3 -> LAND;
            case 4 -> SUNNYDAY;
            default -> null;
        };
    }
}