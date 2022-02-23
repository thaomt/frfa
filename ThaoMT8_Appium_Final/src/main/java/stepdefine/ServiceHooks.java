package stepdefine;

import java.net.MalformedURLException;
import core.AppiumBase;
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
		appiumBase.teardown();
	}


}
