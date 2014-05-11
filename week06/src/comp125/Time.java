package comp125;

/**
 * Class that implement time information
 * @author Diego Molla (modified by Scott M.)
 */
public class Time {
	private int hour; // Hour from 0 to 23
	private int minute; // Minute from 0 to 59
	
	/**
	 * Constructor
	 */
	Time() {
		hour = 0;
		minute = 0;
	}
	
	/**
	 * Constructor with hour and minute information
	 * @param hour
	 * @param minute
	 */
	Time(int theHour, int theMinute) {
		setHour(theHour);
		setMinute(theMinute);
	}
	
	/**
	 * Return a string representation of the time
	 * @return the string representation of the time
	 */
	public String toString() {
		return hour + ":" + minute;
	}
	
	/**
	 * Set the hour, checking data integrity
	 * @param hour
	 */
	public void setHour(int theHour) {
		if (theHour < 0) {
			hour = 0;
		} else if (theHour > 23) {
			hour = 23;
		} else {
			hour = theHour;
		}
	}

	/**
	 * Set the minute, checking data integrity
	 * @param minute
	 */
	public void setMinute(int theMinute) {
		if (theMinute < 0) {
			minute = 0;
		} else if (theMinute > 59) {
			minute = 59;
		} else {
			minute = theMinute;
		}
	}
	
	/**
	 * Get the hour
	 * @return the hour
	 */
	public int getHour() {
		return hour;
	}
	
	/**
	 * Get the minute
	 * @return the minute
	 */
	public int getMinute() {
		return minute;
	}
}
