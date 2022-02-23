package exercise_1.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Message {
	WebDriver driver;
	public Message(WebDriver driver) {
		this.driver=driver;
	}
	By message = By.xpath("//div[@class='alert alert-danger']//li");
	public String getMessage() {
		String mess = driver.findElement(message).getText();
		return mess;
	}
	
}
