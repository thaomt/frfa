package exercise_2.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import exercise_2.core.BasePage;
public class FirstProductPage extends BasePage{

	public FirstProductPage(WebDriver driver) {
		super(driver);
	}
	By price=By.xpath("//span[@id='our_price_display']");
	By title=By.xpath("//h1[@itemprop='name']");
	By btnAdd=By.xpath("//button[@class='exclusive']/span");
	By notify=By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2");
	public String getPrice() {
		return driver.findElement(price).getText();
	}
	public String getTitle() {
		return driver.findElement(title).getText();
	}
	public void clickAdd() {
		driver.findElement(btnAdd).click();
	}
	public String notifyDisplay() {
		return driver.findElement(notify).getText();
	}

}
