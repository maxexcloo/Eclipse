package comp125;

import java.util.ArrayList;

public class ListOfDiceThrows 
{
	ArrayList<Integer> list = new ArrayList<Integer>();

	public ListOfDiceThrows()
	{
		
	}
	
	public ListOfDiceThrows(int n)
	{
		Die dice1, dice2;
		dice1 = new Die();
		dice2 = new Die();

		for(int i = 0; i < n; i++)
		{
			list.add(dice1.show() + dice2.show());
			dice1.reset();
			dice2.reset();
		}
	}
	
	public void numberOfOccurrences()
	{
		int size = list.size(); 
		int[] nbOfOutcomes = new int[13];
		for(int i = 0; i < size; i++)
			nbOfOutcomes[list.get(i).intValue()]++;
		
		for(int j = 2; j <= 12; j++)
		{
			System.out.println("Outcome " + j + " = " + nbOfOutcomes[j] + " out of " + size);
		}
	}
	
	public static void main(String[] args) 
	{
		int numberOfExperiments = 100000;
		
		ListOfDiceThrows myList = new ListOfDiceThrows(numberOfExperiments);
		myList.numberOfOccurrences();
		  
	}
}