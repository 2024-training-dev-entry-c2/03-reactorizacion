public interface IReservation {

    void createReservation(ReservationData data);

    void updateReservation(String email, String birthDate);

    void deleteReservation(String email, String birthDate);

    void showReservations();
}