import java.time.LocalDate;

import java.time.LocalTime;

/**
 * A class that will let you schedule a repeating event.
 * 
 * @author Brooks Stouffer.
 */
public abstract class RepeatingEvent extends Event {

    /** The first occurrence of the event. */
    private LocalDate firstOccurrence;
    /** The number of times the event repeats. */
    private int repetitions;

    /**
     * Creates a repeating event on your calander.
     * 
     * 
     * @param firstTime The first day of the event.
     * @param numTimes  The number of times you repeat the event.
     * @param eventName The name of the event.
     * @param startTime The time your event starts.
     * @param endTime   The time your event ends.
     * 
     */
    public RepeatingEvent(String eventName, LocalDate firstTime, int numTimes, LocalTime startTime, LocalTime endTime) {
        super(eventName, startTime, endTime);
        firstOccurrence = firstTime;
        repetitions = numTimes;

Grader says:
02 functionality: 0.00
We have a precondition that repetitions may not be negative. You should check that precondition.
    }

    /**
     * Gets the first day that a repeating event begins.
     * 
     * @return The first day.
     */
    public LocalDate getFirstOccurrence() {
        return firstOccurrence;
    }

    /**
     * Gets the number of repetitions.
     * 
     * @return The number of repetitions for your event.
     */
    public int getRepetitions() {
        return repetitions;
    }

    /**
     * Prints what the event is, start time, end time, and how many repetitions.
     * 
     * @return the event name, date, start time, end time, and number of
     *         repetitions.
     */
    public String toString() {
        return getEventName() + " (" + getStartTime() + "-" + getEndTime() + ") repeating for " + repetitions;
    }

    /**
     * Determines if two repeating events are equal.
     * 
     * @param obj The repeating event you are comparing something to.
     * @return If the repeating events are equal.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        RepeatingEvent other = (RepeatingEvent) obj;
        return this.getStartTime().equals(other.getStartTime()) && this.getEventName().equals(other.getEventName()) && this.getRepetitions() == (other.getRepetitions()) && this.getFirstOccurrence().equals(other.getFirstOccurrence()) && this.getEndTime().equals(other.getEndTime());
    }

    /**
     * Assigns an integer value to each variable.
     * 
     * @return The integer value for each variable.
     */
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + repetitions;
        result = 31 * result + firstOccurrence.hashCode();
        return result;
    }

}
