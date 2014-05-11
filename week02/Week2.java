package comp125;
import java.util.Scanner;

/**
 * Class to find the sum of the positive integer exact divisors of a given positive integer
 * n which are less than n; and to thereby determine whether or not n is a perfect number.
**/
public class Week2 {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter a positive integer:");
		int number = keyboard.nextInt();
		keyboard.close();
		System.out.println("The sum of the positive integer exact divisors of " + number + " which are less than " + number + " is " + sumDivisors(number) + ".");
		if(sumDivisors(number) == number)
			System.out.println("Therefore " + number + " is a perfect number.");
		else
			System.out.println("Therefore " + number + " is not a perfect number.");
		System.exit(0);
	}

	/**
	 * Computes the sum of the positive integer exact divisors of n less than n.
	 * Precondition: n >= 1.
	 * Postcondition: The value returned is the sum of the positive int exact divisors of n
	 *                which are less than n.
	**/
	public static int sumDivisors(int n) {
		int output = 0;
		for(int i = 1; i < n; i++) {
			if(n % i == 0)
				output += i;
		}
		return output;
	}
}
