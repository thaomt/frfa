package exercise_1.test;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		features="../ThaoMT8_Assignment_Day05/src/main/resources/features/test_01.feature",
		glue=""
)
public class RunTest01 extends AbstractTestNGCucumberTests {
	// this class will run instead of test_01.feature file

}
