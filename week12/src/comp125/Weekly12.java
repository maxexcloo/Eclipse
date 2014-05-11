package comp125;

/**
 * @author Christophe Doche
 *
 */

import java.util.Stack;

public class Weekly12 
{
	
	public static boolean parenthesisMatching(String s)
	{
		Stack<Character> stack = new Stack<Character>();
		
		char c;
		for(int i = 0; i < s.length(); i++) 
		{
			c = s.charAt(i);
			
			if(c == '(')
				stack.push(c);				
			
			if(c == ')')
				if(stack.empty())
					return false;
				else if(stack.peek() == '(')
					stack.pop();
				else 
					return false;
		}
		return stack.empty();
	}
	
	public static boolean newParenthesisMatching(String s) {
		int count1a = 0;
		int count1b = 0;
		int count2a = 0;
		int count2b = 0;
		int count3a = 0;
		int count3b = 0;

		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '(')
				count1a++;

			if (c == ')' && count1a > 0)
				count1b++;

			if (c == '{')
				count2a++;

			if (c == '}' && count2a > 0)
				count2b++;

			if (c == '[')
				count3a++;

			if (c == ']' && count3a > 0)
				count3b++;
		}

		return (count1a == count1b && count2a == count2b && count3a == count3b);
	}

	public static void main(String[] args) 
	{		
		String str = "([])"; 
		System.out.println(newParenthesisMatching(str));			
	}
}
