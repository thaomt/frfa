package exercise_2.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import exercise_2.core.BasePage;


public class SearchStorePage extends BasePage{

	public SearchStorePage(WebDriver driver) {
		super(driver);
	}
	By itemFirst=By.xpath("//h5[@itemprop='name']//a[@class='product-name']");
	public void clikFirtItem() {
		driver.findElement(itemFirst).click();		
	}

}
