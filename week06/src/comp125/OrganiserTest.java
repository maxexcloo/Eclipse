package comp125;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * A simple set of tests. Note that these tests are not exhaustive.
 * @author Diego Molla (modified by Scott M.)
 */
public class OrganiserTest {
	/**
	 * A simple test
	 */
	@Test
	public final void simpleTest() {
		Organiser organiser = new Organiser(5);
		organiser.addAppointment(12,6,2013,9,25,30,"Appointment 1");
		Date date = new Date(12,6,2013);
		assertEquals("One appointment",1,organiser.countByDate(date));
	}

	/**
	 * Test method for {@link weeklytask6.Organiser#countByDate(weeklytask6.Date)}.
	 */
	@Test
	public final void testCountByDate() {
		Organiser organiser = new Organiser(5);
		organiser.addAppointment(27,3,2013,16,00,120,"COMP125 lecture");
		organiser.addAppointment(27,3,2013,18,00,120,"Visit friends");
		organiser.addAppointment(29,3,2013,12,00,240,"Good Easter BBQ");
		
		Date date = new Date(27,3,2013);
		assertEquals("Two appointments",2,organiser.countByDate(date));
		
		date = new Date(29,3,2013);
		assertEquals("One appointment",1,organiser.countByDate(date));
		
		date = new Date(30,3,2013);
		assertEquals("No appointments",0,organiser.countByDate(date));
	}

	/**
	 * Test method for {@link weeklytask6.Organiser#addAppointment(int, int, int, int, int, int, java.lang.String)}.
	 */
	@Test
	public final void testAddAppointment() {
		Organiser organiser = new Organiser(2);
		organiser.addAppointment(27,3,2013,16,00,120,"COMP125 lecture");
		organiser.addAppointment(27,3,2013,18,00,120,"Visit friends");
		organiser.addAppointment(29,3,2013,12,00,240,"Good Easter BBQ");

		Date date = new Date(27,3,2013);
		assertEquals("Two appointments",2,organiser.countByDate(date));
		
		date = new Date(29,3,2013);
		assertEquals("No appointments",0,organiser.countByDate(date));
	}
}
