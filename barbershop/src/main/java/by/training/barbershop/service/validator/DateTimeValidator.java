package by.training.barbershop.service.validator;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeParseException;

public class DateTimeValidator {
    private DateTimeValidator() {
    }

    /**
     * Validates if date representation is valid
     *
     * @param dateString date line
     * @return if <code>dateString</code> is valid date representation
     */
    public static boolean isValidDate(String dateString) {
        if (dateString == null) {
            return false;
        }
        try {
            LocalDate.parse(dateString);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    /**
     * Validates if time representation is valid
     *
     * @param timeString time line
     * @return if <code>timeString</code> is valid time representation
     */
    public static boolean isValidTime(String timeString) {
        if (timeString == null) {
            return false;
        }
        try {
            LocalTime.parse(timeString);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    public static boolean isValidDateTime(LocalDateTime localDateTime) {
        LocalDateTime now = LocalDateTime.now();
        return localDateTime.isAfter(now) && localDateTime.getHour() > 7
                && localDateTime.getHour() < 21;
    }
}
