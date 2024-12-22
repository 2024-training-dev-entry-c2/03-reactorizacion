package lib;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
    validateDates(startDay, endDay);
    Integer totalDays = calculateTotalDays(startDay, endDay);
    Double baseTotal = calculateBaseTotalPrice(basePrice, totalDays, numberOfRooms);
    Double adjustment = getAdjustmentFactor(startDay, endDay, baseTotal);
    return baseTotal + adjustment;
  }

  private static void validateDates(LocalDate startDay, LocalDate endDay) {
    validateNotNullDates(startDay, endDay);
    validateStartBeforeEnd(startDay, endDay);
  }

  private static void validateNotNullDates(LocalDate startDay, LocalDate endDay) {
    validateNotNull(startDay, "La fecha de inicio no puede ser nula");
    validateNotNull(endDay, "La fecha de fin no puede ser nula");
  }

  private static void validateNotNull(Object date, String errorMessage) {
    if (date == null) {
      throw new IllegalArgumentException(errorMessage);
    }
  }

  private static void validateStartBeforeEnd(LocalDate startDay, LocalDate endDay) {
    if (startDay.isAfter(endDay)) {
      throw new IllegalArgumentException("La fecha de inicio debe ser anterior o igual a la fecha de fin");
    }
  }

  private static int calculateTotalDays(LocalDate startDay, LocalDate endDay) {
    Integer totalDays = (int) ChronoUnit.DAYS.between(startDay, endDay);
    return totalDays == 0 ? 1 : totalDays;
  }

  private static double calculateBaseTotalPrice(Double basePrice, Integer totalDays, Integer numberOfRooms) {
    return basePrice * numberOfRooms * totalDays;
  }

  private static Double getAdjustmentFactor(LocalDate startDay, LocalDate endDay, Double totalPrice) {
    return adjustmentFactors.entrySet().stream()
      .filter(entry -> entry.getKey().test(startDay, endDay))
      .map(Map.Entry::getValue)
      .findFirst()
      .orElse(0.0) * totalPrice;
  }
}