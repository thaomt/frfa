package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.BasePage;

public class CreateCategoriesPage extends BasePage{

	public CreateCategoriesPage(WebDriver driver) {
		super(driver);
	}
	By addNew=By.xpath("/html/body/div[3]/div[1]/div[1]/div/a");
	By txtName=By.xpath("//*[@id='Name']");
	By btnSave=By.xpath("//button[@name='save']");
	By message=By.xpath("//div[@class='alert alert-success alert-dismissable']");
	By btnLogOut=By.xpath("//*[@id='navbarText']/ul/li[3]/a");
	public void clickAddNew() {
		driver.findElement(addNew).click();
	}
	public void inputCategoriesName(String name) {
		driver.findElement(txtName).sendKeys(name);
	}
	public void clickSave() {
		driver.findElement(btnSave).click();
	}
	public String getTextNode(WebElement element) {
		String text = element.getText().trim();
		List<WebElement> children = element.findElements(By.xpath("./*"));
		for (WebElement child : children) {
			text = text.replaceFirst(child.getText(), "").trim();
		}
		return text;
	}
	public void clickLogOut() {
		driver.findElement(btnLogOut).click();
	}
	
	public String message() {
		//waitForElementVisible(driver, driver.findElement(message).);
		return getTextNode(driver.findElement(message));
	}
	
	

}
