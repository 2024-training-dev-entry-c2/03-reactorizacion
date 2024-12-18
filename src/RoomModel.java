public class RoomModel {
    private String title;
    private String description;
    private Integer quantity;
    private Double pricePerNight;

    public RoomModel(String title, String description, Integer quantity, Double pricePerNight) {
        this.title = title;
        this.description = description;
        this.quantity = quantity;
        this.pricePerNight = pricePerNight;
    }

    @Override
    public String toString() {
        return title + '\n' +
                "Características:" + description + '\n' +
                "Precio por noche:" + pricePerNight;
    }

    public Double getPricePerNight() {
        return pricePerNight;
    }
}
