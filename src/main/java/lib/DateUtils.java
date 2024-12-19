package lib;

import java.time.LocalDate;

public class DateUtils {

    public static boolean isLastFiveDaysOfMonth(LocalDate date) {
        Integer lastDayOfMonth = date.lengthOfMonth();
        return date.getDayOfMonth() > lastDayOfMonth - 5;
    }

    public static boolean isWithinRange(LocalDate start, LocalDate end, int fromDay, int toDay) {
        return (start.getDayOfMonth() >= fromDay && start.getDayOfMonth() <= toDay) &&
                (end.getDayOfMonth() >= fromDay && end.getDayOfMonth() <= toDay);
    }

    public static boolean isWithinDayRange(LocalDate day, int fromDay, int toDay) {
        Integer dayOfMonth = day.getDayOfMonth();
        return dayOfMonth >= fromDay && dayOfMonth <= toDay;
    }
}