package page;

import core.AppiumBase;
import core.BasePage;
import element.App_Element;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class VoucherPage extends AppiumBase{
	public void clickVoucher() throws InterruptedException {
		Thread.sleep(2000);
		getDriver().findElementByXPath(App_Element.voucher).click();
		BasePage.clickTab(getDriver().findElementByXPath(App_Element.voucher), getDriver());
	}
	public void scrolll() throws InterruptedException {
		Thread.sleep(5000);
		MobileElement element = (MobileElement) driver.findElement(
				MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
				+ ".scrollIntoView(new UiSelector().text(\"Voucher tiền mặt trị giá 20K tại Grab\"))"));
	}
	public void clickLastItem() throws InterruptedException {
		Thread.sleep(5000);
		getDriver().findElementsById("com.nct.shopiness:id/tvProduct").get(4).click();
	}
	public boolean verifyDisplayImageVoucher() throws InterruptedException {
		Thread.sleep(4000);
		return BasePage.checkDisplay(getDriver().findElementById(App_Element.voucherImage));
	}
	public boolean verifyDisplayNameVoucher() throws InterruptedException {
		Thread.sleep(4000);
		return BasePage.checkDisplay(getDriver().findElementById(App_Element.voucherName));
	}
	public boolean verifyDisplayDescriptionVoucher() throws InterruptedException {
		Thread.sleep(4000);
		return BasePage.checkDisplay(getDriver().findElementById(App_Element.descriptionVoucher));
	}
	public boolean verifyDisplayButtonMuaNgay() throws InterruptedException {
		Thread.sleep(4000);
		return BasePage.checkDisplay(getDriver().findElementsByClassName(App_Element.btnMuaNgay).get(0));
	}
	public boolean verifyDisplayAddCart() throws InterruptedException {
		Thread.sleep(2000);
		return BasePage.checkDisplay(getDriver().findElementsByClassName(App_Element.btnAddCart).get(1));
	}

}
