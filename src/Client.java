public class Client {
    private String name;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String nationality;
    private String dateOfbirth;
    private String reservationData;

    public Client(String name, String lastName, String email, String phoneNumber, String nationality, String dateBirth, String reservationData) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.nationality = nationality;
        this.dateOfbirth = dateBirth;
        this.reservationData = reservationData;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getDateOfbirth() {
        return dateOfbirth;
    }

    public void setDateOfbirth(String dateOfbirth) {
        this.dateOfbirth = dateOfbirth;
    }

    public String getReservationData() {
        return reservationData;
    }

    public void setReservationData(String reservationData) {
        this.reservationData = reservationData;
    }

    public String getPhone() {
        return phoneNumber;
    }
}
