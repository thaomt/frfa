import junit.framework.*;

public class DateUtilTest extends TestCase {

  public static void main (String[] args) {
    junit.textui.TestRunner.run(DateUtilTest.class);
  }

  @org.junit.jupiter.api.Test
  public void testCase1() {
    DateUtil x2527 = new DateUtil();
    MyDate x2528 = new MyDate(7, 40, 71);
    x2527.daysInMonth(x2528);
    System.out.println("OK");
  }

  @org.junit.jupiter.api.Test
  public void testCase2() {
    DateUtil x1 = new DateUtil();
    MyDate x2 = new MyDate(-21, 41, 96);
    x1.daysInMonth(x2);
    System.out.println("OK");
  }

  }
