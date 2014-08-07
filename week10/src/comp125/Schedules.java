package comp125;

import java.util.ArrayList;
import java.util.Random;

public class Schedules {
			
	private int numberOfDays; // n
	
	private int counter; // to record the number of acceptable schedules 
	
	private ArrayList<Job> listOfJobs; // to store the list of all the jobs 

	private ArrayList<Integer> schedule; // to store a schedule, i.e. a particular sequence of jobs 

	//default constructor, initialises one job over one day
	public Schedules()
	{
		counter = 0;
		numberOfDays = 1;
		listOfJobs = new ArrayList<Job>();
		schedule = new ArrayList<Integer>();
		for(int i = 0; i < numberOfDays; i++)
		{
			schedule.add(0);
			Job job = new Job(1, 1, 1);
			listOfJobs.add(job);
		}
	}

	// constructor initialising a list of n jobs without any constraint
	public Schedules(int n)
	{
		counter = 0; // to count the number of acceptable schedules
		numberOfDays = n;
		listOfJobs = new ArrayList<Job>();
		schedule = new ArrayList<Integer>();
		for(int i = 0; i < n; i++)
		{
			schedule.add(0);
			Job job = new Job(1, n, n);
			listOfJobs.add(job);
		}
	}
	
	// constructor initialising a list of n jobs with random values 
	public Schedules(int n, Random generator)
	{
		counter = 0; // to count the number of acceptable schedules
		numberOfDays = n;
		listOfJobs = new ArrayList<Job>();
		schedule = new ArrayList<Integer>();
		for(int i = 0; i < n; i++)
		{
			schedule.add(0);
			Job job = new Job(n, n, generator);
			listOfJobs.add(job);
		}
	}
	
	public void setJobConstraints(int i, int startDay, int endDay)
	{
		Job job = new Job(startDay, endDay, numberOfDays);
		listOfJobs.set(i, job);
	}
	
	public void showAllConstraints()
	{
		for(int i = 0; i < numberOfDays; i++)
		{
			System.out.print("Job " + i);
			listOfJobs.get(i).displayConstraint();
			System.out.println();
		}		
	}
	
	// when given a schedule (represented by list2) this method returns true if and only if
	// all the constraints are satisfied and false otherwise
	public boolean isAcceptableSchedule(ArrayList<Integer> list2)
	{
		Job currentJob;		
		for(int i = 1; i <= list2.size(); i++)
		{
			currentJob = listOfJobs.get(list2.get(i - 1));
			if(currentJob.getStartDay() > i || currentJob.getEndDay() < i)
				return false;
		}
		
		return true;		
	}

	private int permuteCount = 0;
	
	public void permuteRec(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		if(list1.isEmpty()) {
			if(isAcceptableSchedule(list2))
				permuteCount++;
		} else {
			for(int i = 0; i < list1.size(); i++) {
				ArrayList<Integer> tmp1 = new ArrayList<Integer>();
				for(int k = 0; k < list1.size(); k++)
					tmp1.add(list1.get(k));

				ArrayList<Integer> tmp2 = new ArrayList<Integer>();
				for(int k = 0; k < list2.size(); k++)
					tmp2.add(list2.get(k));				

				tmp2.add(tmp1.remove(i));				

				permuteRec(tmp1, tmp2);
			}
		}	
	}

	public int countAcceptableSchedules() {
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		for(int i = 0; i < listOfJobs.size(); i++)
			arr1.add(i);
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		
		permuteRec(arr1, arr2);
		
		return permuteCount;
	}
	
	public static void main(String[] args) 
	{
		Random generator = new Random(123); // use a seed to get always the same Jobs and constraints generated
		
		Schedules schedules = new Schedules(7, generator);
		schedules.showAllConstraints();
		System.out.println(schedules.countAcceptableSchedules());	
		
		schedules = new Schedules(5, generator);
		schedules.setJobConstraints(0, 1, 2);
		schedules.setJobConstraints(1, 2, 3);
		schedules.setJobConstraints(2, 3, 4);
		schedules.setJobConstraints(3, 4, 5);
		schedules.setJobConstraints(4, 1, 5);
		
		schedules.showAllConstraints();
		System.out.println(schedules.countAcceptableSchedules());		
	}		
}
