import java.time.LocalDate;
import java.time.LocalTime;
/**
 * A class that will let the user create a weekly repeating event.
 * 
 * @author Brooks Stouffer
 */
public class WeeklyEvent extends RepeatingEvent {
    /**
     * Creates a weekly event for the user.
     * 
     * @param eventName      The name of the Event.
     * @param firstOccurrence The first time the event happens.
     * @param repetitions    The number of times the event happens.
     * @param startTime      The start time of the event.
     * @param endTime        The end time of the event.
     */
    public WeeklyEvent(String eventName, LocalDate firstOccurrence, int repetitions, LocalTime startTime,
            LocalTime endTime) {
        super(eventName, firstOccurrence, repetitions, startTime, endTime);
    }

    /**
     * Determines if the event happens on that day or not.
     * 
     * @param when The date of your event.
     * @return True when the event happens on that day.
     */
    public boolean isOnDay(LocalDate when) {
        if (when.isBefore(getFirstOccurrence())) {
            return false;
        }
        if (getRepetitions() == 0) {
            return getFirstOccurrence().getDayOfWeek() == when.getDayOfWeek();
        } else {
            for (int i = 0; i <= getRepetitions(); i++) {
                LocalDate occurrence = getFirstOccurrence().plusWeeks(i);
                if (occurrence.isEqual(when)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * Creates a sentence stating the date and times for the event.
     * 
     * @return A sentence stating what the event is and when it starts and ends.
     */
    @Override
    public String toString() {
        if (getRepetitions() != 0) {
            return getEventName() + " (" + getStartTime() + "-" + getEndTime() + ") repeating for " + getRepetitions()
                    + " weeks starting on " + getFirstOccurrence();
        } else {
            return getEventName() + " (" + getStartTime() + "-" + getEndTime()
                    + ") repeating for all weeks starting on " + getFirstOccurrence();
        }
    }

}
