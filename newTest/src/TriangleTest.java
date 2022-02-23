import junit.framework.*;

public class TriangleTest extends TestCase {

  public static void main (String[] args) {
    junit.textui.TestRunner.run(TriangleTest.class);
  }

  @org.junit.jupiter.api.Test
  public void testCase1() {
    Triangle x21 = new Triangle(79, 83);
    x21.checkTriangle();
    System.out.println("OK");
  }

  @org.junit.jupiter.api.Test
  public void testCase2() {
    Triangle x837 = new Triangle(30);
    x837.checkTriangle();
    System.out.println("OK");
  }

  @org.junit.jupiter.api.Test
  public void testCase3() {
    Triangle x617 = new Triangle(-98);
    x617.checkTriangle();
    System.out.println("OK");
  }

  @org.junit.jupiter.api.Test
  public void testCase4() {
    Triangle x1055 = new Triangle(60, 74, 61);
    x1055.checkTriangle();
    System.out.println("OK");
  }

  }
