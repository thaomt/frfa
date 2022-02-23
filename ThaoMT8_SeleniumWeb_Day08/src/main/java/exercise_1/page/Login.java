package exercise_1.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    WebDriver driver;	
	public Login(WebDriver driver) {
          this.driver = driver;
	}	
	By txtEmail = By.xpath("//input[@id='email']");
	By txtPassWord = By.xpath("//input[@id='passwd']");
	By btnSignIn = By.xpath("//button[@id='SubmitLogin']");

	public void enterEmail(String email) {
		driver.findElement(txtEmail).sendKeys(email);
	}
	public void enterPassword(String pass) {
		driver.findElement(txtPassWord).sendKeys(pass);
	}
	public void clickLogin() {
		driver.findElement(btnSignIn).click();
	}
}
