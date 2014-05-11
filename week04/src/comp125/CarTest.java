/**
 * 
 */
package comp125;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Diego M. (modified by Scott M.)
 *
 */
public class CarTest {

	/**
	 * Test method for {@link comp125.Car#Car(double, double)}.
	 */
	@Test
	public final void testCar() {
		Car myCar = new Car(60,10);
		assertEquals("Petrol in constructor",0.0,myCar.getPetrol(),0.01);
		assertEquals("Capacity in constructor",60.0,myCar.getCapacity(),0.01);
		assertEquals("Efficiency in constructor",10.0,myCar.getEfficiency(),0.01);
	}

	/**
	 * Test method for {@link comp125.Car#addPetrol(double)}.
	 */
	@Test
	public final void testAddPetrol() {
		Car yourCar = new Car(30,10);
		yourCar.addPetrol(20);
		assertEquals("After adding 20l of petrol", 20.,yourCar.getPetrol(),0.01);
		yourCar.addPetrol(20);
		assertEquals("After adding 20l more of petrol", 30.,yourCar.getPetrol(),0.01);
	}

	/**
	 * Test method for {@link comp125.Car#drive(double)}.
	 */
	@Test
	public final void testDrive() {
		Car myCar = new Car(40,5);
		myCar.addPetrol(30);
		myCar.drive(100);
		assertEquals("After 100 km", 25.,myCar.getPetrol(),0.01);
		myCar.drive(10000);
		assertEquals("After 10000 km", 0.,myCar.getPetrol(),0.01);
	}

	/**
	 * Test method for {@link comp125.Car#setEfficiency(double)}.
	 */
	@Test
	public final void testSetEfficiency()
	{
		Car theCar = new Car(30,10);
		theCar.setEfficiency(5);
		assertEquals("Changing fuel efficiency",5.,theCar.getEfficiency(),0.01);
	}

	/**
	 * Test method for {@link comp125.Car#setPetrol(double)}.
	 */
	@Test
	public final void testSetPetrol()
	{
		Car myCar = new Car(30,10);
		myCar.setPetrol(5);
		assertEquals("Changing fuel petrol",5.,myCar.getPetrol(),0.01);
		myCar.setPetrol(29);
		assertEquals("Changing fuel petrol",29.,myCar.getPetrol(),0.01);
		myCar.setPetrol(35);
		assertEquals("Changing fuel petrol",30.,myCar.getPetrol(),0.01);
	}

	/**
	 * Test method for {@link comp125.Car#setCapacity(double)}.
	 */
	@Test
	public final void testSetCapacity()
	{
		Car aCar = new Car(30,10);
		aCar.setPetrol(25);
		aCar.setCapacity(35);
		assertEquals("Changing fuel capacity",25.,aCar.getPetrol(),0.01);
		assertEquals("Changing fuel capacity",35.,aCar.getCapacity(),0.01);
		aCar.setCapacity(20);
		assertEquals("Changing fuel capacity",20.,aCar.getPetrol(),0.01);
		assertEquals("Changing fuel capacity",20.,aCar.getCapacity(),0.01);
	}

}
