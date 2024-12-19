import java.util.ArrayList;

public class SunnyDay {
    private Double pricePerson;
    private Integer peopleQuantity;
    private ArrayList<String> activities;
    private Boolean includesLunch;

    public SunnyDay(Double pricePerson, Integer peopleQuantity, ArrayList<String> activities, Boolean includesLunch) {
        this.pricePerson = pricePerson;
        this.peopleQuantity = peopleQuantity;
        this.activities = activities;
        this.includesLunch = includesLunch;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Actividades: \n");
        for (String element : this.activities) {
            sb.append("- ").append(element).append("\n");
        }
        return  sb.toString() +
                "Incluye almuerzo: " + (this.includesLunch ? "sí" : "no") + '\n' +
                "Precio por persona: " + this.pricePerson + '\n';
    }

    public Double getPricePerson() {
        return pricePerson;
    }

    public Integer getPeopleQuantity() {
        return peopleQuantity;
    }
}
