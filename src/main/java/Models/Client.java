package Models;

import java.time.LocalDate;

public class Client {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String nationality;
    private LocalDate birthDate;

    public Client(String firstName, String lastName, String email, String phoneNumber, String nationality, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.nationality = nationality;
        this.birthDate = birthDate;
    }

    public String getInformation() {
        return String.format("Name: %s %s%nEmail: %s%nPhone Number: %s%nNationality: %s%nDate of Birth: %s",
                firstName, lastName, email, phoneNumber, nationality, birthDate);
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

}