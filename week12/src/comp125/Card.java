package comp125;

/**
 * @author Christophe Doche
 *
 */

import java.util.Random;

public class Card 
{
	private String face;
	private String suit;
	
	Random generator = new Random();

	public Card()
	{
		face = "1";
		suit = "Clubs";
	}
		
	public Card(String myFace, String mySuit)
	{
		face = myFace;
		suit = mySuit;
	}
	
	public void setRandom()
	{
		String[] suits = {"Clubs", "Spades", "Hearts", "Diamonds"};
		String[] faces = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};		
		suit = suits[generator.nextInt(4)];
		face = faces[generator.nextInt(13)];
	}
	
	public void display()
	{
		System.out.println(face + " of " + suit);
	}		
}
