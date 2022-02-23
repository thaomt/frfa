package exercise_1.page;
import org.openqa.selenium.WebElement;

import exercise_1.core.AppiumBase;

public class HangMoiPage extends AppiumBase{
	String first="vn.tiki.app.tikiandroid:id/tvName";
	String nameProduct="//android.widget.TextView[@content-desc=\"pdp_product_name\"]";
	String priceProduct="//android.widget.TextView[@content-desc=\"pdp_current_price\"]";
	public void clickFirstProduct() throws InterruptedException {
		Thread.sleep(2000);
		getDriver().findElementsById(first).get(2).click();

	}
	public boolean checkDisplay(WebElement element) {
		if(element.isDisplayed()) {
			return true;
		}
		return false;
	}
	public boolean checkDisplayNameProduct() throws InterruptedException {
		Thread.sleep(2000);
		return checkDisplay(getDriver().findElementByXPath(nameProduct));
	}
	public boolean checkDisplayPriceProduct() throws InterruptedException {
		Thread.sleep(2000);
		return checkDisplay(getDriver().findElementByXPath(priceProduct));
	}

}
