public class SunnyDay extends Lodging{

    private String avaliableActivities;
    private Boolean hasBreakFast;
    private Boolean hasLunch;

    public SunnyDay(String name, String location, String type, Double rating, String rooms) {
        super(name, location, type, rating, rooms);



    }


    @Override
    public void decorateRoom() {

    }

    @Override
    public void calculateTotalPrice() {
        super.calculateTotalPrice();
    }
}
