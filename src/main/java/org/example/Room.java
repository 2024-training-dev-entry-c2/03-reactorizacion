package org.example;

/**
 * @author Manuel Aguilera / @aguileradev
 */
public class Room {
    private Integer id;
    private String name;
    private String description;
    private Double pricePerNight;
    private Integer avaibility;
    private Integer adultCapacity;
    private Integer childCapacity;


    public Room(Integer id, String name, String description, Double pricePerNight, Integer avaibility, Integer adultCapacity, Integer childCapacity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.pricePerNight = pricePerNight;
        this.avaibility = avaibility;
        this.adultCapacity = adultCapacity;
        this.childCapacity = childCapacity;
    }

    public Room(){}

    public Integer getAdultCapacity() {
        return adultCapacity;
    }


    public Integer getChildCapacity() {
        return childCapacity;
    }

    public Integer getAvaibility() {
        return avaibility;
    }

    public void setAvaibility(Integer avaibility) {
        this.avaibility = avaibility;
    }



    @Override
    public String toString() {
        return "Habitacion: " + id + "\nNombre: " + name + "\nDescripcion: " + description + "\nPrecio por noche: " + pricePerNight + "\nDisponibilidad: " + avaibility + "\n";
    }
}
