package org.example.models;

import java.util.List;

public abstract class Accommodation {

    private String type;
    private String name;
    private String city;
    private String description;
    private Double rating;


    public Accommodation(
            String type,
            String name,
            String city,
            String description,
            Double rating
          )

    {
        this.type = type;
        this.name = name;
        this.city = city;
        this.description = description;
        this.rating = rating;
    }

    public abstract String viewAccommodation();

    public String getType() {return type; }
    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getDescription() {
        return description;
    }

    public Double getRating() {
        return rating;
    }


}





