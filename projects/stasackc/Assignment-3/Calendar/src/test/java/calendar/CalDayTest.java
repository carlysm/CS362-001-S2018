/** A JUnit test class to test the class CalDay. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import java.util.*;


public class CalDayTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
    CalDay day1 = new CalDay();
    assertFalse(day1.isValid());

  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
    GregorianCalendar cal = new GregorianCalendar();
    cal.set(GregorianCalendar.YEAR, 2018);
    cal.set(GregorianCalendar.MONTH, 3);
    cal.set(GregorianCalendar.DATE, 19);

    CalDay day1 = new CalDay(cal);
    assertTrue(day1.isValid());
    assertEquals(2018, day1.getYear());
    assertEquals(4, day1.getMonth());
    assertEquals(19, day1.getDay());
    assertEquals(2018, day1.getYear());

    LinkedList<Appt> appts = new LinkedList<Appt>();
    assertEquals(appts, day1.getAppts());
    assertEquals(0, day1.getSizeAppts());
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
    GregorianCalendar cal = new GregorianCalendar();
    cal.set(GregorianCalendar.YEAR, 2018);
    cal.set(GregorianCalendar.MONTH, 3);
    cal.set(GregorianCalendar.DATE, 19);

    CalDay day1 = new CalDay(cal);

    Appt appt1 = new Appt(15, 30, 19, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    appt1.setValid();

    day1.addAppt(appt1);

    LinkedList<Appt> appts = new LinkedList<Appt>(Arrays.asList(appt1));
    assertEquals(appts, day1.getAppts());
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
    GregorianCalendar cal = new GregorianCalendar();
    cal.set(GregorianCalendar.YEAR, 2018);
    cal.set(GregorianCalendar.MONTH, 3);
    cal.set(GregorianCalendar.DATE, 19);

    CalDay day1 = new CalDay(cal);

    Appt appt1 = new Appt(30, 30, 19, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    appt1.setValid();

    day1.addAppt(appt1);

    LinkedList<Appt> appts = new LinkedList<Appt>();
    assertEquals(appts, day1.getAppts());
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
    GregorianCalendar cal = new GregorianCalendar();
    cal.set(GregorianCalendar.YEAR, 2018);
    cal.set(GregorianCalendar.MONTH, 3);
    cal.set(GregorianCalendar.DATE, 19);

    CalDay day1 = new CalDay(cal);

    Appt appt2 = new Appt(19, 15, 19, 4, 2018, "Dinner", "Dinner at Taco Vino", "xyz@gmail.com");
    appt2.setValid();

    day1.addAppt(appt2);

    Appt appt1 = new Appt(15, 30, 19, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    appt1.setValid();

    day1.addAppt(appt1);

    LinkedList<Appt> appts = new LinkedList<Appt>(Arrays.asList(appt1, appt2));
    assertEquals(appts, day1.getAppts());
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
    GregorianCalendar cal = new GregorianCalendar();
    cal.set(GregorianCalendar.YEAR, 2018);
    cal.set(GregorianCalendar.MONTH, 3);
    cal.set(GregorianCalendar.DATE, 19);

    CalDay day1 = new CalDay(cal);

    assertEquals("\t --- 4/19/2018 --- \n" + " --- -------- Appointments ------------ --- \n\n", day1.toString());
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
    GregorianCalendar cal = new GregorianCalendar();
    cal.set(GregorianCalendar.YEAR, 2018);
    cal.set(GregorianCalendar.MONTH, 3);
    cal.set(GregorianCalendar.DATE, 19);

    CalDay day1 = new CalDay(cal);

    Appt appt1 = new Appt(15, 30, 19, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    appt1.setValid();

    day1.addAppt(appt1);
    assertEquals("\t --- 4/19/2018 --- \n --- -------- Appointments ------------ --- \n\t4/19/2018 at 3:30pm ,Birthday Party, This is my birthday party\n \n", day1.toString());
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
    GregorianCalendar cal = new GregorianCalendar();
    cal.set(GregorianCalendar.YEAR, 2018);
    cal.set(GregorianCalendar.MONTH, 3);
    cal.set(GregorianCalendar.DATE, 19);

    CalDay day1 = new CalDay(cal);

    Appt appt1 = new Appt(15, 30, 19, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    appt1.setValid();

    day1.addAppt(appt1);

    assertEquals("4-19-2018 " + "\n\t" + "3:30PM Birthday Party This is my birthday party ", day1.getFullInfomrationApp(day1));
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
    GregorianCalendar cal = new GregorianCalendar();
    cal.set(GregorianCalendar.YEAR, 2018);
    cal.set(GregorianCalendar.MONTH, 3);
    cal.set(GregorianCalendar.DATE, 19);

    CalDay day1 = new CalDay(cal);

    Appt appt1 = new Appt(0, 0, 19, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    appt1.setValid();

    day1.addAppt(appt1);

    assertEquals("4-19-2018 " + "\n\t" + "12:00AM Birthday Party This is my birthday party ", day1.getFullInfomrationApp(day1));
  }

/*  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
    CalDay day1 = new CalDay();
    assertEquals("", day1.toString());
    assertEquals("", day1.getFullInfomrationApp(day1));
  }*/

}
