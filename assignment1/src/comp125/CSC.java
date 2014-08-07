/**
 * Max Schaefer (43263798)
 * 18/08/2013
 */

/**
 * Template for a class to allow a user to calculate a card security code (CSC)
 * for a given credit card number, block length and modulus.
 */

package comp125;
import java.util.Scanner;

public class CSC {
	/**
	 * The main method reads a credit card number entered by the user;
	 * main also reads the block length and modulus.
	 * 
	 * Then main calls an incomplete version of cardSecCode, which you have to complete.
	 * Once cardSecCode is completed, this call will calculate the card security code (CSC) for the given
	 * inputs. Finally main displays the CSC.
	 */
	public static void main(String[] args) {
		// Initialize Variables
		int b = 0;
		int m = 0;
		String cardNum = null;

		// Initialize Scanner
		Scanner keyboard = new Scanner(System.in);

		// Input Validation Loop For Card Number
		do {
			// Check Variable Status
			if (cardNum != null)
				// Show Invalid Entry Message
				System.out.println("The number you entered was invalid. Please try again.");

			// Prompt For Keyboard Input
			System.out.println("Please enter a valid credit card number (digits only):");
			// Set Card Number Variable From Input
			cardNum = keyboard.nextLine();
		} while (hasNonDigit(cardNum));

		// Input Validation Loop For Block Length
		do {
			// Check Variable Status
			if (b != 0)
				// Show Invalid Entry Message
				System.out.println("The block length you entered was invalid. The block length must be a positive integer under 10.");

			// Prompt For Keyboard Input
			System.out.println("Please enter the desired block length:");
			// Set Block Length Variable From Input
			b = keyboard.nextInt();
		} while (b <= 0 || b >= 10);

		// Input Validation Loop For Modulus
		do {
			// Check Variable Status
			if (m != 0)
				// Show Invalid Entry Message
				System.out.println("The modulus you entered was invalid. The modulus must be a positive integer.");

			// Prompt For Keyboard Input
			System.out.println("Please enter the desired modulus:");
			// Set Modulus Variable From Input
			m = keyboard.nextInt();
		} while (m <= 0);

		// Calculate CSC From Variables
		int csc = cardSecCode(cardNum, b, m);
		// Print CSC To Console
		System.out.println("The CSC for your card number is " + csc + ".");

		// Close Scanner
		keyboard.close();
	}

	/**
	 * Checks whether or not a given string contains a non-decimal-digit character.
	 * Precondition: givenString is a string of characters.
	 * Postcondition: the value returned is true if a non-decimal-digit character
	 *                is present in givenString; and false otherwise.
	 */
	public static boolean hasNonDigit(String givenString) {
		// Initialize Return Boolean
		boolean isNonDigit = false;

		// Loop Through String Characters
		for (int i = 0; i < givenString.length(); i++) {
			// Initialize Character Variable
			char x = givenString.charAt(i);

			// Test If Character Variable An Integer
			if (!(x >= '0' && x <= '9'))
				// Set Return Boolean
				isNonDigit = true;
		}

		// Return Result
		return isNonDigit;
	}

	/**
	 * Calculates the CSC for a given card number, block length b and modulus m.
	 * Precondition: cardNum is a valid credit card number (comprising decimal digits only),
	 *               b is a positive integer at most 9,
	 *               m is a positive integer (int).
	 * Postcondition: the value returned is the CSC for cardNum, using
	 *                parameters b and m.
	 */
	public static int cardSecCode(String cardNum, int b, int m) {
		// Initialize Return Integer
		int sum = 0;

		// Loop Through Block Length Substrings In Card Number
		for (int i = 0; i < cardNum.length(); i += b)
			// Check For Range Remainder
			if (i + b <= cardNum.length()) {
				// Initialize Substring Variable
				String x = cardNum.substring(i, i + b);

				// Add Value To Sum
				sum += toInt(x);
			}

		// Return Result
		return sum % m;
	}


	/**
	 * Converts a string comprising decimal digit characters into the integer (of type int)
	 * it represents.
	 * Precondition: digitString is a string comprising decimal digit characters
	 *               which represents a non-negative integer (int).
	 * Postcondition: the value returned is the integer (int) represented by digitString.
	 */
	public static int toInt(String digitString) {
		// Initialize Return Integer
		int answer = 0;

		// Loop Through String Characters
		for (int i = 0; i < digitString.length(); i++) {
			// Initialize Character Variable
			int x = digitString.charAt(i) - '0';

			// Add Value To Sum
			answer = answer * 10 + x;
		}

		// Return Result
		return answer;
	}
}
