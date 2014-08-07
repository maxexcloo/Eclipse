package comp125;

import java.util.ArrayList;
import java.util.Random;

/**
 * Template of class Bag for assignment 3
 * @author: Max Schaefer
 * @student number: 43263798
 */

public class Bag 
{
	private int weightCapacity; // the maximal weight that a bag can carry

	private ArrayList<Boolean> mostExpensiveFirstSelection;	// selection of items corresponding to strategy A
	private ArrayList<Boolean> optimalSelection;            // selection of items corresponding to strategy B
	
	private int valueMostExpensiveFirstSelection;  // total value of items picked with strategy A 
	private int valueOptimalSelection;			   // total value of items picked with strategy B 

	private int weightOptimalSelection;            // combined weight of items picked with strategy B 

	
	/********************************************************/
	/*                        Do not                        */
	/*                        modify                        */   
	/*                     the following                    */ 
	/*                        methods                       */
	/********************************************************/
	
	public Bag()
	{
		weightCapacity = 1;
		
		mostExpensiveFirstSelection = new ArrayList<Boolean>();
		optimalSelection = new ArrayList<Boolean>();
		
		valueMostExpensiveFirstSelection = 0;
		valueOptimalSelection = 0;	
	}
		
	public Bag(int myWeightCapacity)
	{
		weightCapacity = myWeightCapacity;
		
		mostExpensiveFirstSelection = new ArrayList<Boolean>();
		optimalSelection = new ArrayList<Boolean>();
		
		valueMostExpensiveFirstSelection = 0;
		valueOptimalSelection = 0;
	}
	
	/**
	 * @returns a deep copy of the list mostExpensiveFirstSelection
	 */
	public ArrayList<Boolean> getMostExpensiveFirstSelection()
	{	
		ArrayList<Boolean> deepCopy = new ArrayList<Boolean>();
		for(int i = 0; i < mostExpensiveFirstSelection.size(); i++)
			deepCopy.add(mostExpensiveFirstSelection.get(i));
		return deepCopy;
	}

	/**
	 * @returns a deep copy of the list optimalSelection
	 */
	public ArrayList<Boolean> getOptimalSelection()
	{
		ArrayList<Boolean> deepCopy = new ArrayList<Boolean>();
		for(int i = 0; i < optimalSelection.size(); i++)
			deepCopy.add(optimalSelection.get(i));

		return deepCopy;
	}
	
	public int getValueMostExpensiveFirstSelection()
	{	
		return valueMostExpensiveFirstSelection;
	}

	public int getValueOptimalSelection()
	{	
		return valueOptimalSelection;
	}
	
	public int getWeightOptimalSelection()
	{	
		return weightOptimalSelection;
	}

	/*
	 * I have commented below as documentation.
	 * 
	 * @param totalListOfItems
	 * @complexity in the worst case: N^2
	 */
	public void pickMostExpensiveFirst(ArrayList<Item> totalListOfItems) {
		// Initialize Variables
		int bagWeight = 0;
		int bottomWeight = 0;
		int topWeight = 0;

		// Loop Through All Items
		for(int i = 0; i < totalListOfItems.size(); i++) {
			// Add False To Expensive Selection List
			mostExpensiveFirstSelection.add(false);
			
			// Check Top Weight
			if(totalListOfItems.get(i).getWeight() > topWeight)
				// Set Top Weight
				topWeight = totalListOfItems.get(i).getWeight();

			// Reset Variables
			bottomWeight = topWeight;

			// Test Item Selection Status & Weight
			if(totalListOfItems.get(i).getWeight() < bottomWeight)
				// Set Bottom Weight
				bottomWeight = totalListOfItems.get(i).getWeight();
		}
		
		// Check Weight
		while(weightCapacity >= bagWeight + bottomWeight) {
			// Initialize Variables
			int currentSelection = 0;
			int topValue = 0;

			// Reset Variables
			bottomWeight = topWeight;

			// Loop Through All Items
			for(int i = 0; i < totalListOfItems.size(); i++) {
				// Test Item Selection Status, Value & Weight
				if(!mostExpensiveFirstSelection.get(i) && totalListOfItems.get(i).getValue() > topValue && bagWeight + totalListOfItems.get(i).getWeight() <= weightCapacity) {
					// Set Current Selection
					currentSelection = i;
					
					// Set Top Value
					topValue = totalListOfItems.get(i).getValue();
				}
			}

			// Loop Through All Items
			for(int i = 0; i < totalListOfItems.size(); i++)
				// Test Item Selection Status & Weight
				if(!mostExpensiveFirstSelection.get(i) && totalListOfItems.get(i).getValue() == topValue && totalListOfItems.get(i).getWeight() < totalListOfItems.get(currentSelection).getWeight())
					// Set Current Value
					currentSelection = i;
			
			// Set Current Selection True
			mostExpensiveFirstSelection.set(currentSelection, true);
			
			// Add To Bag Weight
			bagWeight += totalListOfItems.get(currentSelection).getWeight();
			
			// Loop Through All Items
			for(int i = 0; i < totalListOfItems.size(); i++)
				// Test Item Selection Status & Weight
				if(!mostExpensiveFirstSelection.get(i) && totalListOfItems.get(i).getWeight() < bottomWeight)
					// Set Bottom Weight
					bottomWeight = totalListOfItems.get(i).getWeight();
		}
	}
	
	/*
	 * I have commented below as documentation.
	 * 
	 * @param totalListOfItems
	 * @complexity in the worst case: N*weightCapacity
	 */
	public void findOptimalItems(ArrayList<Item> totalListOfItems) {
		// Create & Prepend Temporary List Item
		Item item = new Item();
		item.setValueWeight(0, 0);
		totalListOfItems.add(0, item);

		// Loop Through All Items
		for(int i = 0; i < totalListOfItems.size() - 1; i++)
			// Add False To Optimal Selection List
			optimalSelection.add(false);

		// Maximum Profit Of Selected Items With Weight Limit
		int[][] option = new int[totalListOfItems.size()][weightCapacity + 1];

		// Does Solution Include Item
		boolean[][] include = new boolean[totalListOfItems.size()][weightCapacity + 1];

		// Loop Through All Items
		for (int i = 1; i <= totalListOfItems.size() - 1; i++) {
			// Loop Through Allowed Weights
			for (int j = 0; j <= weightCapacity; j++) {
				// Initialize Unselected Item
				int unselected = option[i - 1][j];

				// Initialize Selected Item
				int selected = Integer.MIN_VALUE;
				
				// Check Item Weight
				if (totalListOfItems.get(i).getWeight() <= j)
					// Set Selected Item
					selected = totalListOfItems.get(i).getValue() + option[i - 1][j - totalListOfItems.get(i).getWeight()];

				// Set Option To Largest Valued Option
				option[i][j] = Math.max(unselected, selected);
				
				// Set Include True If Selected Item Bigger Than Unselected Item
				include[i][j] = (selected > unselected);
			}
		}

		// Loop Through All Items & Set Start Weight
		for (int i = totalListOfItems.size() - 1, j = weightCapacity; i > 0; i--) {
			// Check Item Include State
			if (include[i][j]) {
				// Set True On Optimal Selection List
				optimalSelection.set(i - 1, true);
				
				// Subtract Weight
				j -= totalListOfItems.get(i).getWeight();
			}
		}
		
		// Remove Temporary Prepended List Item  
		totalListOfItems.remove(0);

		// Print Array
		//System.out.println(totalListOfItems);
	}

	public static void main(String[] args) 
	{
		ArrayList<Item> totalListOfItems = new ArrayList<Item>(); // list containing all the items to choose from 

		Random generator = new Random(123); // use a seed to produce the same random items

		Item item;
		for(int i = 0; i < 5; i++)
		{
			item = new Item();
			item.setRandomItem(15, 10, generator);
			totalListOfItems.add(item);
			System.out.println("Item " + i + ": value and weight are " + item.getValue() + " and " + item.getWeight());
		}
		
		System.out.println();
		Bag bag = new Bag(50);  // this bag has a weightCapcity of 50 
		
		bag.pickMostExpensiveFirst(totalListOfItems); // updates mostExpensiveFirstSeelction
			
		int totalWeight = 0, totalValue = 0;
		
		System.out.println("pickMostExpensiveFirst()");
		ArrayList<Boolean> selection =  bag.getMostExpensiveFirstSelection();
		
		for(int i = 0; i < selection.size(); i++)
		{
			System.out.print(selection.get(i) + " ");
			if(selection.get(i))
			{
				totalValue += totalListOfItems.get(i).getValue();
				totalWeight += totalListOfItems.get(i).getWeight();
			}
		}
		System.out.println();
		System.out.println("Total Value: " + totalValue +  " and total weight: " + totalWeight);

		System.out.println();
		System.out.println("findOptimalSelection()");
		long start = System.nanoTime();
		bag.findOptimalItems(totalListOfItems);
		long timeTaken = System.nanoTime() - start;
		
		totalWeight = 0;
		totalValue = 0;

		//selection =  bag.getMostExpensiveFirstSelection();
		selection =  bag.getOptimalSelection();
		
		for(int i = 0; i < selection.size(); i++)
		{
			System.out.print(selection.get(i) + " ");
			if(selection.get(i))
			{
				totalValue += totalListOfItems.get(i).getValue();
				totalWeight += totalListOfItems.get(i).getWeight();
			}
		}
		System.out.println();
		System.out.println("Total Value: " + totalValue +  " and total weight: " + totalWeight);
        System.out.println("Time used: " + timeTaken/1000000. + "µs"); 
	}	
}