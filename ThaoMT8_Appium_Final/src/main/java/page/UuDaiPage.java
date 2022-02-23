package page;

import core.AppiumBase;
import core.BasePage;
import element.App_Element;

public class UuDaiPage extends AppiumBase{
	public void clickUuDai() throws InterruptedException {
		Thread.sleep(2000);
		getDriver().findElementByXPath(App_Element.uuDai).click();
		BasePage.clickTab(getDriver().findElementByXPath(App_Element.uuDai), getDriver());
	}
	public void clickFirstItem() throws InterruptedException {
		Thread.sleep(4000);
		getDriver().findElementsById(App_Element.firstItem).get(0).click();
		BasePage.clickTab(getDriver().findElementsById(App_Element.firstItem).get(0), getDriver());
	}
	public boolean verifyDisplayDiscountImage() throws InterruptedException {
		Thread.sleep(2000);
		return BasePage.checkDisplay(getDriver().findElementById(App_Element.discountImage));
	}
	public boolean verifyDisplayDescription() throws InterruptedException {
		Thread.sleep(2000);
		return BasePage.checkDisplay(getDriver().findElementById(App_Element.description));
	}
	public boolean verifyDisplayButtonMuaNhan() throws InterruptedException {
		Thread.sleep(2000);
		return BasePage.checkDisplay(getDriver().findElementByClassName(App_Element.btnMuaNhanHoanTien));
	}
}
