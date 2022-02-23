package page;

import core.AppiumBase;
import core.BasePage;
import element.App_elements;

public class AccountPage extends AppiumBase{
	public void clickViewAllOrder() throws InterruptedException {
		Thread.sleep(3000);
		getDriver().findElementById(App_elements.viewAll).click();	
	}
	public boolean verifyDisplayEmail() throws InterruptedException {
		Thread.sleep(3000);
		return BasePage.checkDisplay(getDriver().findElementById(App_elements.email));
	}
	public boolean verifyDisplayPassword() throws InterruptedException {
		Thread.sleep(3000);
		return BasePage.checkDisplay(getDriver().findElementById(App_elements.password));
	}
	public boolean verifyDisplayBtnSignIn() throws InterruptedException {
		Thread.sleep(3000);
		return BasePage.checkDisplay(getDriver().findElementById(App_elements.btnSignIn));
	}

}
