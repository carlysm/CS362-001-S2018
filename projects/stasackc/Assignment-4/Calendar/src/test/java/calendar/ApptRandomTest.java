package calendar;

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;



import static org.junit.Assert.*;



/**
 * Random Test Generator  for Appt class.
 */

public class ApptRandomTest {

	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"setTitle","setRecurrence"};// The list of the of methods to be tested in the Appt class

    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

        return methodArray[n] ; // return the method name
        }
	/**
	 * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
	 */
    public static int RandomSelectRecur(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return the value of the  appointments to recur
        }
	/**
	 * Return a randomly selected appointments to recur forever or Never recur  !.
	 */
    public static int RandomSelectRecurForEverNever(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return appointments to recur forever or Never recur
        }
   /**
     * Generate Random Tests that tests Appt Class.
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

				 int startHour=ValuesGenerator.getRandomIntBetween(random, -1, 30);
				 int startMinute=ValuesGenerator.getRandomIntBetween(random, -1, 70);
				 int startDay=ValuesGenerator.getRandomIntBetween(random, -1, 40);
				 int startMonth=ValuesGenerator.getRandomIntBetween(random, -1, 20);
				 int startYear=ValuesGenerator.getRandomIntBetween(random, -1, 10);
				 String title="Birthday Party";
				 String description="This is my birthday party.";
				 String emailAddress="xyz@gmail.com";

				 //Construct a new Appointment object with the initial data
		     Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
				 appt.setValid();

				if (startYear > 0){
						if (startMonth < 1 || startMonth > 12 || startHour < 0 || startHour > 23 ||
							  startMinute < 0 || startMinute > 59 || startDay < 1 ||
								startDay > CalendarUtil.NumDaysInMonth(startYear, startMonth -1)){
									assertFalse(appt.getValid());
								}
						else{
									assertTrue(appt.getValid());
									assertTrue(appt.isOn(startDay, startMonth, startYear));
									assertFalse(appt.isOn(startDay + 1, startMonth, startYear));

									int onDay = ValuesGenerator.getRandomIntBetween(random, startDay - 1, startDay + 1);
									int onMonth = ValuesGenerator.getRandomIntBetween(random, startMonth -1, startMonth + 1);
									int onYear = ValuesGenerator.getRandomIntBetween(random, startYear - 1, startYear + 1);

									if (onDay == startDay && onMonth == startMonth && onYear == startYear){
										assertTrue(appt.isOn(onDay, onMonth, onYear));
									}
									else{
										assertFalse(appt.isOn(onDay, onMonth, onYear));
									}

									assertFalse(appt.isRecurring());

									if (startMonth == 2 && startDay < 22){
										appt.setRecurrence(null, 1, 1 ,8);
        						assertTrue(appt.isRecurring());
        						assertEquals(8, appt.getRecurNumber());
									}
						}
					}
					else{
								assertFalse(appt.getValid());
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
