package comp125;

import java.util.ArrayList;

public class Date 
{
	private int day;
	private int month;
	
	public Date()
	{
		day = 1;
		month = 1;
	}
	
	public Date(int d, int m)
	{
		day = d;
		month = m;
	}
	
	public void set(int d, int m)
	{
		day = d;
		month = m;
	}
	
	public int getDay()
	{
		return day;
	}

	public void showDate()
	{
		System.out.println(day + "/" + month);		
	}
	
	public static void main(String[] args) 
	{		
		ArrayList<Date> list = new ArrayList<Date>(10);
		Date object0 = new Date(1, 1);
		Date object1 = new Date(3, 4);		
		Date object2 = new Date(6, 12);		
		
		list.add(0, object0);
		list.add(1, object1);
		list.add(2, object2);
			
		list.get(0).showDate();
		list.get(1).showDate();		
		list.get(2).showDate();					  
	}
}