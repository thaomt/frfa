import junit.framework.*;

public class ExampleTest extends TestCase {

  public static void main (String[] args) {
    junit.textui.TestRunner.run(ExampleTest.class);
  }

  @org.junit.jupiter.api.Test
  public void testCase1() {
    Example x2167 = new Example();
    Triangle1 x2168 = new Triangle1(-53, -33, 24);
    x2167.checkTriangle(x2168);
    System.out.println("OK");
  }

  @org.junit.jupiter.api.Test
  public void testCase2() {
    Example x3802 = new Example();
    Triangle1 x3803 = new Triangle1(97, 95, 86);
    x3802.checkTriangle(x3803);
    System.out.println("OK");
  }

  @org.junit.jupiter.api.Test
  public void testCase3() {
    Example x76 = new Example();
    Triangle1 x77 = new Triangle1(19, 23);
    x76.checkTriangle(x77);
    System.out.println("OK");
  }

  @org.junit.jupiter.api.Test
  public void testCase4() {
    Example x1072 = new Example();
    Triangle1 x1073 = new Triangle1(53);
    x1072.checkTriangle(x1073);
    System.out.println("OK");
  }

  }
