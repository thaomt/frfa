package page;
import core.AppiumBase;
import core.BasePage;
import element.App_Element;

public class HomePage extends AppiumBase{
	public void clickKeepVersion() throws InterruptedException{
		Thread.sleep(3000);
		getDriver().findElementById(App_Element.updateVersion).click();
	}
	public void clickBatDauTraiNghiem() throws InterruptedException{
		Thread.sleep(3000);
		getDriver().findElementById(App_Element.btnTraiNghiem).click();
	}
	public void clickDeny() throws InterruptedException{
		Thread.sleep(3000);
		getDriver().findElementById(App_Element.btnDeny).click();
	}
	public boolean checkDisplayCartIcon() throws InterruptedException {
		Thread.sleep(2000);
		return BasePage.checkDisplay(getDriver().findElementById(App_Element.cart));
	}
	public boolean checkDisplaySearchIcon() throws InterruptedException {
		Thread.sleep(2000);
		return BasePage.checkDisplay(getDriver().findElementById(App_Element.search));
	}
	public boolean checkDisplayBatDauNgay() throws InterruptedException {
		Thread.sleep(2000);
		return BasePage.checkDisplay(getDriver().findElementById(App_Element.btnBatDauNgay));
	}
	public boolean checkDisplayHoanTien() throws InterruptedException {
		Thread.sleep(2000);
		return BasePage.checkDisplay(getDriver().findElementByXPath(App_Element.hoanTien));
	}
	public boolean checkDisplayThuongHieu() throws InterruptedException {
		Thread.sleep(2000);
		return BasePage.checkDisplay(getDriver().findElementByXPath(App_Element.thuongHieu));
	}
	public boolean checkDisplayUuDai() throws InterruptedException {
		Thread.sleep(2000);
		return BasePage.checkDisplay(getDriver().findElementByXPath(App_Element.uuDai));
	}
	public boolean checkDisplayVoucher() throws InterruptedException {
		Thread.sleep(2000);
		return BasePage.checkDisplay(getDriver().findElementByXPath(App_Element.voucher));
	}
	public boolean checkDisplayCaNhan() throws InterruptedException {
		Thread.sleep(2000);
		return BasePage.checkDisplay(getDriver().findElementByXPath(App_Element.caNhan));
	}
	
}
