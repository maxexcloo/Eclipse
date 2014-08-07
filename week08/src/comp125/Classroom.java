package comp125;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Max Schaefer (43263798)
 */

public class Classroom  {
	ArrayList<Integer> listOfDates = new ArrayList<Integer>();
	Random generator = new Random();

	public Classroom(int numberOfPeople, int numberOfOutcomes) {
		for(int i = 1; i <= numberOfPeople; i++) {
			int birthday = generator.nextInt(numberOfOutcomes);
			listOfDates.add(birthday);
		}
	}

	public void reset(int numberOfOutcomes) {
		for(int i = 0; i < listOfDates.size(); i++) {
			int birthday = 1 + generator.nextInt(numberOfOutcomes);
			listOfDates.set(i, birthday);
		}
	}

	public boolean isMatch() {
		for(int i = 0; i < listOfDates.size(); i++)
			for(int j = i + 1; j < listOfDates.size(); j++)
				if(listOfDates.get(i).intValue() == listOfDates.get(j).intValue())
					return true;
		return false;
	}

	public int numberOfNearMatches(int bound, int numberOfOutcomes) {
		int near = 0;
		int size = listOfDates.size();
		for(int i = 0; i < size; i++) {
			int ival = listOfDates.get(i);
			for(int j = i + 1; j < size; j++)
				if(Math.abs(ival - listOfDates.get(j)) <= bound)
					near++;
			if(ival >= numberOfOutcomes - bound)
				for(int j = 0; j < size; j++)
					if(listOfDates.get(j) <= ival - numberOfOutcomes + bound)
						near++;
		}
		return near;
	}

	public static void main(String[] args) {
		int numberOfPeople = 40;
		int numberOfOutcomes = 365;
		int bound = 2;
		Classroom classroom = new Classroom(numberOfPeople, numberOfOutcomes);
		System.out.println(classroom.numberOfNearMatches(bound, numberOfOutcomes));
	}
}