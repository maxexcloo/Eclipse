package comp125;

/**
 * @author Christophe Doche
 *
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SQDemo 
{	
	//Q2
	public static int RPN(String s)
	{
		Stack<Integer> stack = new Stack<Integer>();
		int index = 0, k = 0;

		for(int i = 0; i < s.length(); i++) 
		{
			index = i;
			k = 0;
			char c = s.charAt(i);
		
			//parsing the string to extract the numerical values
			if(c >= '0' && c <= '9')
			{
				while(s.charAt(i + k) != ' ')
					k++;				
				stack.push(Integer.parseInt(s.substring(index, index + k)));
				i = index + k;
			}
	
			if(c == '+') 
				stack.push(stack.pop() + stack.pop());
			else if (c == '*') 
				stack.push(stack.pop() * stack.pop());
		}
		return(stack.pop());
	}
	
	//Q4
	public static int countAndShow(Queue<Integer> pipe)
	{
			
	}

	//Q5
	public static Queue<Integer> reverseQueue(Queue<Integer> pipe)
	{

	}
	
	public static void main(String[] args) 
	{
		//Q1

	}
}
