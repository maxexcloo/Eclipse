package comp125;

import static org.junit.Assert.*;
import org.junit.Test;

public class ClassroomTest {

	/**
	 * Partial Test methods for numberOfNearMatches
	 */


    @Test
    public void testClassroomNumberOfNearMatches3() 
	{
		Classroom list = new Classroom(5, 365);

		// list = [12, 48, 13, 65, 2]
		list.listOfDates.set(0, 12);
		list.listOfDates.set(1, 48);
		list.listOfDates.set(2, 13);
		list.listOfDates.set(3, 65);
		list.listOfDates.set(4, 2);

		assertTrue("With the list [12, 48, 13, 65, 2] and bound = 1, the outcome should be 1, but your method	returns something else", list.numberOfNearMatches(1, 365) == 1);
	}

    @Test
    public void testClassroomNumberOfNearMatches7() 
	{
		Classroom list = new Classroom(6, 365);

		// list = [234, 122, 235, 233, 123, 123]
		list.listOfDates.set(0, 234);
		list.listOfDates.set(1, 122);
		list.listOfDates.set(2, 235);
		list.listOfDates.set(3, 233);
		list.listOfDates.set(4, 123);
		list.listOfDates.set(5, 123);

		assertTrue("With the list [234, 122, 235, 233, 123, 123] and bound = 1, the outcome should be 5, but your method returns something else", list.numberOfNearMatches(1, 365) == 5);
	}


    @Test
	public void testClassroomNumberOfNearMatches8() 
	{
		Classroom list = new Classroom(7, 365);

		// list = [57, 364, 1, 233, 2, 182, 365]
		list.listOfDates.set(0, 57);
		list.listOfDates.set(1, 364);
		list.listOfDates.set(2, 1);
		list.listOfDates.set(3, 233);
		list.listOfDates.set(4, 2);
		list.listOfDates.set(5, 182);
		list.listOfDates.set(6, 365);

		assertTrue("With the list [57, 364, 1, 233, 2, 182, 365] and bound = 1, the outcome should be 3, but your method returns something else", list.numberOfNearMatches(1, 365) == 3);
	}
    

    @Test
	public void testClassroomNumberOfNearMatches9() 
	{
		Classroom list = new Classroom(8, 365);

		// list = [176, 2, 252, 365, 1, 235, 364, 185]
		list.listOfDates.set(0, 176);
		list.listOfDates.set(1, 2);
		list.listOfDates.set(2, 252);
		list.listOfDates.set(3, 365);
		list.listOfDates.set(4, 1);
		list.listOfDates.set(5, 235);
		list.listOfDates.set(6, 364);
		list.listOfDates.set(7, 185);

		assertTrue("With the list [176, 2, 252, 365, 1, 235, 364, 185] and bound = 2, the outcome should be 5, but your method returns something else", list.numberOfNearMatches(2, 365) == 5);
	}

    @Test
	public void testClassroomNumberOfNearMatches14() 
	{
		Classroom list = new Classroom(14, 365);

		// list = [151, 59, 5, 248, 239, 62, 59, 71, 58, 77, 82, 362, 365, 3]
		list.listOfDates.set(0, 151);
		list.listOfDates.set(1, 59);
		list.listOfDates.set(2, 5);
		list.listOfDates.set(3, 248);
		list.listOfDates.set(4, 239);
		list.listOfDates.set(5, 62);
		list.listOfDates.set(6, 59);
		list.listOfDates.set(7, 71);
		list.listOfDates.set(8, 58);
		list.listOfDates.set(9, 77);
		list.listOfDates.set(10, 82);
		list.listOfDates.set(11, 362);
		list.listOfDates.set(12, 365);
		list.listOfDates.set(13, 3);

		assertTrue("With the list = [151, 59, 5, 248, 239, 62, 59, 71, 58, 77, 82, 362, 365, 3] and bound = 10, the outcome should be 16, but your method returns something else", list.numberOfNearMatches(10, 365) == 16);
	}

}


