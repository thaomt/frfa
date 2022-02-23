package core;

import org.openqa.selenium.WebElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class BasePage {
	public static boolean checkDisplay(WebElement element) {
		if(element.isDisplayed()) {
			return true;
		}
		return false;
	}
	public static void clickTab(WebElement androidElement, AndroidDriver driver) {
		TouchAction action = new TouchAction(driver);
		action.tap(TapOptions.tapOptions().withElement
				(ElementOption.element(androidElement))).perform();
		
	}

}
