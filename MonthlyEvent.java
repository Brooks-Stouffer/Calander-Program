import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A class that will let you schedule a monthly repeating event.
 * 
 * @author Brooks Stouffer
 */
public class MonthlyEvent extends RepeatingEvent {

    /**
     * Creates a monthly event.
     * 
     * @param firstOccurrence The first time the event happens.
     * @param repetitions    The number of times the event happens.
     * @param eventName      The name of the event.
     * @param startTime      The start time for the event.
     * @param endTime        The end time for the event.
     */
    public MonthlyEvent(String eventName, LocalDate firstOccurrence, int repetitions, LocalTime startTime,
            LocalTime endTime) {
        super(eventName, firstOccurrence, repetitions, startTime, endTime);
        if (startTime.isAfter(endTime)) {
            throw new AssertionError("Your start time can't be after your end time.");
        }

    }

    /**
     * Determines if the monthly event is on the day or not.
     * 
     * @param when The date that the event is on
     * @return If the event is on that day or not.
     */
    @Override
    public boolean isOnDay(LocalDate when) {
        if (when.isBefore(getFirstOccurrence())) {
            return false;
        }
        if (getRepetitions() != 0 && when.isAfter(getFirstOccurrence().plusMonths(getRepetitions()))) {
            return false;
        }
        if (when.getDayOfMonth() == getFirstOccurrence().getDayOfMonth()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Prints a sentence for the users event's date and time.
     * 
     * @return The users date and time for their event.
     */
    @Override
    public String toString() {
        if (getRepetitions() != 0) {
            return getEventName() + " (" + getStartTime() + "-" + getEndTime() + ") repeating for " + getRepetitions()
                    + " months starting on " + getFirstOccurrence();
        } else {
            return getEventName() + " (" + getStartTime() + "-" + getEndTime()
                    + ") repeating for all months starting on " + getFirstOccurrence();
        }
    }

}
