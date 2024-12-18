public interface ISunnyDay {
    PriceDetail calculateSunnyDayPrice(String startDate, int adultsQuantity, int childrenQuantity);

    String showSunnyDayAccommodation(String startDate, int adultsQuantity, int childrenQuantity);
}
