package exercise_1.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import exercise_1.core.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	By btnSearch=By.id("twotabsearchtextbox");
	By btnGo=By.id("nav-search-submit-button");
	By selectAll=By.xpath("//select[@aria-describedby='searchDropdownDescription']");
	public void selectBooks(String item) {
		Select slect=new Select(driver.findElement(selectAll));
		slect.selectByVisibleText(item);
	}
	public void sendValueSearch(String item) {
		driver.findElement(btnSearch).sendKeys(item);
	}
	public void clickGo() {
		driver.findElement(btnGo).click();
	}

}
