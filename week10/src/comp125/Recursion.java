package comp125;

/**
 * @author Christophe Doche
 *
 */

import java.util.ArrayList;

public class Recursion 
{		
	//Q1
	public static int sumEvenOrOdd(int n) 
	{
	  if(n <= 1)
	    return 1;
	  else if(n%2 == 0) 
	    return n + sumEvenOrOdd(n/2);
	  else   
	    return n + sumEvenOrOdd(n + 1); 
	}

	//Q2
	/*
	public static int findMaxAux(ArrayList<Integer> list, int currentMax)
	{

	}
	
 
	public static int findMax(ArrayList<Integer> list)
	{
	  if(list.size() > 0) 
	  {
	    int currentMax = list.get(0);
	    list.remove(0);
	    return findMaxAux(list, currentMax);
	  }
	  else   
	    return -1;
	}
	*/
	
	//Q3
	public static void permuteRec(ArrayList<Integer> list1, ArrayList<Integer> list2)
	{
		if(list1.isEmpty())
		{
			for(int k = 0; k < list2.size(); k++)
				System.out.print(list2.get(k) + " ");
			System.out.println();
		}
		else
		{
			for(int i = 0; i < list1.size(); i++)
			{

				ArrayList<Integer> tmp2 = new ArrayList<Integer>();
				for(int k = 0; k < list2.size(); k++)
					tmp2.add(list2.get(k));				
				
				tmp2.add(list1.get(i));
				
				ArrayList<Integer> tmp1 = new ArrayList<Integer>();
				for(int k = 0; k < list1.size(); k++)
					tmp1.add(list1.get(k));
				
				tmp1.remove(i);
				
				permuteRec(tmp1, tmp2);	
			}
		}		
	}
		

	//Q4	
	//auxiliary recursive method used by rPermute and similar to permuteRec
	public void rPermuteRec()
	{

	}
	
	
	public void rPermute(ArrayList<Character> list, int r)
	{		

	}
		
	public static void main(String[] args) 
	{
		System.out.println(sumEvenOrOdd(5));
		
		/*
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();

		list1.add(1);
		list1.add(2);
		list1.add(3);
		
		permuteRec(list1, list2);		
		 */
				
		// System.out.println(findMax(list1));	
		
		ArrayList<Character> list = new ArrayList<Character>();
		list.add('t');
		list.add('o');
		list.add('w');
		list.add('n');
		
		Recursion recursion = new Recursion();
		recursion.rPermute(list, 2);
	}
}
