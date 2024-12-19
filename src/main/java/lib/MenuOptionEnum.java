package lib;

public enum MenuOptionEnum {
    SEARCH_ACCOMMODATION,
    SEARCH_ROOMS,
    RESERVE,
    MODIFY_RESERVATION,
    EXIT;

    public static MenuOptionEnum getMenuOption(Integer choice) {
        return switch (choice) {
            case 1 -> SEARCH_ACCOMMODATION;
            case 2 -> SEARCH_ROOMS;
            case 3 -> RESERVE;
            case 4 -> MODIFY_RESERVATION;
            case 5 -> EXIT;
            default -> null;
        };
    }
}