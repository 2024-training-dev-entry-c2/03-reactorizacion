import java.time.LocalDate;
import java.util.*;

public class ControllerImplementation implements  IController{
    private ArrayList<Hotel> hotels = new ArrayList<>();
    private ArrayList<Apartment> apartments = new ArrayList<>();
    private ArrayList<Farm> farms = new ArrayList<>();
    private ArrayList<Booking> bookings = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Accommodation> selectedAccommodations;


    public ControllerImplementation() {}


    public void loadData(){
        ArrayList<RoomModel> roomModels1 = new ArrayList<>(Arrays.asList(
                new RoomModel("Standard", "Cama doble, baño privado, TV, escritorio, internet básico", 10, 180000.0),
                new RoomModel("Superior", "Cama king size, baño más grande, adicionales (bata, pantuflas, minibar), vista parcial", 8, 250000.0),
                new RoomModel("Deluxe", "Cama king size, sala de estar independiente, baño de lujo con jacuzzi, vista panorámica", 5, 350000.0),
                new RoomModel("Junior Suite", "Combinación de dormitorio y pequeña sala de estar, cama king size, baño completo, sofá cama", 2, 50000.0),
                new RoomModel("Presidential Suite", "Amplia sala, comedor, cocineta, baño de lujo, servicios personalizados (mayordomo, chef privado)", 1, 1000000.0)
        ));
        Hotel hotel1 = new Hotel("Hotel Estelar", "Manizales", 4.6F, roomModels1,0);
        hotels.add(hotel1);
        ArrayList<RoomModel> roomModels2 = new ArrayList<>(Arrays.asList(
                new RoomModel("Econónica", "Cama sencilla, baño compartido, TV pequeña, internet básico", 15, 120000.0),
                new RoomModel("Ejecutiva", "Cama queen size, baño privado, escritorio amplio, internet de alta velocidad", 15, 200000.0),
                new RoomModel("Familiar", "Dos camas dobles, baño completo, área de estar, TV grande, vista al jardín", 10, 300000.0),
                new RoomModel("Penthouse", "Cama king size, sala de estar de lujo, comedor privado, jacuzzi, terraza con vista al mar", 3, 700000.0),
                new RoomModel("Imperial", "Dormitorio principal, sala de estar, comedor, cocineta, servicios VIP (chofer, chef, seguridad)", 1, 1500000.0)
        ));
        ArrayList<String> activities1 = new ArrayList<>(Arrays.asList("Piscina", "Spa", "Yoga"));
        SunnyDay sunnyDay1 = new SunnyDay(90000.0, 30,activities1, true);
        Hotel hotel2 = new Hotel("Hotel Carretero", "Manizales", 4.8F, roomModels2,0,sunnyDay1);
        hotels.add(hotel2);
        Farm farm1 = new Farm("Granja Paraiso", "Manizales", 4.6F,320000.0, "Jardin, Piscina y Terraza", 3);
        farms.add(farm1);
        ArrayList<String> activities2 = new ArrayList<>(Arrays.asList("Cabalgata", "Eco paseo", "Piscina"));
        SunnyDay sunnyDay2 = new SunnyDay(110000.0, 25,activities2, true);
        Farm farm2 = new Farm("Finca Santa María", "Manizales", 4.9F,360000.0, "Cocina, 2 baños, jacuzzi, Piscina", 3,sunnyDay2);
        farms.add(farm2);
        Apartment apto1 = new Apartment("Apartamento en Milan zona G","Manizales", 4.5F, 250000.0,"Sala, Cocina, WiFi gratis, 1 cama doble y 1 cama sencilla",2);
        apartments.add(apto1);
        Apartment apto2 = new Apartment("Apartamento en Palermo","Manizales", 4.7F, 280000.0,"Cocina, 2 baños, 2 camas dobles",2);
        apartments.add(apto2);

        Booking booking1 = new Booking(2,4,2,2,3,"Farm","Manizales");
        booking1.setAccommodation("Finca Santa María");
        bookings.add(booking1);
    }

    public void filterAccommodations(Booking booking){
        selectedAccommodations = new ArrayList<>();
        if(booking.getType().equals("Apartment")){
            for(Apartment apto:apartments){
                if(booking.getCity().equals(apto.getCity()) && booking.getRoomQuantity() == apto.getRoomQuantity() && thereIsAccommodationAvailable( apto.getName(), booking.getStart(), booking.getEnd()) ){
                    selectedAccommodations.add(apto);
                }
            }
        }
        else if(booking.getType().equals("Farm")){
            for(Farm farm:farms){
                if(booking.getCity().equals(farm.getCity()) && booking.getRoomQuantity() == farm.getRoomQuantity() && thereIsAccommodationAvailable( farm.getName(), booking.getStart(), booking.getEnd()) ){
                    selectedAccommodations.add(farm);
                }
            }
        }
        else if (booking.getType().equals("Hotel")) {
            for(Hotel hotel:hotels){
                if(booking.getCity().equals(hotel.getCity())){
                    selectedAccommodations.add(hotel);
                }
            }
        }
        else if (booking.getType().equals("Sunny Day")) {
            Integer bookingPeople = booking.getAdultsQuantity() + booking.getChildrenQuantity();
            for(Hotel hotel:hotels){
                if(booking.getCity().equals(hotel.getCity())  && hotel.getSunnyDay()!= null && thereIsSunnyDayAvailable(bookingPeople, hotel, booking.getStart()) ){
                    selectedAccommodations.add(hotel);
                }
            }
            for(Farm farm:farms){
                if(booking.getCity().equals(farm.getCity()) && farm.getSunnyDay()!= null && thereIsSunnyDayAvailable(bookingPeople, farm, booking.getStart()) ){
                    selectedAccommodations.add(farm);
                }
            }
        }
    }

    public boolean thereIsAccommodationAvailable(String name , Integer start, Integer end){
        for (Booking booking : bookings){
            if(booking.getAccommodation().equals(name)){
                if(dateIntercept(start, end, booking.getStart(), booking.getEnd())){
                    return false;
                }
            }
        }
        return true;
    }

    public Boolean thereIsSunnyDayAvailable(Integer bookingPeople, Accommodation acc, Integer start){
        Integer peopleQuantity = 0;
        if (acc instanceof Hotel){
            Hotel hotel = (Hotel) acc;
            peopleQuantity = hotel.getSunnyDay().getPeopleQuantity();
        } else if (acc instanceof Farm) {
            Farm farm = (Farm) acc;
            peopleQuantity = farm.getSunnyDay().getPeopleQuantity();
        }
        for (Booking booking : bookings){
            if( booking.getAccommodation().equals(acc.getName()) && booking.getType().equals("Sunny Day")){
                if(booking.getStart().equals(start)){
                    peopleQuantity-=booking.getAdultsQuantity()+ booking.getChildrenQuantity();
                }
            }
        }
        if(peopleQuantity<bookingPeople){
            return false;
        }
        return true;
    }

    public boolean dateIntercept(Integer start, Integer end, Integer bookingStart, Integer bookingEnd) {
        if (start > end || bookingStart > bookingEnd) {
            throw new IllegalArgumentException("Los valores de inicio deben ser menores o iguales a los de fin");
        }
        if ((start > bookingEnd && end > bookingEnd) || (start < bookingStart && end < bookingStart)) {
            return false;
        }
        return true;
    }
/**
    public int[] getAvailableRooms(String name , String startDate, String endDate, int[] rooms){
        int[] availableRooms = rooms.clone();

        for (Map<String, Object> booking : bookings){
            if(booking.get("accommodation").equals(name)){
                if(dateIntercept(startDate, endDate, (String) booking.get("startDate"), (String) booking.get("endDate"))){
                    int[] roomQuantity = (int[]) booking.get("roomQuantity");
                    for (int i = 0; i < availableRooms.length; i++) {
                        availableRooms[i] -= roomQuantity[i];
                        if (availableRooms[i] < 0) {
                            availableRooms[i] = 0;
                        }
                    }
                }
            }
        }

        return availableRooms;
    }

    public Map<String, Object> confirmRooms(String name, String startDate, String endDate, int adultsQuantity, int childrenQuantity, int totalRooms){
        Map<String, Object> rooms = new HashMap<>();
        for(Accommodation acc : accommodations){
            if(acc.getName().equals(name)){
                if (acc instanceof Hotel) {
                    Hotel hotel = (Hotel) acc; // Cast to Hotel
                    int[] availableRooms = getAvailableRooms(name, startDate, endDate, hotel.getRooms());
                    int[] pricePerNight = hotel.getPricePerNight();
                    rooms.put("availableRooms", availableRooms);
                    rooms.put("pricePerNight", pricePerNight);
                    break;
                }
            }
        }
        return rooms;
    }

    public boolean reserve(String firstName, String lastName, String email, String nationality, String phone, String birthDate, String hour){

        for(Map<String, String> user : users){
            if(user.get("email").equals(email)){
                return false;
            }
        }

        users.add(new HashMap<>(Map.of(
                "firstName", firstName,
                "lastName", lastName,
                "email", email,
                "nationality", nationality,
                "phone", phone,
                "birthDate", birthDate,
                "hour", hour
        )));

        newBooking.put("userEmail", email);
        Map<String, Object> bookingCopy = new HashMap<>();
        for (Map.Entry<String, Object> entry : newBooking.entrySet()) {
            Object valor = entry.getValue();
            bookingCopy.put(entry.getKey(), valor);
        }
        bookings.add(bookingCopy);
        canReserve = false;
        return true;
    }

    public boolean isValidUser(String email, String birthDate){
        int index = 0;
        for(Map<String, String> user: users){
            if(user.get("email").equals(email)){
                if(user.get("birthDate").equals(birthDate)){
                    userIndex = index;
                    return true;
                }
                return false;
            }
            index++;
        }
        return false;
    }

    public Map<String, Object> getBooking(String email){
        int index = 0;
        for(Map<String, Object> booking: bookings){
            if(booking.get("userEmail").equals(email) ){
                bookingIndex = index;
                return booking;
            }
            index++;
        }
        return null;
    }
 **/
    public ArrayList<Accommodation> getSelectedAccommodations() {
        return selectedAccommodations;
    }

}
