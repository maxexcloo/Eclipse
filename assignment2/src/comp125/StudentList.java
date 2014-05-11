package comp125;

/**
 * Template of class to store and provide functionality for a list
 * of exam results for a cohort of students.
 * @author Max Schaefer (43263798)
 */

public class StudentList {
	// Student Object Array
	private Student[] list;

	// Total Student Number Integer (Same As list.length)
	private int numStudents;

	/**
	 * Default Constructor
	 */
	public StudentList() {}

	/**
	 * Constructor With One Parameter
	 * @param numStud
	 */
	public StudentList(int numStud) {
		// Create New Array For numStud Students
		list = new Student[numStud];

		// Set numStudents From List Array Length
		numStudents = list.length;
	}

	/**
	 * Get student at position i.
	 */
	public Student getAt(int i) {
		// Return Student At Position i
		return list[i];
	}

	/**
	 * Set element at position i to aStudent.
	 */
	public void setAt(int i, Student aStudent) {
		// Set Student At Position i
		list[i] = aStudent;
	}

	/**
	 * Read list of results for the student cohort.
	 */
	public void readList() {
		// Create Temporary Student Object
		Student theStudent;

		// Loop Through All Students
		for (int i = 0; i < numStudents; i++) {
			// Print Query Message
			System.out.println("Enter data for next student.");

			// Create New Student Object
			theStudent = new Student();

			// Read Student Input
			theStudent.readStudent();

			// Copy Temporary Student To Student List
			list[i] = theStudent;
		}

	}

	/**
	 * Display list of results for the student cohort.
	 */
	public void displayList() {
		// Loop Through All Students
		for (int i = 0; i < numStudents; i++) {
			// Print Name
			System.out.printf("%-15s",  list[i].getName());

			// Print Score
			System.out.printf("%5.1f", list[i].getScore());

			// Print New Line
			System.out.println();
		}
	}

	/**
	 * Sort list into alphabetical order on name.
	 * Use insertion sort algorithm.
	 * Question 1. Insertion sort could be more efficient than some other
	 * sorting algorithms for the purpose intended, all things considered.
	 * Do you agree and if so why? Write 6 to 10 lines, say.
	 *
	 * ANSWER:
	 * I agree that the selection sort algorithm
	 * can be more efficient than other sorting
	 * algorithms we have learned about as it is
	 * much more efficient with partially sorted
	 * or non random lists, something likely to
	 * be encountered if marks are manually entered.
	 * A selection sort has a best case performance
	 * of O(n) and a worst case performance of
	 * O(n^2). Compared to other methods of sorting
	 * we have learned about such as the selection
	 * sort (best case O(n^2)) and the bubble sort
	 * (best case O(n), the same as the selection
	 * sort) the selection sort performs well with
	 * the target workload.
	 */
	public void sortByName() {
		// Set Position
		int position = 0;

		// Create Temporary Student Object
		Student temp;

		// Loop Through All Students
		for (int i = 1; i < numStudents; i++) {
			// Copy Current Student To Temporary Object
			temp = list[i];

			// Decrement Position
			position = i - 1;

			// While The Current Sorted Element More Than The Temporary Object
			while (position >= 0 && temp.getName().compareTo(list[position].getName()) < 0) {
				// Shift Sorted Elements Back
				list[position + 1] = list[position];

				// Decrement Position
				position--;
			}

			// Insert Temporary Object Into Student List
			list[position + 1] = temp;
		}
	}

	/**
	 * Compute and return the average score.
	 * Precondition: the calling student list is not empty.
	 */
	public double averageScore() {
		// Set Total
		double total = 0.0;

		// Loop Through All Students
		for (int i = 0; i < numStudents; i++)
			// Add Current Student Score To Total
			total = total + list[i].getScore();

		// Return Average
		return total/numStudents;
	}

	/**
	 * Return the score corresponding to aName in the calling student list.
	 * If student not in list, return -1.
	 * Use binary search algorithm.
	 * Precondition: the calling student list is assumed to be sorted by name.
	 * @param aName
	 * @return
	 */
	public double retrieveScore(String aName) {
		// Set Low To 0
		int low = 0;

		// Set High To numStudents - 1
		int high = numStudents - 1;

		// While Low <= High
		while(low <= high) {
			// Set Middle
			int middle = (low + high) / 2;

			// If Name > Middle
			if (aName.compareTo(list[middle].getName()) > 0)
				// Set Low
				low = middle + 1;
			// If Name < Middle
			else if (aName.compareTo(list[middle].getName()) < 0)
				// Set High
				high = middle - 1;
			// Else Condition
			else
				// Return Score For Name
				return list[middle].getScore();
		}

		// Return -1 If No Match Found
		return -1;
	}

	/**
	 * Return a deep copy of calling object.
	 * @return
	 */
	public StudentList deepCopy() {
		// Create New Student List
		StudentList copy = new StudentList(numStudents);

		// Loop Through All Students
		for(int i = 0; i < numStudents; i++)
			// Copy Student
			copy.setAt(i, new Student(list[i].getName(), list[i].getScore()));

		// Return Object
		return copy;
	}

	/**
	 * Reverse sort list into merit order on score.
	 * Use selection sort algorithm.
	 * Question 2. Selection sort could be more efficient than some other
	 * sorting algorithms for the purpose intended. Do you agree and if so, why?
	 * Write 6 to 10 lines.
	 *
	 * ANSWER:
	 * I disagree that the selection sort can be
	 * more efficient than other sorting algorithms
	 * as it has the same worst case and best case
	 * performance, O(n^2). An example of a better
	 * performing algorithm could be the insertion
	 * sort as, while its worst case performance is
	 * O(n^2), its best case performance is O(n),
	 * a significantly improved figure, especially
	 * when using a workload with less random keys
	 * (students will usually have similar scores).
	 */
	public void meritSort() {
		// Create Integers
		int first, j;

		// Create Temporary Student Object
		Student temp;

		// Reverse Loop Through Students
		for (int i = numStudents - 1; i > 0; i--) {
			// Set First
			first = 0;

			// Locate Smallest Element
			for(j = 1; j <= i; j++)
				// Compare Doubles
				if(list[j].getScore() < list[first].getScore())
					// Set First
					first = j;

			// Swap Smallest Element With Element i
			temp = list[first];
			list[first] = list[i];
			list[i] = temp;
		}
	}

	/**
	 * Sort list into alphabetical order by name - alternative method.
	 * This method should be based on binary insertion sort.
	 * Please see Assign 2 Description for brief description of this algorithm.
	 * Question 3. Do you think it is worthwhile to implement this alternative?
	 * Why? Write 6 to 10 lines.
	 *
	 * ANSWER:
	 * I think this alternative is worth implementing
	 * as it improves upon the insertion sort by using
	 * the more efficient binary search to search for
	 * the value to insert. This brings with it great
	 * speed improvements over the vanilla insertion
	 * sort. One thing to note however is that these
	 * improvements many not be noticeable unless the
	 * array is comprised of a large dataset, bringing
	 * the time taken to implement this array into
	 * questionable territory ;)
	 */
	public void sortByNameBIS() {
		// Loop Through All Students
		for (int i = 1; i < numStudents; i++) {
			// Set Low To 0
			int low = 0;

			// Set High To i
			int high = i;

			// Set Middle
			int middle = i / 2;

			// While Loop
			do {
				// If Name > Middle
				if (list[i].getName().compareTo(list[middle].getName()) > 0)
					// Set Low
					low = middle + 1;
				// If Name < Middle
				if (list[i].getName().compareTo(list[middle].getName()) < 0)
					// Set High
					high = middle;
				else
					break;

				// Set Middle
				middle = low + (high - low) / 2;
			} while (low < high);

			// Check If Middle Less Than i
			if (middle < i) {
				// Create Temporary Student Object
				Student temp = list[i];

				// Loop Through Sorted Elements
				for (int j = i - 1; j >= middle; j--)
					// Shift Sorted Elements Forward
					list[j + 1] = list[j];

				// Set Middle To Temporary Student Object
				list[middle] = temp;
			}
		}
	}
}
