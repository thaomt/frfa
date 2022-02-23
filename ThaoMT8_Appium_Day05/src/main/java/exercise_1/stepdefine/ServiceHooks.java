package exercise_1.stepdefine;

import java.net.MalformedURLException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import exercise_1.core.AppiumBase;
import exercise_1.page.HangMoiPage;
import exercise_1.page.HomePage;
import exercise_1.page.LaptopPage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ServiceHooks {
	AppiumBase appiumBase=new AppiumBase();
	@Before
	public void initalizeTest() throws MalformedURLException {
		appiumBase.setup();
	}
	@After
	public void afterHookFunction(Scenario scenario) {
		if(scenario.isFailed()) {
			scenario.attach(((TakesScreenshot)AppiumBase.driver).getScreenshotAs(OutputType.BYTES), "image/png", "image");
		}
		appiumBase.teardown();
	}


}
