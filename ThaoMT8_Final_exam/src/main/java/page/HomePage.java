package page;

import core.AppiumBase;
import element.App_elements;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class HomePage extends AppiumBase{
	public void clickCategory() throws InterruptedException{
		Thread.sleep(3000);
		getDriver().findElementsById(App_elements.footer).get(0).click();
	}
	public void scrollHotCategories() throws InterruptedException{
		Thread.sleep(3000);
		/*driver.findElementByAndroidUIAutomator("new UiScrollable("
				+ "new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"Hot Categories\"));")
				.click();*/
		MobileElement element2 = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
		        "new UiScrollable(new UiSelector().scrollable(true))" +
		         ".scrollIntoView(new UiSelector().resourceIdMatches(\".*com.banggood.client:id/tv_title*\"))"));
	}
	public void clickFirstCategories() throws InterruptedException{
		Thread.sleep(3000);
		getDriver().findElementsById(App_elements.hotCategories).get(0).click();
	}
	public void clickAccount() throws InterruptedException{
		Thread.sleep(3000);
		getDriver().findElementsById(App_elements.footer).get(3).click();
	}
	
}
