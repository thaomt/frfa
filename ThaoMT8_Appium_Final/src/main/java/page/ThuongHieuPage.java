package page;

import org.openqa.selenium.interactions.touch.TouchActions;

import core.AppiumBase;
import core.BasePage;
import element.App_Element;

public class ThuongHieuPage extends AppiumBase{
	public void clickThuongHieu() throws InterruptedException {
		Thread.sleep(4000);
		getDriver().findElementByXPath(App_Element.thuongHieu).click();
		BasePage.clickTab(getDriver().findElementByXPath(App_Element.thuongHieu), getDriver());		
	}
	public boolean checkElementDisplay() throws InterruptedException {
		Thread.sleep(3000);
		int size=getDriver().findElementsById(App_Element.idBrand).size();
		if(size>=8) {
			return true;
		}
		return false;
	}
	public void clickk() {
		TouchActions action = new TouchActions(driver);
		action.doubleTap(getDriver().findElementByXPath(App_Element.thuongHieu));
		action.perform();
	}

}
