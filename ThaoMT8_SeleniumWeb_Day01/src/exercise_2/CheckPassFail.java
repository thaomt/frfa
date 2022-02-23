package exercise_2;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CheckPassFail {
	@Test
	@Parameters("mark")
	public void parameterTest(int mark) {
		if(mark >=50) {
			System.out.println("PASS");
		}else {
			System.out.println("FAIL");
		}
	}

}
