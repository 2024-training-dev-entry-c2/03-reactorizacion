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

    public void showInformation() {
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Nationality: " + nationality);
        System.out.println("Date of Birth: " + birthDate);
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }


}