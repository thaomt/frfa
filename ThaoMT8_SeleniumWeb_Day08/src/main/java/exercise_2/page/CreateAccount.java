package exercise_2.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccount {
	WebDriver driver;
	public CreateAccount(WebDriver driver){
        this.driver = driver;
    }
	By btnCreatAccount = By.xpath("//button[@id='SubmitCreate']");
	By txtEmail=By.xpath("//input[@id='email_create']");
	
	public void clickCreate() {
		driver.findElement(btnCreatAccount).click();
	}
	public void enterEmail(String email) {
		driver.findElement(txtEmail).sendKeys(email);;
	}


}
