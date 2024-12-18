public class RoomModel {
    private String title;
    private String description;
    private Integer quantity;
    private Double price;

    public RoomModel(String title, String description, Integer quantity, Double price) {
        this.title = title;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return title + '\n' +
                "Características:" + description + '\n' +
                "Precio por noche:" + price;
    }
}
