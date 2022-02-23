import junit.framework.*;

public class InsuranceProgramTest extends TestCase {

  public static void main (String[] args) {
    junit.textui.TestRunner.run(InsuranceProgramTest.class);
  }

  @org.junit.jupiter.api.Test
  public void testCase1() {
    InsuranceProgram x120 = new InsuranceProgram(89, -19);
    x120.checkResult();
    System.out.println("OK");
  }

  }
