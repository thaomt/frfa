package test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="../ThaoMT8_Final_exam/src/main/resources/features/Test.feature",
		glue="stepdefine"
)
public class RunTest extends AbstractTestNGCucumberTests {
	// this class will run instead of Test.feature file

}
