public class ReservationData {
    private Client client;
    private ReservationEnum lodging;
    private Room room;
    private Integer startDay;
    private Integer endDay;
    private Integer totalAdults;
    private Integer totalKids;
    private String email;

    public ReservationData(Client client, ReservationEnum lodging, Room room, Integer startDay, Integer endDay, Integer totalAdults, Integer totalKids) {
        this.client = client;
        this.lodging = lodging;
        this.room = room;
        this.startDay = startDay;
        this.endDay = endDay;
        this.totalAdults = totalAdults;
        this.totalKids = totalKids;
        this.email = client.getEmail();
    }

    public double calculateTotalPrice() {
        Integer basePrice = lodging.getPrice();
        Integer totalDays = endDay - startDay;
        double finalPrice = basePrice * totalDays;
        System.out.println(basePrice + "Precio base");
        System.out.println(totalDays + "Dias");

        if (startDay >= 27 && endDay <= 31) {
            finalPrice += finalPrice * 0.15;
            System.out.println(finalPrice + "Precio final");
        } else if (startDay >= 10 && endDay <= 15) {
            finalPrice += finalPrice * 0.10;
            System.out.println(finalPrice + "Precio final");
        } else if (startDay >= 5 && endDay <= 10) {
            finalPrice -= finalPrice * 0.08;
            System.out.println(finalPrice + "Precio final");
        }


        return finalPrice;
    }

    public Client getClient() {
        return client;
    }

    public ReservationEnum getLodging() {
        return lodging;
    }

    public Room getRoom() {
        return room;
    }

    public Integer getStartDay() {
        return startDay;
    }

    public Integer getEndDay() {
        return endDay;
    }

    public Integer getTotalAdults() {
        return totalAdults;
    }

    public Integer getTotalKids() {
        return totalKids;
    }

    public Room setRoom(Room newRoom) {
        return room;
    }


    @Override
    public String toString() {
        if (client == null) {
            return "Cliente: null, Datos de alojamiento incompletos";
        }
        return String.format(
                "Cliente: %s %s, Alojamiento: %s, Habitación: %s, Fecha: %s al %s, Total de adultos: %d, Total de niños: %d",
                client.getName(), client.getLastName(),
                lodging != null ? lodging.getName() : "N/A",
                room != null ? room.getDescription() : "N/A",
                startDay, endDay,
                totalAdults, totalKids
        );
    }
}