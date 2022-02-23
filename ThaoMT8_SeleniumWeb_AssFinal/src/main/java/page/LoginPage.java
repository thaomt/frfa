package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import core.BasePage;

public class LoginPage extends BasePage{
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	By txtUserName=By.xpath("//input[@name='LoginForm[username]']");
	By txtPassWord=By.xpath("//input[@name='LoginForm[password]']");
	By btnSignIn=By.xpath("//button[@type='submit']");
	By remember=By.id("loginform-rememberme");
	public boolean checkDisplay(By elemnt) {
		if(driver.findElement(elemnt).isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}
	public boolean checkDisplayUserName() {
		return this.checkDisplay(txtUserName);
	}
	public void enterUserName(String userName) {
		if(checkDisplayUserName()) {
			driver.findElement(txtUserName).sendKeys(userName);
		}else {
			System.out.println("Can't input username");
		}
	}
	public boolean checkDisplayPassWord() {
		return this.checkDisplay(txtPassWord);
	}
	public void enterPassWord(String passWord) {
		if(checkDisplayPassWord()) {
			driver.findElement(txtPassWord).sendKeys(passWord);
		}else {
			System.out.println("Can't input passWord");
		}
	}
	public boolean checkDisplaySignIn() {
		return this.checkDisplay(btnSignIn);
	}
	public void clickSignIn() {
		if(checkDisplaySignIn()) {
			driver.findElement(btnSignIn).click();
		}else {
			System.out.println("Can't click SignIn");
		}
	}
	public boolean checkDisplayRememberMe() {
	    return this.checkDisplay(remember);
	}

}
