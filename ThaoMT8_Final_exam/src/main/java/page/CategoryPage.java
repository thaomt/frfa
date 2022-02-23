package page;

import core.AppiumBase;
import core.BasePage;
import element.App_elements;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class CategoryPage extends AppiumBase{
	public void scrollandClickHomeGardenAndClick() throws InterruptedException {
		Thread.sleep(3000);
		MobileElement element = (MobileElement) driver.findElement(
				MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
				+ ".scrollIntoView(new UiSelector().text(\"Home and Garden\"))"));
		element.click();
		
		
	}
	public void ClickHomeGarden() throws InterruptedException {
		Thread.sleep(3000);
		getDriver().findElementsById(App_elements.homeGarden).get(7).click();
		
	}
	public boolean verifyDisplayRight() throws InterruptedException {
		Thread.sleep(3000);
		return BasePage.checkDisplay(getDriver().findElementById(App_elements.rightCategory));
	}
	public void clickHomeDecor() throws InterruptedException {
		Thread.sleep(5000);
		getDriver().findElementsById(App_elements.rightCategory).get(3).click();	
	}
	public void clickFilter() throws InterruptedException {
		Thread.sleep(3000);
		getDriver().findElementById(App_elements.filter).click();	
	}
	public void inputPrice() throws InterruptedException {
		Thread.sleep(3000);
		getDriver().findElementById(App_elements.priceMin).sendKeys("20");	
		getDriver().findElementById(App_elements.priceMax).sendKeys("30");	
	}
	public void clickBtnDone() throws InterruptedException {
		Thread.sleep(3000);
		getDriver().findElementById(App_elements.btnDone).click();	
	}
	public void clickFirstProduct() throws InterruptedException {
		Thread.sleep(5000);
		getDriver().findElementsById(App_elements.name).get(0).click();	
	}
	public boolean verifyDisplayName() throws InterruptedException {
		Thread.sleep(3000);
		return BasePage.checkDisplay(getDriver().findElementById(App_elements.name));
	}
	public boolean verifyDisplayPrice() throws InterruptedException {
		Thread.sleep(3000);
		return BasePage.checkDisplay(getDriver().findElementById(App_elements.price));
	}
	
	
}
