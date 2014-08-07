package comp125;

import java.util.ArrayList;

public class dummy 
{
	public static void main(String[] args) 
	{		
		// declare myList and set the capacity to 10
		ArrayList<String> myList = new ArrayList<String>(10);
	
		myList.add(0, "Hello");
		myList.add(1, "nice break");			
		myList.add(2, "COMP125");		
		myList.add(3, "Java");
		
		System.out.println(myList.get(0) + " " + myList.get(1) + " " + myList.get(2) + " " + myList.get(3));	
		
		myList.remove(0);
		System.out.println("Size of the list: " + myList.size());		

		myList.set(1, "back to uni");
		myList.set(2, myList.get(2) + " is great");
		myList.add(0, "Had");
		
		System.out.println(myList.get(0) + " " + myList.get(1) + " " + myList.get(2) + " " + myList.get(3));					  
	}
}
