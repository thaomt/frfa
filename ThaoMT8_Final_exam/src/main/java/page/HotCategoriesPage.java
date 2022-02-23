package page;

import core.AppiumBase;
import core.BasePage;
import element.App_elements;

public class HotCategoriesPage extends AppiumBase{
	public void clickFirstProduct() throws InterruptedException {
		Thread.sleep(3000);
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
	public boolean verifybtnBuyNow() throws InterruptedException {
		Thread.sleep(3000);
		return BasePage.checkDisplay(getDriver().findElementById(App_elements.btnByNow));
	}
	public boolean verifyDisplaybtnAdd() throws InterruptedException {
		Thread.sleep(3000);
		return BasePage.checkDisplay(getDriver().findElementById(App_elements.btnAdd));
	}
	public void clickAddToCart() throws InterruptedException {
		Thread.sleep(3000);
		getDriver().findElementById(App_elements.btnAdd).click();	
	}
	public void clickAddToCartButton() throws InterruptedException {
		Thread.sleep(3000);
		getDriver().findElementById(App_elements.btnAddCart).click();	
	}
	public void clickCartIcon() throws InterruptedException {
		Thread.sleep(3000);
		getDriver().findElementById(App_elements.cartIcon).click();	
	}
	public boolean verifyDisplayQuantity() throws InterruptedException {
		Thread.sleep(3000);
		return BasePage.checkDisplay(getDriver().findElementById(App_elements.quantity));
	}
	

}
