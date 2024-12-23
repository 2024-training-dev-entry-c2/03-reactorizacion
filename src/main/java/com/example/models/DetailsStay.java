package com.example.models;

import com.example.constants.AccommodationType;

import java.time.LocalDate;
import java.util.List;

public class DetailsStay extends Details {
    private List<Service> services;
    private LocalDate endDate;
    private Integer roomsQuantity;

    public DetailsStay(
            LocalDate startDate,
            AccommodationType accommodationType,
            Integer childrenQuantity,
            Integer adultsQuantity,
            String city,
            LocalDate endDate,
            Integer roomsQuantity
    ) {
        super(startDate, accommodationType, childrenQuantity, adultsQuantity, city);
        this.endDate = endDate;
        this.roomsQuantity = roomsQuantity;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getRoomsQuantity() {
        return roomsQuantity;
    }

    public void setRoomsQuantity(Integer roomsQuantity) {
        this.roomsQuantity = roomsQuantity;
    }


}