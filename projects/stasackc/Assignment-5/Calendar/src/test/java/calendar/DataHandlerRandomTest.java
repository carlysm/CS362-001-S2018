package calendar;

import java.util.*;
import calendar.Appt;
import calendar.CalDay;
import calendar.DataHandler;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Random Test Generator  for DataHandler class.
 */

public class DataHandlerRandomTest {

	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;
    /**
     * Generate Random Tests that tests DataHandler Class.
     */
	 @Test
	  public void randomtest()  throws Throwable  {

			long startTime = Calendar.getInstance().getTimeInMillis();
			long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

			System.out.println("Start testing...");

		 try{
			 for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				 long randomseed =System.currentTimeMillis();
				 Random random = new Random(randomseed);

				 int numAppts = ValuesGenerator.getRandomIntBetween(random, 1, 3);
				 int startDay=ValuesGenerator.getRandomIntBetween(random, 1, 29);
				 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 12);
				 int startYear=ValuesGenerator.getRandomIntBetween(random, 0, 2018);
				 boolean randBool = random.nextBoolean();
				 DataHandler data = new DataHandler("calendar", randBool);

				 LinkedList<Appt> appts = new LinkedList<Appt>();

				 if(startDay < CalendarUtil.NumDaysInMonth(startYear, startMonth - 1) - 1){

						 GregorianCalendar cal1 = new GregorianCalendar(startYear, startMonth - 1, startDay);
						 GregorianCalendar cal2 = new GregorianCalendar(startYear, startMonth - 1, startDay + 2);

						 for (int i = 1; i < numAppts; i++){
								int startHour=ValuesGenerator.getRandomIntBetween(random, -1, 24);
								int startMinute=ValuesGenerator.getRandomIntBetween(random, -1, 65);
								String title="Birthday Party";
								String description="This is my birthday party.";
								String emailAddress="xyz@gmail.com";

								//Construct a new Appointment object with the initial data
								Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
								appt.setValid();

								if(startHour > -1 && startHour < 24 && startMinute > -1 && startMinute < 60){
									assertFalse(data.deleteAppt(appt));

									//if dates selected are early enough in the month, set weekly recurrence
									if(startDay < CalendarUtil.NumDaysInMonth(startYear, startMonth - 1) - 8){
										int [] recurDays = new int [] {cal1.get(Calendar.DAY_OF_WEEK), (cal1.get(Calendar.DAY_OF_WEEK) + 2 )% 7};
										appt.setRecurrence(recurDays, 1, 1, 8);
										GregorianCalendar cal3 = new GregorianCalendar(startYear, startMonth - 1, startDay + 8);

										assertTrue(data.saveAppt(appt));

										LinkedList<CalDay> daysLists = new LinkedList<CalDay>(data.getApptRange(cal1, cal3));
										CalDay calday1 = daysLists.get(0);
										CalDay calday2 = daysLists.get(1);
										CalDay calday8 = daysLists.get(7);

										//getApptRange here
										assertEquals(1, calday1.getSizeAppts());
										assertEquals(startDay, calday1.getDay());
										assertEquals(startMonth, calday1.getMonth());
										assertEquals(startYear, calday1.getYear());

										assertEquals(1, calday8.getSizeAppts());
										assertEquals(startDay + 7, calday8.getDay());
										assertEquals(startMonth, calday8.getMonth());
										assertEquals(startYear, calday8.getYear());

										assertTrue(data.deleteAppt(appt));

									}
								  else{
										assertTrue(data.saveAppt(appt));

										LinkedList<CalDay> daysLists = new LinkedList<CalDay>(data.getApptRange(cal1, cal2));
										CalDay calday1 = daysLists.get(0);
										CalDay calday2 = daysLists.get(1);

										//getApptRange here
										assertEquals(1, calday1.getSizeAppts());
										assertEquals(startDay, calday1.getDay());
										assertEquals(startMonth, calday1.getMonth());
										assertEquals(startYear, calday1.getYear());

										assertEquals(0, calday2.getSizeAppts());
										assertEquals(startDay + 1, calday2.getDay());
										assertEquals(startMonth, calday2.getMonth());
										assertEquals(startYear, calday2.getYear());

										assertTrue(data.deleteAppt(appt));
									}
								}
								else{
									//appointment is invalid, so was not added to data
									assertFalse(data.saveAppt(appt));

									LinkedList<CalDay> daysLists = new LinkedList<CalDay>(data.getApptRange(cal1, cal2));
									CalDay calday1 = daysLists.get(0);
									CalDay calday2 = daysLists.get(1);

									assertEquals(0, calday1.getSizeAppts());
							    assertEquals(startDay, calday1.getDay());
							    assertEquals(startMonth, calday1.getMonth());
							    assertEquals(startYear, calday1.getYear());

							    assertEquals(0, calday2.getSizeAppts());
							    assertEquals(startDay + 1, calday2.getDay());
							    assertEquals(startMonth, calday2.getMonth());
							    assertEquals(startYear, calday2.getYear());

									assertFalse(data.deleteAppt(appt));
								}
						}
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
