public class RoomModel {
    private String title;
    private String description;
    private Integer quantity;
    private Double pricePerNight;
    private Integer index;

    public RoomModel(String title, String description, Integer quantity, Double pricePerNight, Integer index) {
        this.title = title;
        this.description = description;
        this.quantity = quantity;
        this.pricePerNight = pricePerNight;
        this.index = index;
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

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getIndex() {
        return index;
    }

    public String getTitle() {
        return title;
    }
}
