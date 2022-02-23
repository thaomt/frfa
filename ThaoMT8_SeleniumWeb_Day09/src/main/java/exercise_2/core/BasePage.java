package exercise_2.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	protected WebDriver driver;
	private WebDriverWait wait;
	public BasePage(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver, 5,100);
	}
	

}
