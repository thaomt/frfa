package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.BasePage;
public class GooglePage extends BasePage{
	public GooglePage(WebDriver driver) {
		super(driver);
	}
	//By btnInput=By.xpath("//input[@name='q']");
	public WebElement btnInput(String input) {
		By btnInput=By.xpath(input);
		WebElement inputBox = driver.findElement(btnInput);
		return inputBox;
	}
	public void inputValue(WebElement btnInput,String value) {
		btnInput.sendKeys(value);
	}
	public void pressEnter(WebElement btnInput) {
		btnInput.sendKeys(Keys.ENTER);
	}
	public String checkResult() {
		String actualResult=driver.getTitle();
		return actualResult;
	}

}
