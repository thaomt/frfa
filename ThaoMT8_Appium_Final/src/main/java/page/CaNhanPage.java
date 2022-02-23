package page;

import core.AppiumBase;
import core.BasePage;
import element.App_Element;

public class CaNhanPage extends AppiumBase{
	public void clickCaNhan() throws InterruptedException {
		Thread.sleep(2000);
		getDriver().findElementByXPath(App_Element.caNhan).click();
		BasePage.clickTab(getDriver().findElementByXPath(App_Element.caNhan), getDriver());	
	}
	public boolean verifyDisplayMaUuDai() throws InterruptedException {
		Thread.sleep(2000);
		return BasePage.checkDisplay(getDriver().findElementByXPath(App_Element.maUuDai));
	}
	public boolean verifyDisplayUuDai() throws InterruptedException {
		Thread.sleep(2000);
		return BasePage.checkDisplay(getDriver().findElementByXPath(App_Element.uuDaiTab));
	}
	public boolean verifyDisplayVoucher() throws InterruptedException {
		Thread.sleep(2000);
		return BasePage.checkDisplay(getDriver().findElementByXPath(App_Element.voucherTab));
	}
	public boolean verifyDisplayThuongHieu() throws InterruptedException {
		Thread.sleep(2000);
		return BasePage.checkDisplay(getDriver().findElementByXPath(App_Element.thuongHieuTab));
	}
	

}
