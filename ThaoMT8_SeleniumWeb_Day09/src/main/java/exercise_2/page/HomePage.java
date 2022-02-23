package exercise_2.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import exercise_2.core.BasePage;


public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	By txtValueSearch=By.id("search_query_top");
	By btnSearch=By.xpath("//button[@name='submit_search']");
	public void sendValueSearch(String item) {
		driver.findElement(txtValueSearch).sendKeys(item);
	}
	public void clickSearch() {
		driver.findElement(btnSearch).click();
	}

}
