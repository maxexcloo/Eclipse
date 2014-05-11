package comp125;

/**
 * @author Christophe Doche
 *
 */

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Weekly12Test 
{	

	@Test
	public void newParenthesisMatchingTest02() 
	{
		String str = "(]";
		assertEquals(false, Weekly12.newParenthesisMatching(str));
	}

	@Test
	public void newParenthesisMatchingTest03() 
	{
		String str = "[)";
		assertEquals(false, Weekly12.newParenthesisMatching(str));
	}

	@Test
	public void newParenthesisMatchingTest04() 
	{
		String str = "([)[";
		assertEquals(false, Weekly12.newParenthesisMatching(str));
	}	

	@Test
	public void newParenthesisMatchingTest05() 
	{
		String str = "())";
		assertEquals(false, Weekly12.newParenthesisMatching(str));
	}	

	@Test
	public void newParenthesisMatchingTest14() 
	{
		String str = "(()[([)())]()]";
		assertEquals(true, Weekly12.newParenthesisMatching(str));	
	}
	@Test
	public void newParenthesisMatchingTest16() 
	{
		String str = ")(";
		assertEquals(false, Weekly12.newParenthesisMatching(str));	
	}
}



