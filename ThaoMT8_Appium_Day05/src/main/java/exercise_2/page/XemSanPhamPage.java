package exercise_2.page;
import org.openqa.selenium.WebElement;
import exercise_2.core.AppiumBases;
public class XemSanPhamPage extends AppiumBases{
	String first="vn.tiki.app.tikiandroid:id/tvName";
	String nameProduct="//android.widget.TextView[@content-desc=\"pdp_product_name\"]";
	String priceProduct="//android.widget.TextView[@content-desc=\"pdp_current_price\"]";
	public void clickFirstProduct() throws InterruptedException {
		Thread.sleep(5000);
		getDriver().findElementsById(first).get(2).click();

	}
	public boolean checkDisplay(WebElement element) {
		if(element.isDisplayed()) {
			return true;
		}
		return false;
	}
	public boolean checkDisplayNameProduct() throws InterruptedException {
		Thread.sleep(3000);
		return checkDisplay(getDriver().findElementByXPath(nameProduct));
	}
	public boolean checkDisplayPriceProduct() throws InterruptedException {
		Thread.sleep(3000);
		return checkDisplay(getDriver().findElementByXPath(priceProduct));
	}

}
