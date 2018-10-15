package seedu.address.model.calendarevent;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import java.time.DateTimeException;
import java.time.LocalDateTime;

/**
 * Represents a Calendar Event's datetime fields in the scheduler.
 * Guarantees: immutable; is valid as declared in {@link #isValidDateTime(int, int, int, int, int)}
 */
public class DateTime {

    public static final String MESSAGE_DATETIME_CONSTRAINTS =
            "The valid input will be year-month-localDateTime hour:minute";
    public final LocalDateTime localDateTime;
    public final int year;
    public final int month;
    public final int day;
    public final int hour;
    public final int minute;
    private LocalDateTime date;

    /**
     * Constructs a {@code DateTime}
     * Wrapper class for LocalDateTime
     *
     * @param dateTime   A valid dateTime
     */
    public DateTime(LocalDateTime dateTime) throws DateTimeException {
        this.localDateTime = dateTime;
        this.year = localDateTime.getYear();
        this.month = localDateTime.getMonthValue();
        this.day = localDateTime.getDayOfMonth();
        this.hour = localDateTime.getHour();
        this.minute = localDateTime.getMinute();
        requireAllNonNull(year, month, day, hour, minute);
        if (year <= 0) {
            throw new DateTimeException("Invalid year");
        }
    }

    public int getYear() {
        return date.getYear();
    }

    public int getMonth() {
        return date.getMonthValue();
    }

    public int getDay() {
        return date.getDayOfMonth();
    }

    public int getHour() {
        return date.getHour();
    }

    public int getMinute() {
        return date.getMinute();
    }

    public void setYear(int year) throws DateTimeException {
        date = date.withYear(year);
    }

    public void setMonth(int month) throws DateTimeException {
        date = date.withMonth(month);
    }

    public void setDay(int day) throws DateTimeException {
        date = date.withDayOfMonth(day);
    }

    public void setHour(int hour) throws DateTimeException {
        date = date.withHour(hour);
    }

    public void setMinute(int minute) {
        date = date.withMinute(minute);
    }

    @Override
    public String toString() {
        return localDateTime.toString();
    }

    /**
     * Returns if a given datetime is a valid datetime.
     */
    public static boolean isValidDateTime(int year, int month, int day, int hour, int minute) {
        try {
            LocalDateTime dateTime = LocalDateTime.of(year, month, day, hour, minute);
            DateTime dateTime1 = new DateTime(dateTime);
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DateTime // instanceof handles nulls
                && localDateTime.equals(((DateTime) other).localDateTime)); // state check
    }

    @Override
    public int hashCode() {
        return localDateTime.hashCode();
    }
}
