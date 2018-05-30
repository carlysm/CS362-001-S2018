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
      assertEquals("xyz@gmail.com", appt0.getEmailAddress());
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

     assertTrue(appt.isOn(startDay, startMonth, startYear));
     assertFalse(appt.isOn(startDay, 12, 2012));
     assertFalse(appt.isOn(startDay, startMonth, 2012));
     assertFalse(appt.isOn(startDay, 12, startYear));
     assertFalse(appt.isOn(12, startMonth, startYear));
     assertFalse(appt.isOn(12, 12, startYear));
     assertFalse(appt.isOn(12, startMonth, 2012));
     assertFalse(appt.isOn(12, 12, 2012));
   }

 @Test(timeout = 4000)
  public void test02()  throws Throwable  {
    int startDay = 19;
    int startMonth = 4;
    int startYear = 2018;
    String title = "CS362 Lecture";
    String description = "Software Engineering II";
    String email = "carly@gmail.com";

    Appt appt = new Appt (startDay, startMonth, startYear, title, description, email);
    appt.setValid();

    assertEquals(-1, appt.getStartMinute());
    assertEquals(-1, appt.getStartHour());
    assertFalse(appt.hasTimeSet());
    assertFalse(appt.getValid());
  }

  @Test(timeout = 4000)
   public void test03()  throws Throwable  {
     int startHour = 0;
     int startMinute = 0;
     int startDay = 1;
     int startMonth = 1;
     int startYear = 1;
     String title = "The beginning";
     String description = "Bang!";
     String email = "carly@gmail.com";

     Appt appt = new Appt (startHour, startMinute, startDay, startMonth, startYear, title, description, email);
     appt.setValid();
     assertTrue(appt.getValid());
   }

   @Test(timeout = 4000)
    public void test04()  throws Throwable  {
      int startHour = -1;
      int startMinute = -1;
      int startDay = 0;
      int startMonth = 0;
      int startYear = 0;
      String title = "Before the beginning";
      String description = "Bang!";
      String email = "carly@gmail.com";

      Appt appt = new Appt (startHour, startMinute, startDay, startMonth, startYear, title, description, email);
      appt.setValid();
      assertFalse(appt.getValid());
    }

    @Test(timeout = 4000)
     public void test05()  throws Throwable  {
       int startHour = 23;
       int startMinute = 59;
       int startDay = 31;
       int startMonth = 12;
       int startYear = 2018;
       String title = "The end";
       String description = "Fizzle!";
       String email = "carly@gmail.com";

       Appt appt = new Appt (startHour, startMinute, startDay, startMonth, startYear, title, description, email);
       appt.setValid();
       assertTrue(appt.getValid());
     }

     @Test(timeout = 4000)
      public void test06()  throws Throwable  {
        int startHour = 24;
        int startMinute = 60;
        int startDay = 32;
        int startMonth = 13;
        int startYear = 2018;
        String title = "After the end";
        String description = "Fizzle!";
        String email = "carly@gmail.com";

        Appt appt = new Appt (startHour, startMinute, startDay, startMonth, startYear, title, description, email);
        appt.setValid();
        assertFalse(appt.getValid());
      }

      @Test(timeout = 4000)
       public void test07()  throws Throwable  {
         int startHour = 23;
         int startMinute = 60;
         int startDay = 31;
         int startMonth = 3;
         int startYear = 2018;
         String title = "End of March Party";
         String description = "Happy Almost April!";
         String email = "carly@gmail.com";

         Appt appt = new Appt (startHour, startMinute, startDay, startMonth, startYear, title, description, email);
         appt.setValid();
         assertFalse(appt.getValid());
       }

       @Test(timeout = 4000)
        public void test08()  throws Throwable  {
          int startHour = 23;
          int startMinute = 59;
          int startDay = 31;
          int startMonth = 2;
          int startYear = 2018;
          String title = null;
          String description = null;
          String email = null;

          Appt appt = new Appt (startHour, startMinute, startDay, startMonth, startYear, title, description, email);
          appt.setValid();
          assertFalse(appt.getValid());
        }

        @Test(timeout = 4000)
         public void test09()  throws Throwable  {
           int startHour = 23;
           int startMinute = 59;
           int startDay = 0;
           int startMonth = 2;
           int startYear = 2018;
           String title = null;
           String description = null;
           String email = null;

           Appt appt = new Appt (startHour, startMinute, startDay, startMonth, startYear, title, description, email);
           appt.setValid();
           assertFalse(appt.getValid());
         }

         @Test(timeout = 4000)
          public void test10()  throws Throwable  {
            int startHour = 23;
            int startMinute = 59;
            int startDay = 1;
            int startMonth = 2;
            int startYear = 0;
            String title = null;
            String description = null;
            String email = null;

            Appt appt = new Appt (startHour, startMinute, startDay, startMonth, startYear, title, description, email);
            appt.setValid();
            assertFalse(appt.getValid());
          }

       @Test(timeout = 4000)
        public void test11()  throws Throwable  {
          int startHour = 11;
          int startMinute = 15;
          int startDay = 19;
          int startMonth = 4;
          int startYear = 2018;
          String title = "CS362 Lecture";
          String description = "Software Engineering II";
          String email = "carly@gmail.com";

          Appt appt = new Appt (startHour, startMinute, startDay, startMonth, startYear, title, description, email);
          appt.setValid();
          assertTrue(appt.getValid());

          assertEquals("\t4/19/2018 at 11:15am ,CS362 Lecture, Software Engineering II\n", appt.toString());
        }

}
