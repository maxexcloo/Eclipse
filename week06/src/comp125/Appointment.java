package comp125;

/**
 * @author Diego Molla (modified by Scott M.)
 */
public class Appointment {
	private Time time;
	private Date date;
	private int duration;
	private String concept;
	
	/**
	 * Constructor that sets all the values of the appointment
	 * @param time
	 * @param date
	 * @param duration
	 * @param concept
	 */
	Appointment(Time theTime, Date theDate, int theDuration, String theConcept) {
		time = new Time(theTime.getHour(), theTime.getMinute());
		date = new Date(theDate.getDay(), theDate.getMonth(), theDate.getYear());
		
		if (theDuration < 0) {
			duration = 0;
		} else {
			duration = theDuration;
		}
		concept = theConcept;
	}
	
	public String toString() {
		return date+" "+time+" "+duration+" minutes: "+concept;
	}

	/**
	 * Return the time of the appointment
	 * @return the time as an instance of class Time
	 */
	public Time getTime() {
		return time;
	}
	
	/**
	 * Return a deep copy of the appointment
	 * @return
	 */
	public Appointment copy() {
		return new Appointment(new Time(time.getHour(),time.getMinute()), new Date(date.getDay(),date.getMonth(),date.getYear()), duration, concept);
	}
	
	/**
	 * Return the date of the appointment
	 * @return the date as an instance of class Date
	 */
	public Date getDate() {
		return date;
	}
	
	/**
	 * Return the duration
	 * @return the duration in minutes
	 */
	public int getDuration() {
		return duration;
	}
	
	/**
	 * Return the concept of the appointment
	 * @return the concept
	 */
	public String getConcept() {
		return concept;
	}
}
