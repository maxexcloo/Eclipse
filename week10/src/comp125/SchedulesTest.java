package comp125;

import static org.junit.Assert.*;
import org.junit.Test;

public class SchedulesTest {


   @Test(timeout=2000) // terminates this test after 2s if still running
   public void testSchedules01() 
   {
      Schedules schedules = new Schedules(4);
      schedules.setJobConstraints(0, 1, 1);
      schedules.setJobConstraints(1, 1, 1);
      schedules.setJobConstraints(2, 3, 3);
      schedules.setJobConstraints(3, 4, 4);
      
      assertTrue("The outcome should be 0, but your method returns something else", schedules.countAcceptableSchedules() == 0);
   }	

@Test(timeout=2000)
   public void testSchedules04() 
   {
      Schedules schedules = new Schedules(6);
      schedules.setJobConstraints(0, 1, 1);
      schedules.setJobConstraints(1, 2, 2);
      schedules.setJobConstraints(2, 3, 3);
      schedules.setJobConstraints(3, 4, 4);
      schedules.setJobConstraints(4, 5, 5);
      schedules.setJobConstraints(4, 6, 6);
      
      assertTrue("The outcome should be 1, but your method returns something else", schedules.countAcceptableSchedules() == 1);
   }

@Test(timeout=2000)
   public void testSchedules06() 
   {
      Schedules schedules = new Schedules(5);
      schedules.setJobConstraints(0, 1, 2);
      schedules.setJobConstraints(1, 2, 3);
      schedules.setJobConstraints(2, 3, 4);
      schedules.setJobConstraints(3, 4, 5);
      schedules.setJobConstraints(4, 1, 5);
      
      assertTrue("The outcome should be 5, but your method returns something else", schedules.countAcceptableSchedules() == 5);
   }
}
