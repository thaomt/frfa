package exercise_2.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import exercise_2.core.BasePage;

public class CartPage extends BasePage{

	public CartPage(WebDriver driver) {
		super(driver);
	}
	By checkOut=By.xpath("//div[@class='button-container']//a//span");;
	By nameCheck=By.xpath("//td[@class='cart_description']//p[@class='product-name']//a");
	public void navigateCart() {
		driver.findElement(checkOut).click();		
	}
	public String getCheck() {
		return driver.findElement(nameCheck).getText();
	}
	

}
