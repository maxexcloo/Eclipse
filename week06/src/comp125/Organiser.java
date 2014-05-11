package comp125;

/**
 * @author Max Schaefer (43263798)
 * @date 06/09/2013
 */
public class Organiser {
	private int current;
	private Appointment[] list;

	/**
	 * Constructor that creates an instance with space for appointments
	 * @param size - the number of appointments that can be stored
	 */
	Organiser(int size) {
		current = 0;
		list = new Appointment[size];
	}

	/**
	 * Count all appointments at a specific date
	 * @param date
	 * @return the number of appointments
	 */
	public int countByDate(Date date) {
		int count = 0;
		for(int i = 0; i < current; i++)
			if(list[i].getDate().equals(date))
				count++;
		return count;
	}

	/**
	 * Add an appointment
	 * @param day
	 * @param month
	 * @param year
	 * @param hour
	 * @param minute
	 * @param duration
	 * @param concept
	 */
	public void addAppointment(int day, int month, int year, int hour, int minute, int duration, String concept) {
		if(current < list.length) {
			Time _time = new Time(hour, minute);
			Date _date = new Date(day, month, year);
			list[current] = new Appointment(_time, _date, duration, concept);
			current++;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Creating an organiser for 100 appointments");
		Organiser organiser = new Organiser(100);

		System.out.println("Adding three appointments");
		organiser.addAppointment(27,3,2013,16,00,120,"COMP125 lecture");
		organiser.addAppointment(27,3,2013,18,00,120,"Visit friends");
		organiser.addAppointment(29,3,2013,12,00,240,"Good Easter BBQ");

		Date date = new Date(27,3,2013);
		int appointments = organiser.countByDate(date);
		System.out.println("There are "+appointments+" appointments on "+date);
	}
}
