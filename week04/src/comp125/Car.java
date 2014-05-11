/**
 * Solution to COMP125 Week 4 Assessment Task
 * @author Max Schaefer (43263798)
 * @date 28/08/2013
 */
package comp125;

public class Car {
	double capacity;
	double efficiency;
	double petrol;

	public Car(double theCapacity, double theEfficiency) {
		efficiency = theEfficiency;
		capacity = theCapacity;
	}

	public void addPetrol(double moreFuel) {
		if(petrol + moreFuel > capacity)
			petrol = capacity;
		else
			petrol = petrol + moreFuel;
	}

	public void drive(double distance) {
		if (distance * (efficiency / 100) > petrol)
			petrol = 0;
		else
			petrol = petrol - distance * (efficiency / 100);
	}

	public double getCapacity() {
		return capacity;
	}

	public double getEfficiency() {
		return efficiency;
	}

	public double getPetrol() {
		return petrol;
	}

	public void setCapacity(double newCapacity) {
		if(newCapacity < petrol)
			petrol = newCapacity;
		capacity = newCapacity;
	}

	public void setEfficiency(double newEfficiency) {
		efficiency = newEfficiency;
	}

	public void setPetrol(double newPetrol) {
		if(newPetrol > capacity)
			petrol = capacity;
		else
			petrol = newPetrol;
	}
}
