import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A thing that you want to do.
 * 
 * @author Chad Hogg
 * @author Brooks Stouffer
 */
public abstract class Event {

    // Class invariants:
    // 1: startTime is before endTime

    /** The name of the event. */
    private String eventName;
    /** The time when the event starts. */
    private LocalTime startTime;
    /** The time when the event ends. */
    private LocalTime endTime;

    /**
     * Constructs a new event.
     * 
     * @param theEventName The name of the new event.
     * @param theStartTime The time when the new event starts.
     * @param theEndTime   The time when the new event ends. This must be after
     *                     startTime.
     */
    public Event(String theEventName, LocalTime theStartTime, LocalTime theEndTime) {
        if (theStartTime.isAfter(theEndTime)) {
            throw new IllegalStateException("Your start time can't be after your end time");
Grader says:
02 functionality: 0.00
This is a problem with the parameters, so it should be an IllegalArgumentException.
        }
        eventName = theEventName;
        startTime = theStartTime;
        endTime = theEndTime;

    }

    /**
     * Gets the name of the event.
     * 
     * @return The name of the event.
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * Gets the time when the event starts.
     * 
     * @return The time when the event starts.
     */
    public LocalTime getStartTime() {
        return startTime;
    }

    /**
     * Gets the time when the event ends.
     * 
     * @return The time when the event ends.
     */
    public LocalTime getEndTime() {
        return endTime;
    }

    /**
     * Determines whether or not the event occurs on a given day.
     * 
     * @param when The day it might occur on.
     * @return True if the event occurs on that day, or false otherwise.
     */

    public abstract boolean isOnDay(LocalDate when);

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Event other = (Event) obj;
        return (this == other);

    }

    /**
     * Prints out a sentence with the day and time for the users event.
     * 
     * @return A sentence with the date and time for the users event.
     */
    @Override
    public String toString() {
        return "Event, " + eventName + ", Starts at " + startTime + " and ends at " + endTime;

    }

    /**
     * Assigns a integer to each variable.
     * 
     * @return An integer value assigned to each variable.
     */
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + startTime.hashCode();
        result = 31 * result + endTime.hashCode();
        result = 31 * result + eventName.hashCode();
        return result;
    }

}
