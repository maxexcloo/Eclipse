package comp125;

import java.util.Random;

public class Job {
	private int startDay;
	private int endDay;
	
	// default constructor
	public Job()
	{
		startDay = 1;
		endDay = 1;		
	}
	
	// constructor to initialise startDay and endDay with random values
	public Job(int startDayBound, int endDayBound, Random generator)
	{
		while(true)
		{
			startDay =  1 + generator.nextInt(startDayBound);
			endDay = 1 + generator.nextInt(endDayBound);
			if(startDay <= endDay)
				break;
		}
	}
		
	public Job(int myStartDay, int myEndDay, int limit)
	{
		if(startDay <= endDay && endDay <= limit)
		{
			startDay = myStartDay;
			endDay = myEndDay;
		}
		else 
		{
			startDay = 1;
			endDay = 1;				
		}
	}

	public int getStartDay()
	{
		return startDay;
	}

	public int getEndDay()
	{
		return endDay;
	}

	public void displayConstraint()
	{
		System.out.print(" must be done between day " + startDay + " and day " + endDay);	
	}
}

