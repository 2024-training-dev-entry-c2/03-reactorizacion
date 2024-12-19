package org.example;

import java.time.LocalDate;

/**
 * @author Manuel Aguilera / @aguileradev
 */
public class User {
    private String name;
    private String lastName;
    private String email;
    private String nationality;
    private String phoneNumber;
    private LocalDate birthDate;


    public User(String name, String lastName, String email, String nationality, String phoneNumber, LocalDate birthDate) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.nationality = nationality;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
    }

    public User() {}

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }



    @Override
    public String toString() {
        return "Persona: " + name + " " + lastName + "\nCorreo electronico: " + email + "\nNacionalidad: " + nationality + "\nTelefono: " + phoneNumber + "\nFecha de nacimiento: " + birthDate;
    }
}
