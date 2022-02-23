package exercise_1.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import exercise_1.core.BasePage;

public class SeleniumPage extends BasePage{

	public SeleniumPage(WebDriver driver) {
		super(driver);
	}
	By itemList=By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");
	By productTitle=By.id("productTitle");
	public void clikFirtItem() {
		driver.findElements(itemList).get(0).click();
		
	}
	public String getTititle() {
		return driver.findElement(productTitle).getText();
	}

}
