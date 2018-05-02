
/** A JUnit test class to test the class DataHandler. */


package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import calendar.DataHandler;

import java.util.GregorianCalendar;
import java.util.LinkedList;


public class DataHandlerTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
    DataHandler data = new DataHandler();
    Appt appt1 = new Appt(15, 30, 19, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    assertTrue(data.saveAppt(appt1));
  }

/*  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
    DataHandler data = new DataHandler("caldata.xml");

    GregorianCalendar cal = new GregorianCalendar();
    cal.set(GregorianCalendar.YEAR, 2018);
    cal.set(GregorianCalendar.MONTH, 4);
    cal.set(GregorianCalendar.DATE, 19);

    GregorianCalendar cal2 = new GregorianCalendar();
    cal.set(GregorianCalendar.YEAR, 2018);
    cal.set(GregorianCalendar.MONTH, 4);
    cal.set(GregorianCalendar.DATE, 21);

    assertEquals("Second date specified is not before the first date specified.", data.getApptRange(cal2, cal));
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
    DataHandler data = new DataHandler("caldata1.xml", false);
    Appt appt1 = new Appt(15, 30, 19, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    data.saveAppt(appt1);

    GregorianCalendar cal = new GregorianCalendar();
    cal.set(GregorianCalendar.YEAR, 2018);
    cal.set(GregorianCalendar.MONTH, 3);
    cal.set(GregorianCalendar.DATE, 19);

    GregorianCalendar cal2 = new GregorianCalendar();
    cal.set(GregorianCalendar.YEAR, 2018);
    cal.set(GregorianCalendar.MONTH, 3);
    cal.set(GregorianCalendar.DATE, 21);

    assertEquals("\t--- 4/19/2018 ---\n" +
      " --- -------- Appointments ------------ ---\n" +
      "\t4/19/2018 at 3:30pm ,Birthday Party, This is my birthday party\n\n," +
      "\t--- 4/20/2018 ---\n" +
      " --- -------- Appointments ------------ ---\n\n",
      data.getApptRange(cal, cal2));
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
    DataHandler data = new DataHandler("caldata.xml", true);

    GregorianCalendar cal = new GregorianCalendar();
    cal.set(GregorianCalendar.YEAR, 2018);
    cal.set(GregorianCalendar.MONTH, 4);
    cal.set(GregorianCalendar.DATE, 19);

    GregorianCalendar cal2 = new GregorianCalendar();
    cal.set(GregorianCalendar.YEAR, 2018);
    cal.set(GregorianCalendar.MONTH, 4);
    cal.set(GregorianCalendar.DATE, 20);

    assertEquals("\t--- 4/19/2018 ---\n" +
      " --- -------- Appointments ------------ ---\n\n," +
      "\t--- 4/20/2018 ---\n" +
      " --- -------- Appointments ------------ ---\n\n", data.getApptRange(cal2, cal));
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
    DataHandler data = new DataHandler("caldata.xml", true);
    Appt appt1 = new Appt(15, 30, 19, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");

    assertTrue(data.saveAppt(appt1));
    assertTrue(data.deleteAppt(appt1));
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
    DataHandler data = new DataHandler("caldata.xml", true);
    Appt appt1 = new Appt(15, 30, 19, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");

    assertFalse(data.deleteAppt(appt1));
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
    DataHandler data = new DataHandler("caldata.xml", false);
    Appt appt1 = new Appt(30, 30, 19, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    appt1.setValid();

    assertFalse(data.saveAppt(appt1));
    assertFalse(data.deleteAppt(appt1));
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
    DataHandler data = new DataHandler("caldata.xml", true);
    int [] recurDays = new int [] {0, 4};
    Appt appt1 = new Appt(15, 30, 19, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    appt1.setRecurrence(recurDays, 1, 1 ,8);

    assertTrue(data.saveAppt(appt1));
    assertTrue(data.deleteAppt(appt1));
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
    DataHandler data = new DataHandler("caldata.xml", false);
    int [] recurDays = new int [] {0, 4};
    Appt appt1 = new Appt(15, 30, 19, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    appt1.setRecurrence(recurDays, 1, 1 ,8);

    assertTrue(data.saveAppt(appt1));
    assertTrue(data.deleteAppt(appt1));
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
    DataHandler data = new DataHandler("caldata.xml", true);
    int [] recurDays = new int [] {0, 4};
    Appt appt1 = new Appt(15, 30, 19, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    appt1.setRecurrence(recurDays, 1, 1 ,8);

    assertTrue(data.saveAppt(appt1));

    GregorianCalendar cal = new GregorianCalendar();
    cal.set(GregorianCalendar.YEAR, 2018);
    cal.set(GregorianCalendar.MONTH, 4);
    cal.set(GregorianCalendar.DATE, 19);

    GregorianCalendar cal2 = new GregorianCalendar();
    cal.set(GregorianCalendar.YEAR, 2018);
    cal.set(GregorianCalendar.MONTH, 4);
    cal.set(GregorianCalendar.DATE, 27);

    assertEquals("\t--- 4/19/2018 ---\n" +
      " --- -------- Appointments ------------ ---\n" +
      "\t4/19/2018 at 3:30pm ,Birthday Party, This is my birthday party\n\n," +
      "\t--- 4/20/2018 ---\n" +
      " --- -------- Appointments ------------ ---\n\n" +
      "\t--- 4/21/2018 ---\n" +
      " --- -------- Appointments ------------ ---\n\n" +
      "\t--- 4/22/2018 ---\n" +
      " --- -------- Appointments ------------ ---\n" +
      "\t4/19/2018 at 3:30pm ,Birthday Party, This is my birthday party\n\n," +
      "\t--- 4/23/2018 ---\n" +
      " --- -------- Appointments ------------ ---\n\n" +
      "\t--- 4/24/2018 ---\n" +
      " --- -------- Appointments ------------ ---\n\n" +
      "\t--- 4/25/2018 ---\n" +
      " --- -------- Appointments ------------ ---\n\n" +
      "\t--- 4/26/2018 ---\n" +
      " --- -------- Appointments ------------ ---\n" +
      "\t4/19/2018 at 3:30pm ,Birthday Party, This is my birthday party\n\n,", data.getApptRange(cal2, cal));
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
    DataHandler data = new DataHandler("caldata.xml", true);
    int [] recurDays = new int [0];
    Appt appt1 = new Appt(15, 30, 19, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    appt1.setRecurrence(recurDays, 1, 1 ,8);

    assertTrue(data.saveAppt(appt1));

    GregorianCalendar cal = new GregorianCalendar();
    cal.set(GregorianCalendar.YEAR, 2018);
    cal.set(GregorianCalendar.MONTH, 4);
    cal.set(GregorianCalendar.DATE, 19);

    GregorianCalendar cal2 = new GregorianCalendar();
    cal.set(GregorianCalendar.YEAR, 2018);
    cal.set(GregorianCalendar.MONTH, 4);
    cal.set(GregorianCalendar.DATE, 27);

    assertEquals("\t--- 4/19/2018 ---\n" +
      " --- -------- Appointments ------------ ---\n" +
      "\t4/19/2018 at 3:30pm ,Birthday Party, This is my birthday party\n\n," +
      "\t--- 4/20/2018 ---\n" +
      " --- -------- Appointments ------------ ---\n\n" +
      "\t--- 4/21/2018 ---\n" +
      " --- -------- Appointments ------------ ---\n\n" +
      "\t--- 4/22/2018 ---\n" +
      " --- -------- Appointments ------------ ---\n\n" +
      "\t--- 4/23/2018 ---\n" +
      " --- -------- Appointments ------------ ---\n\n" +
      "\t--- 4/24/2018 ---\n" +
      " --- -------- Appointments ------------ ---\n\n" +
      "\t--- 4/25/2018 ---\n" +
      " --- -------- Appointments ------------ ---\n\n" +
      "\t--- 4/26/2018 ---\n" +
      " --- -------- Appointments ------------ ---\n" +
      "\t4/19/2018 at 3:30pm ,Birthday Party, This is my birthday party\n\n,", data.getApptRange(cal2, cal));
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
    DataHandler data = new DataHandler("caldata.xml", true);
    int [] recurDays = new int [0];
    Appt appt1 = new Appt(15, 30, 19, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    //set appt to recurr on same day of week, weekly, once per week, for two occurences
    appt1.setRecurrence(recurDays, 2, 1, 2);

    assertTrue(data.saveAppt(appt1));

    GregorianCalendar cal = new GregorianCalendar();
    cal.set(GregorianCalendar.YEAR, 2018);
    cal.set(GregorianCalendar.MONTH, 4);
    cal.set(GregorianCalendar.DATE, 19);

    GregorianCalendar cal2 = new GregorianCalendar();
    cal.set(GregorianCalendar.YEAR, 2018);
    cal.set(GregorianCalendar.MONTH, 4);
    cal.set(GregorianCalendar.DATE, 26);

    assertEquals("\t--- 4/19/2018 ---\n" +
      " --- -------- Appointments ------------ ---\n" +
      "\t4/19/2018 at 3:30pm ,Birthday Party, This is my birthday party\n\n," +
      "\t--- 4/20/2018 ---\n" +
      " --- -------- Appointments ------------ ---\n\n" +
      "\t--- 4/21/2018 ---\n" +
      " --- -------- Appointments ------------ ---\n\n" +
      "\t--- 4/22/2018 ---\n" +
      " --- -------- Appointments ------------ ---\n\n" +
      "\t--- 4/23/2018 ---\n" +
      " --- -------- Appointments ------------ ---\n\n" +
      "\t--- 4/24/2018 ---\n" +
      " --- -------- Appointments ------------ ---\n\n" +
      "\t--- 4/25/2018 ---\n" +
      " --- -------- Appointments ------------ ---\n\n" +
      "\t--- 4/26/2018 ---\n" +
      " --- -------- Appointments ------------ ---\n\n", data.getApptRange(cal2, cal));
  }*/

}
