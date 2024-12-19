import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class ControllerImplementation implements  IController{
    private ArrayList<Hotel> hotels = new ArrayList<>();
    private ArrayList<Apartment> apartments = new ArrayList<>();
    private ArrayList<Farm> farms = new ArrayList<>();
    private ArrayList<Booking> bookings = new ArrayList<>();
    private ArrayList<Accommodation> selectedAccommodations;


    public ControllerImplementation() {}


    public void loadData(){
        ArrayList<RoomModel> roomModels1 = new ArrayList<>(Arrays.asList(
                new RoomModel("Standard", "Cama doble, baño privado, TV, escritorio, internet básico", 10, 180000.0, 0),
                new RoomModel("Superior", "Cama king size, baño más grande, adicionales (bata, pantuflas, minibar), vista parcial", 8, 250000.0, 1),
                new RoomModel("Deluxe", "Cama king size, sala de estar independiente, baño de lujo con jacuzzi, vista panorámica", 5, 350000.0, 2),
                new RoomModel("Junior Suite", "Combinación de dormitorio y pequeña sala de estar, cama king size, baño completo, sofá cama", 2, 500000.0, 3),
                new RoomModel("Presidential Suite", "Amplia sala, comedor, cocineta, baño de lujo, servicios personalizados (mayordomo, chef privado)", 1, 1200000.0, 4)
        ));
        Hotel hotel1 = new Hotel("Hotel Estelar", "Manizales", 4.6F, roomModels1,0);
        hotels.add(hotel1);
        ArrayList<RoomModel> roomModels2 = new ArrayList<>(Arrays.asList(
                new RoomModel("Econónica", "Cama sencilla, baño compartido, TV pequeña, internet básico", 15, 120000.0, 0),
                new RoomModel("Ejecutiva", "Cama queen size, baño privado, escritorio amplio, internet de alta velocidad", 15, 200000.0, 1),
                new RoomModel("Familiar", "Dos camas dobles, baño completo, área de estar, TV grande, vista al jardín", 10, 300000.0, 2),
                new RoomModel("Penthouse", "Cama king size, sala de estar de lujo, comedor privado, jacuzzi, terraza con vista al mar", 3, 700000.0, 3),
                new RoomModel("Imperial", "Dormitorio principal, sala de estar, comedor, cocineta, servicios VIP (chofer, chef, seguridad)", 1, 1500000.0, 4)
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
    }

    private List<Accommodation> getAllAccomodations() {
        List<Accommodation> all = new ArrayList<>();
        all.addAll(apartments);
        all.addAll(farms);
        all.addAll(hotels);
        return all;
    }

    public void filterAccommodations(Booking booking){
        for(Accommodation acc:getAllAccomodations()){
            if(booking.getCity().equals(acc.getCity())){
                if (booking.getType().equals("Hotel") && acc instanceof Hotel){
                    selectedAccommodations.add(acc);
                } else if (booking.getType().equals("Farm") && acc instanceof Farm) {
                    Farm farm = (Farm) acc;
                    if(booking.getRoomQuantity() == farm.getRoomQuantity() && thereIsAccommodationAvailable( farm.getName(), booking.getStart(), booking.getEnd())){
                        selectedAccommodations.add(farm);
                    }
                }else if (booking.getType().equals("Apartment") && acc instanceof Apartment) {
                    Apartment apto = (Apartment) acc;
                    if(booking.getRoomQuantity() == apto.getRoomQuantity() && thereIsAccommodationAvailable( apto.getName(), booking.getStart(), booking.getEnd())){
                        selectedAccommodations.add(apto);
                    }
                }else if (booking.getType().equals("Sunny Day")){
                    Integer bookingPeople = booking.getAdultsQuantity() + booking.getChildrenQuantity();
                    if(acc instanceof Hotel){
                        Hotel hotel = (Hotel) acc;
                        if(hotel.getSunnyDay()!= null && thereIsSunnyDayAvailable(bookingPeople, hotel, booking.getStart())){
                            selectedAccommodations.add(hotel);
                        }
                    }
                    else if(acc instanceof Farm){
                        Farm farm = (Farm) acc;
                        if(farm.getSunnyDay()!= null && thereIsSunnyDayAvailable(bookingPeople, farm, booking.getStart()){
                            selectedAccommodations.add(farm);
                        }
                    }

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

    public Boolean dateIntercept(Integer start, Integer end, Integer bookingStart, Integer bookingEnd) {
        if (start > end || bookingStart > bookingEnd) {
            throw new IllegalArgumentException("Los valores de inicio deben ser menores o iguales a los de fin");
        }
        if ((start > bookingEnd && end > bookingEnd) || (start < bookingStart && end < bookingStart)) {
            return false;
        }
        return true;
    }

    public Hotel getHotel(String name){
        for(Hotel hotel : hotels){
            if(hotel.getName().equals(name)){
                return hotel;
            }
        }
        return null;
    }

    public ArrayList<Integer> confirmRooms(Hotel hotel, Booking newBooking){
        ArrayList<Integer> availableRooms = new ArrayList<>();
        for(RoomModel model: hotel.getRoomModels()){
            availableRooms.add(model.getQuantity());
        }
        for (Booking booking : bookings){
            if(booking.getAccommodation().equals(hotel.getName())){
                if(dateIntercept(newBooking.getStart(), newBooking.getEnd(), booking.getStart(), booking.getEnd())){
                    Integer index = booking.getRoomModel().getIndex();
                    availableRooms.set( index, availableRooms.get(index) - booking.getRoomQuantity() );
                }
            }
        }
        return availableRooms;
    }

    public Boolean reserve(Customer customer, String time, Booking newBooking) {
        newBooking.setCustomer(customer);
        try {
            LocalTime arrivalTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
            newBooking.setArrivalTime(arrivalTime);
        } catch (DateTimeParseException e) {
            System.out.println("Formato de hora inválido: " + e.getMessage());
            return false;
        }
        Boolean added = bookings.add(newBooking);
        return added && newBooking.getCustomer() != null && newBooking.getCustomer().equals(customer);
    }


    public ArrayList<Booking> validateUser(String email, String birthDate){
        ArrayList<Booking> validBookings = new ArrayList<>();
        for(Booking booking: bookings){
            if(booking.getCustomer().validateCustomer(email, LocalDate.parse(birthDate))){
                validBookings.add(booking);
            }
        }
        return validBookings;
    }


    public ArrayList<Accommodation> getSelectedAccommodations() {
        return selectedAccommodations;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }
}
