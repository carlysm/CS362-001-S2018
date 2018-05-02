/** A JUnit test class to test the class ApptTest. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalendarUtil;
public class ApptTest  {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals("\t14/9/2018 at 3:30pm ,Birthday Party, This is my birthday party\n", string0);
      assertEquals(0, appt0.getRecurIncrement());
      appt0.setValid();
  }

  @Test(timeout = 4000)
   public void test01()  throws Throwable  {
     int startHour = 12;
     int startMinute = 00;
     int startDay = 19;
     int startMonth = 4;
     int startYear = 2018;
     String title = "CS362 Lecture";
     String description = "Software Engineering II";
     String email = "carly@gmail.com";

     Appt appt = new Appt (startHour, startMinute, startDay, startMonth, startYear, title, description, email);

     assertFalse(appt.isOn(12, startMonth, startYear));
   }

@Test(timeout = 4000)
 public void test02()  throws Throwable  {
   int startHour = 12;
   int startMinute = 00;
   int startDay = 19;
   int startMonth = 4;
   int startYear = 2018;
   String title = "CS362 Lecture";
   String description = "Software Engineering II";
   String email = "carly@gmail.com";

   Appt appt = new Appt (startHour, startMinute, startDay, startMonth, startYear, title, description, email);

   assertFalse(appt.isOn(startDay, startMonth, 2017));
 }

 @Test(timeout = 4000)
  public void test03()  throws Throwable  {
    int startHour = 12;
    int startMinute = 00;
    int startDay = 19;
    int startMonth = 4;
    int startYear = 2018;
    String title = "CS362 Lecture";
    String description = "Software Engineering II";
    String email = "carly@gmail.com";

    Appt appt = new Appt (startHour, startMinute, startDay, startMonth, startYear, title, description, email);

    assertFalse(appt.isOn(20, 3, 2017));
  }

  @Test(timeout = 4000)
   public void test04()  throws Throwable  {
     int startHour = 12;
     int startMinute = 00;
     int startDay = 19;
     int startMonth = 4;
     int startYear = 2018;
     String title = "CS362 Lecture";
     String description = "Software Engineering II";
     String email = "carly@gmail.com";

     Appt appt = new Appt (startHour, startMinute, startDay, startMonth, startYear, title, description, email);

     assertFalse(appt.isOn(20, 03, startYear));
   }

 @Test(timeout = 4000)
  public void test05()  throws Throwable  {
    int startDay = 19;
    int startMonth = 4;
    int startYear = 2018;
    String title = "CS362 Lecture";
    String description = "Software Engineering II";
    String email = "carly@gmail.com";

    Appt appt = new Appt (startDay, startMonth, startYear, title, description, email);

    assertEquals(-1, appt.getStartMinute());
    assertEquals(-1, appt.getStartHour());
    assertFalse(appt.hasTimeSet());
  }

  @Test(timeout = 4000)
   public void test06()  throws Throwable  {
     int startDay = 19;
     int startMonth = 12;
     int startYear = 2018;
     String title = "CS362 Lecture";
     String description = "Software Engineering II";
     String email = "carly@gmail.com";

     Appt appt = new Appt (startDay, startMonth, startYear, title, description, email);
     appt.setValid();
     assertFalse(appt.getValid());
   }

   @Test(timeout = 4000)
    public void test07()  throws Throwable  {
      int startHour = 12;
      int startMinute = 00;
      int startDay = 19;
      int startMonth = 4;
      int startYear = 2018;
      String title = "CS362 Lecture";
      String description = "Software Engineering II";
      String email = "carly@gmail.com";

      Appt appt = new Appt (startHour, startMinute, startDay, startMonth, startYear, title, description, email);
      appt.setValid();

      assertTrue(appt.hasTimeSet());
      assertEquals(startHour, appt.getStartHour());
      assertEquals(startMinute, appt.getStartMinute());
      assertEquals(startDay, appt.getStartDay());
      assertEquals(startMonth, appt.getStartMonth());
      assertEquals(startYear, appt.getStartYear());
      assertEquals(title, appt.getTitle());
      assertEquals(description, appt.getDescription());
      assertEquals(email, appt.getEmailAddress());
      assertTrue(appt.getValid());


    }

    @Test(timeout = 4000)
     public void test08()  throws Throwable  {
       int startHour = 12;
       int startMinute = 00;
       int startDay = 19;
       int startMonth = 4;
       int startYear = 2018;
       String title = null;
       String description = null;
       String email = null;

       Appt appt = new Appt (startHour, startMinute, startDay, startMonth, startYear, title, description, email);

       assertEquals("", appt.getTitle());
       assertEquals("", appt.getDescription());
       assertEquals("", appt.getEmailAddress());


     }

    @Test(timeout = 4000)
     public void test09()  throws Throwable  {
       int startHour = 12;
       int startMinute = 00;
       int startDay = 19;
       int startMonth = 4;
       int startYear = 2018;
       String title = "CS362 Lecture";
       String description = "Software Engineering II";
       String email = "carly@gmail.com";
       int [] recurDays = new int [] {0, 4};

       Appt appt = new Appt (startHour, startMinute, startDay, startMonth, startYear, title, description, email);

       appt.setRecurrence(recurDays, 1, 1 ,8);
       assertTrue(appt.isRecurring());
       assertEquals(8, appt.getRecurNumber());
     }

     @Test(timeout = 4000)
      public void test10()  throws Throwable  {
        int startHour = 12;
        int startMinute = 00;
        int startDay = 19;
        int startMonth = 4;
        int startYear = 2018;
        String title = "CS362 Lecture";
        String description = "Software Engineering II";
        String email = "carly@gmail.com";

        Appt appt = new Appt (startHour, startMinute, startDay, startMonth, startYear, title, description, email);

        appt.setRecurrence(null, 1, 1 ,8);
        assertTrue(appt.isRecurring());
        assertEquals(8, appt.getRecurNumber());
      }

     @Test(timeout = 4000)
      public void test11()  throws Throwable  {
        int startDay = 1;
        int startMonth = 0;
        int startYear = 2018;
        String title = "CS362 Lecture";
        String description = "Software Engineering II";
        String email = "carly@gmail.com";

        Appt appt = new Appt (startDay, startMonth, startYear, title, description, email);
        appt.setValid();
        assertFalse(appt.getValid());
      }

      @Test(timeout = 4000)
       public void test12()  throws Throwable  {
         int startHour = -2;
         int startMinute = 00;
         int startDay = 19;
         int startMonth = 4;
         int startYear = 2018;
         String title = "CS362 Lecture";
         String description = "Software Engineering II";
         String email = "carly@gmail.com";

         Appt appt = new Appt (startHour, startMinute, startDay, startMonth, startYear, title, description, email);
         appt.setValid();
         assertFalse(appt.getValid());

         //assertEquals("\tThis appointment is not valid", appt.toString());
       }

       @Test(timeout = 4000)
        public void test13()  throws Throwable  {
          int startHour = 0;
          int startMinute = 0;
          int startDay = 19;
          int startMonth = 4;
          int startYear = 2018;
          String title = "CS362 Lecture";
          String description = "Software Engineering II";
          String email = "carly@gmail.com";

          Appt appt = new Appt (startHour, startMinute, startDay, startMonth, startYear, title, description, email);
          appt.setValid();
          assertTrue(appt.getValid());

          assertEquals("\t4/19/2018 at 12:0am ,CS362 Lecture, Software Engineering II\n", appt.toString());
        }

}
