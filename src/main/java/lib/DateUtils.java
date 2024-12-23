package lib;

import java.time.LocalDate;

public class DateUtils {

    public static Boolean isLastFiveDaysOfMonth(LocalDate start, LocalDate end) {
        LocalDate lastDayOfMonth = end.withDayOfMonth(end.lengthOfMonth());
        LocalDate firstDayOfLastFiveDays = lastDayOfMonth.minusDays(4);

        return !start.isBefore(firstDayOfLastFiveDays) && !end.isAfter(lastDayOfMonth);
    }

    public static Boolean isWithinRange(LocalDate start, LocalDate end, Integer fromDay, Integer toDay) {
        return isDayWithinRange(start, fromDay, toDay) && isDayWithinRange(end, fromDay, toDay);
    }

    private static Boolean isDayWithinRange(LocalDate date, Integer fromDay, Integer toDay) {
        Integer dayOfMonth = date.getDayOfMonth();
        return dayOfMonth >= fromDay && dayOfMonth <= toDay;
    }
}