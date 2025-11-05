import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

/**
 * A class that lets you set a one time event.
 * 
 * @author Brooks Stouffer
 */
public class OneTimeEvent extends Event {
    /**
     * The start date.
     */
    private LocalDate date;

    /**
     * The one time event you need to schedule.
     * 
     * @param eventName The name of the event.
     * @param date      The start date.
     * @param startTime The start time of the event.
     * @param endTime   The end time of the event.
     */

    public OneTimeEvent(String eventName, LocalDate date, LocalTime startTime, LocalTime endTime) {
        super(eventName, startTime, endTime);
        this.date = date;

    }

    /**
     * determines if it is on this day.
     * 
     * @param when The date that is being input.
     * @return if the event is on that day.
     */

    @Override
    public boolean isOnDay(LocalDate when) {
        return this.date.equals(when);
    }

    /**
     * Creates a sentence for the event with day and time.
     * 
     * @return The date and time for the event.
     */
    @Override
    public String toString() {
        return getEventName() + " (" + getStartTime() + "-" + getEndTime() + ") on " + date;
    }

    /**
     * 
     * Determines if two events are equal.
     * 
     * @param obj An event being compared to another event.
     * @return If the events are equal or not.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        OneTimeEvent other = (OneTimeEvent) obj;
        return this.getStartTime().equals(other.getStartTime()) && this.getEndTime().equals(other.getEndTime()) && this.getEventName().equals(other.getEventName()) && this.date.equals(other.date);    }

    /**
     * Gives each variable an integer value.
     * 
     * @return Each variable with an assigned integer.
     */
    @Override
    public int hashCode() {
        int result = 17;
        result = 3 * result + getStartTime().hashCode();
        result = 5 * result + getEndTime().hashCode();
        result = 7 * result + getEventName().hashCode();
        result = 11 * result + date.hashCode();
        return result;
    }

}
