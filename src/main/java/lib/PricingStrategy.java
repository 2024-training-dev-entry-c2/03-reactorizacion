package lib;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiPredicate;

import static lib.DateUtils.isWithinRange;

public class PricingStrategy {

  static final Double LAST_FIVE_DAYS_INCREASE = 0.15;
  static final Double MID_MONTH_INCREASE = 0.10;
  static final Double EARLY_MONTH_DISCOUNT = 0.08;

  private static final Map<BiPredicate<LocalDate, LocalDate>, Double> adjustmentFactors = new HashMap<>();

  static {
    adjustmentFactors.put(DateUtils::isLastFiveDaysOfMonth, LAST_FIVE_DAYS_INCREASE);
    adjustmentFactors.put((start, end) -> isWithinRange(start, end, 10, 15), MID_MONTH_INCREASE);
    adjustmentFactors.put((start, end) -> isWithinRange(start, end, 5, 10), -EARLY_MONTH_DISCOUNT);
  }

  public static Double calculateTotalPrice(Double basePrice, LocalDate startDay, LocalDate endDay, Integer numberOfRooms) {
    Integer totalDays = endDay.getDayOfMonth() - startDay.getDayOfMonth();
    if (totalDays <0) {
      throw new IllegalArgumentException("Debe seleccionar una fecha de inicio y fin válida");
    }else if (totalDays == 0) {
      totalDays = 1;
    }
    Double totalPrice = basePrice * numberOfRooms * totalDays;
    Double adjustment = getAdjustmentFactor(startDay, endDay, totalPrice);
    return totalPrice + adjustment;
  }

  private static Double getAdjustmentFactor(LocalDate startDay, LocalDate endDay, Double totalPrice) {
    return adjustmentFactors.entrySet().stream()
      .filter(entry -> entry.getKey().test(startDay, endDay))
      .map(Map.Entry::getValue)
      .findFirst()
      .orElse(0.0) * totalPrice;
  }
}