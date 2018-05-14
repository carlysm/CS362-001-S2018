package calendar;

import java.util.*;
import calendar.Appt;
import calendar.CalDay;
import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {

	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void randomtest()  throws Throwable  {


					 long startTime = Calendar.getInstance().getTimeInMillis();
					 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

					 System.out.println("Start testing...");

					try{
						for (int iteration = 0; elapsed < TestTimeout; iteration++) {
							//long randomseed =System.currentTimeMillis();
							//Random random = new Random(randomseed);
						   Random random = new Random(0);

							int numAppts = ValuesGenerator.getRandomIntBetween(random, 1, 3);
							int startDay=ValuesGenerator.getRandomIntBetween(random, 1, 31);
							int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 12);
							int startYear=ValuesGenerator.getRandomIntBetween(random, 0, 2018);

							LinkedList<Appt> appts = new LinkedList<Appt>();

							if(startDay < CalendarUtil.NumDaysInMonth(startYear, startMonth -1) + 1){

									GregorianCalendar cal = new GregorianCalendar(startYear, startMonth - 1, startDay);
							    CalDay day1 = new CalDay(cal);

									for (int i = 1; i < numAppts; i++){
										 int startHour=ValuesGenerator.getRandomIntBetween(random, -1, 30);
										 int startMinute=ValuesGenerator.getRandomIntBetween(random, -1, 70);
										 String title="Birthday Party";
										 String description="This is my birthday party.";
										 String emailAddress="xyz@gmail.com";

										 //Construct a new Appointment object with the initial data
								     Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
										 appt.setValid();

										 day1.addAppt(appt);

										 if(startHour > -1 && startHour < 24 && startMinute > -1 && startMinute < 60){
											 appts.add(appt);
										 }
								 }
								 assertEquals(appts.size(), day1.getAppts().size());
							}


							 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
						        if((iteration%10000)==0 && iteration!=0 )
						              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

						}
					}catch(NullPointerException e){

					}

					 System.out.println("Done testing...");

	 }
}
