import junit.framework.*;

public class BinarySearchTest extends TestCase {

  public static void main (String[] args) {
    junit.textui.TestRunner.run(BinarySearchTest.class);
  }

  @org.junit.jupiter.api.Test
  public void testCase1() {
    BinarySearch x1 = new BinarySearch();
	int[] t = {-1,-43,73};
    x1.search(t, -84);
    System.out.println("OK");
  }

  @org.junit.jupiter.api.Test
  public void testCase2() {
    BinarySearch x9 = new BinarySearch();
	int[] t = {-45,-33,-48};
    x9.search(t, 46);
    System.out.println("OK");
  }

  @org.junit.jupiter.api.Test
  public void testCase3() {
    BinarySearch x2877 = new BinarySearch();
	int[] t = {-24,-32,98,91,-5,-61};
    x2877.search(t, -24);
    System.out.println("OK");
  }

  }
