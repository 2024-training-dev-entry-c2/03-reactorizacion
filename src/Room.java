public class Room {
    private String description;
    private String roomType;

    public Room(String description, String roomType) {
        this.description = description;
        this.roomType = roomType;
    }

    public String getDescription() {
        return description;
    }

    public String getRoomType() {
        return roomType;
    }

    @Override
    public String toString() {
        return String.format("Tipo de Habitación: %s, Descripción: %s", roomType, description);
    }
}