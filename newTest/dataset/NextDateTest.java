import junit.framework.*;

public class NextDateTest extends TestCase {

  public static void main (String[] args) {
    junit.textui.TestRunner.run(NextDateTest.class);
  }

  @org.junit.jupiter.api.Test
  public void testCase1() {
    NextDate x1001 = new NextDate(-4, 12, -20);
    x1001.setMonth(-13);
    System.out.println("OK");
  }

  @org.junit.jupiter.api.Test
  public void testCase2() {
    NextDate x1201 = new NextDate(16, -11, -7);
    x1201.setYear(5);
    System.out.println("OK");
  }

  @org.junit.jupiter.api.Test
  public void testCase3() {
    NextDate x1 = new NextDate(-8, 4, -3);
    x1.nextDate();
    System.out.println("OK");
  }

  @org.junit.jupiter.api.Test
  public void testCase4() {
    NextDate x801 = new NextDate(-6, -3, -12);
    x801.setDay(8);
    System.out.println("OK");
  }

  }
