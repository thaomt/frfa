import junit.framework.*;

public class MyDateTest extends TestCase {

  public static void main (String[] args) {
    junit.textui.TestRunner.run(MyDateTest.class);
  }

  @org.junit.jupiter.api.Test
  public void testCase1() {
    MyDate x1 = new MyDate();
    x1.setMonth(-78);
    System.out.println("OK");
  }

  @org.junit.jupiter.api.Test
  public void testCase2() {
    MyDate x241 = new MyDate(-96, 7, -61);
    x241.setAsLastDayOfFebruaryInNonLeapYear();
    System.out.println("OK");
  }

  @org.junit.jupiter.api.Test
  public void testCase3() {
    MyDate x481 = new MyDate();
    x481.getYear();
    System.out.println("OK");
  }

  @org.junit.jupiter.api.Test
  public void testCase4() {
    MyDate x421 = new MyDate();
    x421.getMonth();
    System.out.println("OK");
  }

  @org.junit.jupiter.api.Test
  public void testCase5() {
    MyDate x121 = new MyDate(21, 23, -3);
    x121.setYear(94);
    System.out.println("OK");
  }

  @org.junit.jupiter.api.Test
  public void testCase6() {
    MyDate x301 = new MyDate(83, 11, 54);
    x301.setAsLastDayOfYear();
    System.out.println("OK");
  }

  @org.junit.jupiter.api.Test
  public void testCase7() {
    MyDate x61 = new MyDate();
    x61.setDay(14);
    System.out.println("OK");
  }

  @org.junit.jupiter.api.Test
  public void testCase8() {
    MyDate x181 = new MyDate(-56, -72, -87);
    x181.setAsLastDayOfFebruaryInLeapYear();
    System.out.println("OK");
  }

  @org.junit.jupiter.api.Test
  public void testCase9() {
    MyDate x361 = new MyDate(43, 68, -55);
    x361.getDay();
    System.out.println("OK");
  }

  @org.junit.jupiter.api.Test
  public void testCase10() {
    MyDate x541 = new MyDate();
    x541.isLeapYear();
    System.out.println("OK");
  }

  }
