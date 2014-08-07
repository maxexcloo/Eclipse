package comp125;
import java.util.Scanner;

/**
 * Template of class to provide a demo of class StudentList.
 * @author Max Schaefer (43263798)
 */

public class StudentListDemo {
	public static void main(String[] args) {
		// Initialize Scanner
		Scanner keyboard = new Scanner(System.in);

		// Print Introduction
		printHeader();

		// Student Count Variable
		int studentCount = 0;

		// Student Count Input Loop
		do {
			// Check Variable
			if (studentCount == -1)
				// Show Invalid Entry Message
				System.out.println("The number you entered was invalid. Please try again.");

			// Prompt For Keyboard Input
			System.out.println();
			System.out.print("Please enter a valid number of students (digits above zero only): ");

			// Try Statement
			try {
				// Set Student Count Variable From Input
				studentCount = Integer.parseInt(keyboard.nextLine());

				// Check Student Count Status
				if (studentCount <= 0)
					// Set Student Count Error
					studentCount = -1;
			} catch (Exception e) {
				// Continue Scanner
				keyboard.next();

				// Set Student Count Error
				studentCount = -1;
			}
		} while (studentCount <= 0);

		// Create Student List Object
		StudentList myList = new StudentList(studentCount);

		// Student Entry Input Loop
		for (int i = 0; i < studentCount; i++) {
			// Student Entry Variables
			int studentName = 0;
			int studentScore = 0;
			String studentNameTemp = null;
			double studentScoreTemp = -1;

			// Student Count Input Loop
			do {
				// Check Student Name Variable
				if (studentName == -1)
					// Show Invalid Entry Message
					System.out.println("The name you entered was invalid. Please try again.");

				// Check Student Score Variable
				if (studentScore == -1)
					// Show Invalid Entry Message
					System.out.println("The score you entered was invalid. Please try again.");

				// Prompt For Keyboard Input
				System.out.println();
				System.out.println("Entering name for student #" + (i + 1));
				System.out.print("Please enter a surname: ");

				// Try Statement
				try {
					// Set Student Count Variable From Input
					studentNameTemp = keyboard.nextLine();
				} catch (Exception e) {
					// Set Student Count Error
					studentName = -1;
				}

				// Prompt For Keyboard Input
				System.out.print("Please enter a score: ");

				// Try Statement
				try {
					// Set Student Count Variable From Input
					studentScoreTemp = Double.parseDouble(keyboard.nextLine());

					// Check Option Select Status
					if (studentScoreTemp < 0 || studentScoreTemp > 100)
						// Set Student Score Error
						studentScore = -1;
					else
						// Set Student Score Error
						studentScore = 0;
				} catch (Exception e) {
					// Set Student Count Error
					studentScore = -1;
				}
			} while (studentName == -1 || studentScore == -1);

			// Create Temporary Student Object & Copy
			Student temp = new Student(studentNameTemp, studentScoreTemp);
			myList.setAt(i, temp);

			// Print Confirmation
			System.out.println("Saved student #" + (i + 1) + "!");
		}

		// Sort List
		myList.sortByName();

		// Option Select Variable
		int optionSelect = 0;

		// Option Select Input Loop
		do {
			// Check Variable
			if (optionSelect == -1)
				// Show Invalid Entry Message
				System.out.println("You entered an invalid option. Please try again.");

			// Print Options
			System.out.println();
			System.out.println("Please choose an option:");
			System.out.println("1 - Display Average Score");
			System.out.println("2 - Retrieve Score For Student");
			System.out.println("3 - Create & Display Merit List");
			System.out.println("4 - Quit");

			// Prompt For Keyboard Input
			System.out.print("Enter Option Number & Press Enter: ");

			// Try Statement
			try {
				// Set Option Select Variable From Input
				optionSelect = Integer.parseInt(keyboard.nextLine());

				// Check Option Select Status
				if (optionSelect <= 0 || optionSelect > 4)
					// Set Option Select Error
					optionSelect = -1;
			} catch (Exception e) {
				// Continue Scanner
				keyboard.next();

				// Set Option Select Error
				optionSelect = -1;
			}

			// Switch Statement
			switch(optionSelect) {
			case 1: // Display Average Score
				System.out.println();
				System.out.println("Average Score: " + myList.averageScore());
				break;
			case 2: // Retrieve Score For Student
				// Student Name Variables
				int studentName = 0;
				String studentNameTemp = null;

				// Student Name Input Loop
				do {
					// Check Student Name Variable
					if (studentName == -1)
						// Show Invalid Entry Message
						System.out.println("The surname you entered was invalid. Please try again.");

					// Prompt For Keyboard Input
					System.out.println();
					System.out.print("Please enter a surname: ");

					// Try Statement
					try {
						// Set Student Count Variable From Input
						studentNameTemp = keyboard.nextLine();

						// Retrieve Score For Name
						if(myList.retrieveScore(studentNameTemp) != -1) {
							// Print Score
							System.out.println("The score for this student is " + myList.retrieveScore(studentNameTemp));

							// Set Student Count Error
							studentName = 0;
						} else
							// Set Student Count Error
							studentName = -1;
					} catch(Exception e) {
						// Set Student Count Error
						studentName = -1;
					}
				} while (studentName == -1);
				break;
			case 3: // Create & Display Merit List
				// Create Merit List Object
				StudentList copy = myList.deepCopy();

				// Sort Merit List Object By Merit
				copy.meritSort();

				// Display List
				System.out.println();
				System.out.println("Merit List:");
				copy.displayList();
				break;
			case 4: // Quit
				System.out.println();
				System.out.println("Thank you for using Student List!");
				System.out.println("Quitting now...");
				break;
			}
		} while (optionSelect != 4);

		// Close Scanner
		keyboard.close();

		// Exit Program
		System.exit(0);
	}

	// Print Header
	public static void printHeader() {
		// Print Header
		System.out.println("######################################");
		System.out.println("## WELCOME TO THE STUDENT LIST DEMO ##");
		System.out.println("######################################");
	}
}
