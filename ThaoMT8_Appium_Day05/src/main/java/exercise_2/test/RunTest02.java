package exercise_2.test;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		
		features="../ThaoMT8_Assignment_Day05/src/main/resources/features/test_02.feature",
		glue=""
)
public class RunTest02 extends AbstractTestNGCucumberTests {
	// this class will run instead of test_02.feature file

}
