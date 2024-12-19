import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReservationImplementation implements IReservation {
    private List<Client> clients;
    private Map<String, ReservationData> reservations;
    private Scanner scanner;

    public ReservationImplementation(Scanner scanner) {
        this.clients = new ArrayList<>();
        this.reservations = new HashMap<>();
        this.scanner = scanner;
    }

    @Override
    public void createReservation(ReservationData data) {
        String email = data.getClient().getEmail();



        ReservationEnum lodging = findLodging(data.getLodging().getName());
        if (lodging == null) {
            System.out.println("El alojamiento no existe.");
            return;
        }


        Room selectedRoom = data.getRoom();
        if (selectedRoom == null) {
            System.out.println("No se seleccionó ninguna habitación.");
            return;
        }

        reservations.put(email, data);
        lodging.getRooms().remove(selectedRoom);
        System.out.println("Reserva creada exitosamente para " + data.getClient().getName());

    }

    @Override
    public void updateReservation(String email, String birthDate) {
        if (!reservations.containsKey(email)) {
            System.out.println("No se encontró ninguna reserva para el cliente con email: " + email);
            return;
        }

        System.out.println("Reserva actualizada exitosamente.");
    }

    @Override
    public void deleteReservation(String email, String birthDate) {
        if (!reservations.containsKey(email)) {
            System.out.println("No se encontró ninguna reserva para el cliente con email: " + email);
            return;
        }

        ReservationData data = reservations.get(email);
        ReservationEnum lodging = findLodging(data.getLodging().getName());
        if (lodging != null) {
            lodging.getRooms().add(data.getRoom());
        }

        reservations.remove(email);
        System.out.println("Reserva eliminada exitosamente.");
    }

    @Override
    public void showReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No hay reservas registradas.");
            return;
        }

        for (ReservationData data : reservations.values()) {
            System.out.println("-----------------------------------");
            System.out.println("Cliente: " + data.getClient().getName() + " " + data.getClient().getLastName());
            System.out.println("Alojamiento: " + data.getLodging().getName());
            System.out.println("Habitación: " + data.getRoom().getDescription());
            System.out.println("Total de adultos: " + data.getTotalAdults());
            System.out.println("Total de niños: " + data.getTotalKids());
            System.out.println("Email: " + data.getClient().getEmail());
            System.out.println("Nacionalidad: " + data.getClient().getNationality());
            System.out.println("Teléfono: " + data.getClient().getPhone());
            System.out.println("Fecha: " + data.getStartDay() + " al " + data.getEndDay());
            System.out.println("Hora de llegada: " + data.getLodging().getPrice() );
            System.out.println("-----------------------------------");
        }
    }

    public List<ReservationEnum> searchAccommodations(String city, String type) {
        return Stream.of(ReservationEnum.values())
                .filter(a -> a.getLocation().equalsIgnoreCase(city) && a.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }

    public void addClient(Client newClient) {
        clients.add(newClient);
    }

    private ReservationEnum findLodging(String name) {
        return List.of(ReservationEnum.values()).stream()
                .filter(l -> l.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);

    }
}