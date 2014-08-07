package comp125;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.Test;

public class BagTestA {

	public static boolean isEqual(ArrayList<Boolean> list1, ArrayList<Boolean> list2)
	{
		if(list1.size() != list2.size())
			return false;
		else
			for(int i = 0; i < list1.size(); i++)
				if(list1.get(i) != list2.get(i))
					return false;	

		return true;					
	}

	@Test
	public void testDeliverable01() 
	{
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();

		Item item = new Item(15, 51);
		totalListOfItems.add(item);		

		Bag bag = new Bag(60);
		ArrayList<Boolean> selection = new ArrayList<Boolean>();

		selection.add(true);

		bag.pickMostExpensiveFirst(totalListOfItems);
		assertTrue(isEqual(bag.getMostExpensiveFirstSelection(), selection));
	}

	@Test
	public void testDeliverable02() 
	{
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();

		Item item = new Item(15, 51);
		totalListOfItems.add(item);		

		Bag bag = new Bag(50);
		ArrayList<Boolean> selection = new ArrayList<Boolean>();

		selection.add(false);

		bag.pickMostExpensiveFirst(totalListOfItems);
		assertTrue(isEqual(bag.getMostExpensiveFirstSelection(), selection));
	}

	@Test
	public void testDeliverable03() 
	{
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();

		Item item = new Item(15, 51);
		totalListOfItems.add(item);	
		item = new Item(35, 22);
		totalListOfItems.add(item);	
		item = new Item(3, 12);
		totalListOfItems.add(item);	

		Bag bag = new Bag(100);
		ArrayList<Boolean> selection = new ArrayList<Boolean>();

		selection.add(true);
		selection.add(true);
		selection.add(true);

		bag.pickMostExpensiveFirst(totalListOfItems);
		assertTrue(isEqual(bag.getMostExpensiveFirstSelection(), selection));
	}

	@Test
	public void testDeliverable04() 
	{
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();

		Item item = new Item(15, 51);
		totalListOfItems.add(item);	
		item = new Item(35, 22);
		totalListOfItems.add(item);	
		item = new Item(3, 12);
		totalListOfItems.add(item);	

		Bag bag = new Bag(10);
		ArrayList<Boolean> selection = new ArrayList<Boolean>();

		selection.add(false);
		selection.add(false);
		selection.add(false);

		bag.pickMostExpensiveFirst(totalListOfItems);
		assertTrue(isEqual(bag.getMostExpensiveFirstSelection(), selection));
	}

	@Test
	public void testDeliverable05() 
	{
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();

		Item item = new Item(15, 51);
		totalListOfItems.add(item);	
		item = new Item(35, 22);
		totalListOfItems.add(item);	

		Bag bag = new Bag(60);
		ArrayList<Boolean> selection = new ArrayList<Boolean>();

		selection.add(false);
		selection.add(true);

		bag.pickMostExpensiveFirst(totalListOfItems);
		assertTrue(isEqual(bag.getMostExpensiveFirstSelection(), selection));
	}

	@Test
	public void testDeliverable06() 
	{
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();

		Item item = new Item(35, 22);
		totalListOfItems.add(item);	
		item = new Item(15, 51);
		totalListOfItems.add(item);	

		Bag bag = new Bag(60);
		ArrayList<Boolean> selection = new ArrayList<Boolean>();

		selection.add(true);
		selection.add(false);

		bag.pickMostExpensiveFirst(totalListOfItems);
		assertTrue(isEqual(bag.getMostExpensiveFirstSelection(), selection));
	}

	@Test
	public void testDeliverable07() 
	{
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();

		Item item = new Item(35, 45);
		totalListOfItems.add(item);		
		item = new Item(22, 28);
		totalListOfItems.add(item);	
		item = new Item(17, 26);
		totalListOfItems.add(item);	
		item = new Item(11, 3);
		totalListOfItems.add(item);	

		Bag bag = new Bag(60);
		ArrayList<Boolean> selection = new ArrayList<Boolean>();

		selection.add(true);
		selection.add(false);
		selection.add(false);
		selection.add(true);

		bag.pickMostExpensiveFirst(totalListOfItems);
		assertTrue(isEqual(bag.getMostExpensiveFirstSelection(), selection));
	}

	@Test
	public void testDeliverable08() 
	{

		ArrayList<Item> totalListOfItems = new ArrayList<Item>();

		Item item = new Item(22, 28);
		totalListOfItems.add(item);
		item = new Item(11, 3);
		totalListOfItems.add(item);	
		item = new Item(35, 45);
		totalListOfItems.add(item);	
		item = new Item(17, 26);
		totalListOfItems.add(item);	

		Bag bag = new Bag(60);
		ArrayList<Boolean> selection = new ArrayList<Boolean>();

		selection.add(false);
		selection.add(true);
		selection.add(true);
		selection.add(false);

		bag.pickMostExpensiveFirst(totalListOfItems);
		assertTrue(isEqual(bag.getMostExpensiveFirstSelection(), selection));
	}

}
