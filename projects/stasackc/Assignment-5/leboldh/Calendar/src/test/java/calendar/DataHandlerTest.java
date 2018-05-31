
/** A JUnit test class to test the class DataHandler. */


package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import calendar.DataHandler;

import java.util.*;


public class DataHandlerTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
    DataHandler data = new DataHandler();
    Appt appt1 = new Appt(15, 30, 19, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    assertTrue(data.saveAppt(appt1));
    assertTrue(data.deleteAppt(appt1));
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
    DataHandler data = new DataHandler("caldata.xml", true);
    Appt appt1 = new Appt(15, 30, 19, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    assertTrue(data.saveAppt(appt1));
    assertTrue(data.deleteAppt(appt1));
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
    DataHandler data = new DataHandler("caldata.xml", true);
    Appt appt1 = new Appt(15, 30, 19, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    assertFalse(data.deleteAppt(appt1));
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
    DataHandler data = new DataHandler("caldata.xml", false);
    Appt appt1 = new Appt(30, 30, 19, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    appt1.setValid();
    assertFalse(data.saveAppt(appt1));
    assertFalse(data.deleteAppt(appt1));
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
    DataHandler data = new DataHandler("caldata.xml", true);
    int [] recurDays = new int [] {0, 4};
    Appt appt1 = new Appt(15, 30, 19, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    appt1.setRecurrence(recurDays, 1, 1 ,8);
    assertTrue(data.saveAppt(appt1));
    assertTrue(data.deleteAppt(appt1));
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
    DataHandler data = new DataHandler("caldata.xml", false);
    int [] recurDays = new int [] {0, 4};
    Appt appt1 = new Appt(15, 30, 19, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    appt1.setRecurrence(recurDays, 1, 1 ,8);
    assertTrue(data.saveAppt(appt1));
    assertTrue(data.deleteAppt(appt1));
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
    DataHandler data = new DataHandler("caldata.xml");

    GregorianCalendar cal = new GregorianCalendar(2018, 3, 1);
    GregorianCalendar cal2 = new GregorianCalendar(2018, 3, 2);
    GregorianCalendar cal3 = new GregorianCalendar(2018, 3, 3);

    LinkedList<CalDay> daysLists = new LinkedList<CalDay>(data.getApptRange(cal, cal3));
    CalDay calday1 = daysLists.get(0);
    CalDay calday2 = daysLists.get(1);
    LinkedList<Appt> appts = new LinkedList<Appt>();

    assertEquals(appts, calday1.getAppts());
    assertEquals(0, calday1.getSizeAppts());
    assertTrue(calday1.isValid());
    assertEquals(1, calday1.getDay());
    assertEquals(4, calday1.getMonth());
    assertEquals(2018, calday1.getYear());

    assertEquals(appts, calday2.getAppts());
    assertEquals(0, calday2.getSizeAppts());
    assertTrue(calday2.isValid());
    assertEquals(2, calday2.getDay());
    assertEquals(4, calday2.getMonth());
    assertEquals(2018, calday2.getYear());
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
    DataHandler data = new DataHandler("caldata1.xml", false);
    Appt appt1 = new Appt(15, 30, 19, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    assertTrue(data.saveAppt(appt1));
    assertTrue(data.save());

    GregorianCalendar cal = new GregorianCalendar(2018, 3, 19);
    GregorianCalendar cal1 = new GregorianCalendar(2018, 3, 20);
    GregorianCalendar cal2 = new GregorianCalendar(2018, 3, 21);

    LinkedList<CalDay> daysLists = new LinkedList<CalDay>(data.getApptRange(cal, cal2));
    CalDay calday1 = daysLists.get(0);
    CalDay calday2 = daysLists.get(1);
    LinkedList<Appt> appts = new LinkedList<Appt>();

    assertEquals(1, calday1.getSizeAppts());
    assertTrue(calday1.isValid());
    assertEquals(19, calday1.getDay());
    assertEquals(4, calday1.getMonth());
    assertEquals(2018, calday1.getYear());

    assertEquals(appts, calday2.getAppts());
    assertEquals(0, calday2.getSizeAppts());
    assertTrue(calday2.isValid());
    assertEquals(20, calday2.getDay());
    assertEquals(4, calday2.getMonth());
    assertEquals(2018, calday2.getYear());

    assertTrue(data.deleteAppt(appt1));
    assertTrue(data.save());
  }



  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
    DataHandler data = new DataHandler("caldata.xml", true);
    int [] recurDays = new int [] {1, 5};
    Appt appt1 = new Appt(15, 30, 19, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    appt1.setRecurrence(recurDays, 1, 1 ,8);

    assertTrue(data.saveAppt(appt1));

    GregorianCalendar cal = new GregorianCalendar(2018, 3, 19);
    GregorianCalendar cal2 = new GregorianCalendar(2018, 3, 27);

    LinkedList<CalDay> daysLists = new LinkedList<CalDay>(data.getApptRange(cal, cal2));
    CalDay calday1 = daysLists.get(0);
    CalDay calday2 = daysLists.get(1);
    CalDay calday3 = daysLists.get(2);
    CalDay calday4 = daysLists.get(3);
    CalDay calday5 = daysLists.get(4);
    CalDay calday6 = daysLists.get(5);
    CalDay calday7 = daysLists.get(6);
    CalDay calday8 = daysLists.get(7);
    LinkedList<Appt> appts = new LinkedList<Appt>();

    assertEquals(1, calday1.getSizeAppts());
    assertTrue(calday1.isValid());
    assertEquals(19, calday1.getDay());
    assertEquals(4, calday1.getMonth());
    assertEquals(2018, calday1.getYear());

    assertEquals(appts, calday2.getAppts());
    assertEquals(0, calday2.getSizeAppts());
    assertTrue(calday2.isValid());
    assertEquals(20, calday2.getDay());
    assertEquals(4, calday2.getMonth());
    assertEquals(2018, calday2.getYear());

    assertEquals(appts, calday3.getAppts());
    assertEquals(0, calday3.getSizeAppts());
    assertTrue(calday3.isValid());
    assertEquals(21, calday3.getDay());
    assertEquals(4, calday3.getMonth());
    assertEquals(2018, calday3.getYear());

    assertEquals(1, calday4.getSizeAppts());
    assertTrue(calday4.isValid());
    assertEquals(22, calday4.getDay());
    assertEquals(4, calday4.getMonth());
    assertEquals(2018, calday4.getYear());

    assertEquals(appts, calday5.getAppts());
    assertEquals(0, calday5.getSizeAppts());
    assertTrue(calday5.isValid());
    assertEquals(23, calday5.getDay());
    assertEquals(4, calday5.getMonth());
    assertEquals(2018, calday5.getYear());

    assertEquals(appts, calday6.getAppts());
    assertEquals(0, calday6.getSizeAppts());
    assertTrue(calday6.isValid());
    assertEquals(24, calday6.getDay());
    assertEquals(4, calday6.getMonth());
    assertEquals(2018, calday6.getYear());

    assertEquals(appts, calday7.getAppts());
    assertEquals(0, calday7.getSizeAppts());
    assertTrue(calday7.isValid());
    assertEquals(25, calday7.getDay());
    assertEquals(4, calday7.getMonth());
    assertEquals(2018, calday7.getYear());

    assertEquals(1, calday8.getSizeAppts());
    assertTrue(calday8.isValid());
    assertEquals(26, calday8.getDay());
    assertEquals(4, calday8.getMonth());
    assertEquals(2018, calday8.getYear());

    assertTrue(data.deleteAppt(appt1));
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
    DataHandler data = new DataHandler("caldata.xml", true);
    int [] recurDays = new int [0];
    Appt appt1 = new Appt(15, 30, 19, 5, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    appt1.setRecurrence(recurDays, 1, 1, 2);

    assertTrue(data.saveAppt(appt1));

    GregorianCalendar cal = new GregorianCalendar(2018, 4, 19);
    GregorianCalendar cal2 = new GregorianCalendar(2018, 4, 27);

    LinkedList<CalDay> daysLists = new LinkedList<CalDay>(data.getApptRange(cal, cal2));
    CalDay calday1 = daysLists.get(0);
    CalDay calday8 = daysLists.get(7);

    assertEquals(1, calday1.getSizeAppts());
    assertTrue(calday1.isValid());
    assertEquals(19, calday1.getDay());
    assertEquals(5, calday1.getMonth());
    assertEquals(2018, calday1.getYear());

    assertEquals(1, calday8.getSizeAppts());
    assertTrue(calday8.isValid());
    assertEquals(26, calday8.getDay());
    assertEquals(5, calday8.getMonth());
    assertEquals(2018, calday8.getYear());

    assertTrue(data.deleteAppt(appt1));
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
    DataHandler data = new DataHandler("caldata.xml", true);
    int [] recurDays = new int [0];
    Appt appt1 = new Appt(15, 30, 19, 5, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    appt1.setRecurrence(recurDays, 2, 1, 2);

    assertTrue(data.saveAppt(appt1));

    GregorianCalendar cal = new GregorianCalendar(2018, 4, 19);
    GregorianCalendar cal2 = new GregorianCalendar(2018, 5, 20);

    LinkedList<CalDay> daysLists = new LinkedList<CalDay>(data.getApptRange(cal, cal2));
    CalDay calday1 = daysLists.get(0);
    CalDay calday2 = daysLists.get(31);

    assertEquals(1, calday1.getSizeAppts());
    assertTrue(calday1.isValid());
    assertEquals(19, calday1.getDay());
    assertEquals(5, calday1.getMonth());
    assertEquals(2018, calday1.getYear());

    assertEquals(1, calday2.getSizeAppts());
    assertTrue(calday2.isValid());
    assertEquals(19, calday2.getDay());
    assertEquals(6, calday2.getMonth());
    assertEquals(2018, calday2.getYear());

    assertTrue(data.deleteAppt(appt1));
  }

}
