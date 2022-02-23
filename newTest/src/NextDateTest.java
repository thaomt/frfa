import junit.framework.*;

public class NextDateTest extends TestCase {

  public static void main (String[] args) {
    junit.textui.TestRunner.run(NextDateTest.class);
  }

  @org.junit.jupiter.api.Test
  public void testCase1() {
    NextDate x3 = new NextDate(3, 28, 28);
    x3.nextDate();
    System.out.println("OK");
  }

  @org.junit.jupiter.api.Test
  public void testCase2() {
    NextDate x1 = new NextDate(60, 88, -71);
    x1.nextDate();
    System.out.println("OK");
  }

  @org.junit.jupiter.api.Test
  public void testCase3() {
    NextDate x19 = new NextDate(12, 10, 42);
    x19.nextDate();
    System.out.println("OK");
  }

  }
