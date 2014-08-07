package comp125;

import java.util.Random;

public class Die 
{
	private int outcome;
	private Random generator = new Random();	
	
	public Die()
	{
		outcome = (1 + generator.nextInt(6));
	}

	public void reset()
	{
		outcome = (1 + generator.nextInt(6));		
	}
	
	public int show()
	{
		return outcome;
	}
}
