package lib;

import java.time.LocalDate;

public class DateUtils {

    public static Boolean isLastFiveDaysOfMonth(LocalDate date) {
        Integer lastDayOfMonth = date.lengthOfMonth();
        return date.getDayOfMonth() > lastDayOfMonth - 5;
    }

    public static Boolean isWithinRange(LocalDate start, LocalDate end, Integer fromDay, Integer toDay) {
        return (start.getDayOfMonth() >= fromDay && start.getDayOfMonth() <= toDay) &&
                (end.getDayOfMonth() >= fromDay && end.getDayOfMonth() <= toDay);
    }
}