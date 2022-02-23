package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import core.BasePage;

public class LoginPage extends BasePage{
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	By txtEmail=By.xpath("//input[@id='Email']");
	By txtPassWord=By.xpath("//input[@id='Password']");
	By btnSignIn=By.xpath("//button[@class='button-1 login-button']");
	public void inputEmail(String email) {
		driver.findElement(txtEmail).clear();
		driver.findElement(txtEmail).sendKeys(email);
	}
	public void inputPassWord(String password) {
		driver.findElement(txtPassWord).clear();
		driver.findElement(txtPassWord).sendKeys(password);
	}
	public void clickLogin() {
		driver.findElement(btnSignIn).click();
	}

	
	
}
