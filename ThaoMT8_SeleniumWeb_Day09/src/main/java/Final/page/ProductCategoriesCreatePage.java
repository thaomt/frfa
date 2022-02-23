package Final.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Final.core.BasePage;
public class ProductCategoriesCreatePage extends BasePage{

	public ProductCategoriesCreatePage(WebDriver driver) {
		super(driver);
	}
	By txtName=By.xpath("//input[@id='productcategory-name']");
	By txtAlias=By.xpath("//input[@id='productcategory-alias']");
	By imgImage=By.xpath("//input[@id='productcategory-image']");
	By txtCode=By.xpath("//input[@id='productcategory-code']");
	By btnSave=By.xpath("//button[@id='save']");
	By notifyName=By.xpath("//*[@id='productcategoryeditview']/div[2]/div/div");
	By notifyImage=By.xpath("//*[@id='productcategoryeditview']/div[4]/div/div");
	By notifyCode=By.xpath("//*[@id='productcategoryeditview']/div[10]/div/div");
	public void inputAlias(String value) {
		driver.findElement(txtAlias).sendKeys(value);
	}
	public void uploadImage(String image) {
		WebElement attachFile=driver.findElement(imgImage);
		attachFile.sendKeys(System.getProperty("user.dir")+"\\src\\main\\java\\data\\"+image);
	}
	public void inputCode(String code) {
		driver.findElement(txtCode).sendKeys(code);
	}
	public void inputName(String name) {
		driver.findElement(txtName).sendKeys(name);
	}
	public void clickSave() {
		driver.findElement(btnSave).click();
	}
	public String notifyName() {
		return driver.findElement(notifyName).getText();
	}
	public String notifyImage() {
		return driver.findElement(notifyImage).getText();
	}
	public String notifyCode() {
		return driver.findElement(notifyCode).getText();
	}
	

}
