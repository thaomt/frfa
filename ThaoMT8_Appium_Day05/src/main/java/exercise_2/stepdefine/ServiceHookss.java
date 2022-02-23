package exercise_2.stepdefine;

import java.net.MalformedURLException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import exercise_2.core.AppiumBases;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ServiceHookss {
	AppiumBases appiumBase=new AppiumBases();
	@Before
	public void initalizeTest() throws MalformedURLException {
		appiumBase.setup();
	}
	@After
	public void afterHookFunction(Scenario scenario) {
		if(scenario.isFailed()) {
			scenario.attach(((TakesScreenshot)AppiumBases.driver).getScreenshotAs(OutputType.BYTES), "image/png", "image");
		}
		appiumBase.teardown();
	}


}
