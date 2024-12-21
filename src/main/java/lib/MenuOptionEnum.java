package lib;

import java.util.HashMap;
import java.util.Map;

public enum MenuOptionEnum {
    SEARCH_ACCOMMODATION,
    SEARCH_ROOMS,
    RESERVE,
    MODIFY_RESERVATION,
    EXIT;

    private static final Map<Integer, MenuOptionEnum> menuOptionsMap = new HashMap<>();

    static {
        menuOptionsMap.put(1, SEARCH_ACCOMMODATION);
        menuOptionsMap.put(2, SEARCH_ROOMS);
        menuOptionsMap.put(3, RESERVE);
        menuOptionsMap.put(4, MODIFY_RESERVATION);
        menuOptionsMap.put(5, EXIT);
    }

    public static MenuOptionEnum getMenuOption(Integer choice) {
        return menuOptionsMap.get(choice);
    }
}