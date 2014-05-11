package comp125;

/**
 * This class implements dates
 * @author Diego Molla (modified by Scott M.)
 */
public class Date {
    private int month; 
    private int day;
    private int year;
    
    /**
     * Default constructor
     */
    public Date() {
    	month = 1;
    	day = 1;
    	year = 2000;
    }
    
    /**
     * Constructor with parameters
     * @param theDay
     * @param theMonth
     * @param theYear
     */
    public Date(int theDay, int theMonth, int theYear){
    	setDate(theDay,theMonth,theYear);
    }
    
    /**
     * Represent the date as a string
     */
    public String toString() {
        return(day + "/" + month + "/" + year); 
    }
    
    /**
     * Compare dates
     * @param date
     * @return true if the date parameter is equal to the internal date
     */
    public boolean equals(Date date) {
    	return (day == date.day && month == date.month && year == date.year);
    }
    
    /**
     * Set the date
     * @param theDay
     * @param theMonth
     * @param theYear
     */
    public void setDate(int theDay, int theMonth, int theYear) {
    	// Set Year
    	year = theYear;
    	
    	// Set Month
    	if (theMonth < 1) {
    		month = 1;
    	} else if (theMonth > 12) {
    		month = 12;
    	} else {
    		month = theMonth;
    	}
    	
    	// Set Day
    	if (theDay < 1) {
    		day = 1;
    	} else if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && theDay > 31) {
    		day = 31;
    	} else if ((month == 4 || month == 6 || month == 9 || month == 11) && theDay > 30) {
    		day = 30;
    	} else if (month == 2 && theDay > 28) {
    		day = 28;
    	} else {
    		day = theDay;
    	}
    }
    
    /**
     * Get the day
     * @return the value of the day
     */
    public int getDay() {
    	return day;
    }
    
    /**
     * Get the month
     * @return the string representing the month
     */
    public int getMonth() {
    	return month;
    }
    
    /**
     * Get the year
     * @return the value of the year
     */
    public int getYear() {
    	return year;
    }
        
    public static final void main(String[] args) {
    	Date date1 = new Date(12,8,2013);
    	Date date2 = new Date(13,8,2013);
    	if (date1.equals(date2)) {
    		System.out.println("The two dates are the same");
    	} else {
    		System.out.println("Date " + date1.toString() + " differs from " + date2.toString());
    		System.out.println("Date " + date1 + " differs from " + date2);
    	}
    }
}
