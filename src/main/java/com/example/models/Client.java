package com.example.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Client {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String nationality;
    private LocalTime arrivalTime;
    private String email;
    private LocalDate birthDate;

    public Client(
            String firstName,
            String lastName,
            String phoneNumber,
            String nacionality,
            LocalTime arrivalTime,
            String email
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.nationality = nacionality;

        this.arrivalTime = arrivalTime;
        this.email = email;
    }

    public boolean authenticateUser(String email, LocalDate birthDate) {
        return (email.equals(this.email) && birthDate.equals(this.birthDate));
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}