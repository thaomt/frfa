package exercise_3.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
public void clickWomen() {
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		WebElement element = driver.findElement(By.xpath("//a[@title='Women']"));
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				executor.executeScript("arguments[0].click();", element);
			} else {
				System.out.println("Unable to click on element");
			}
		}catch (Exception e) {
			System.out.println("Unable to click on element "+ e.getStackTrace());
		}
	}

}
