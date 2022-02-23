package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.BasePage;

public class CreateProductsPage extends BasePage{

	public CreateProductsPage(WebDriver driver) {
		super(driver);
	}
	By addNew=By.xpath("/html/body/div[3]/div[1]/form[1]/div/div/a");
	By productInfo=By.xpath("//*[@id=\"product-info\"]/div[1]/div[2]/button/i");
	By productName=By.xpath("//*[@id=\"Name\"]");
	By shortDescription=By.xpath("//textarea[@class='form-control']");
	By sku=By.xpath("//input[@id='Sku']");
	By categories=By.xpath("//*[@id=\"product-info\"]/div[2]/div[2]/div[2]/div/div");
	By prices=By.xpath("//*[@id=\"product-price\"]/div[1]/div[2]/button/i");
	By txtPrice=By.xpath("//*[@id=\"Price\"]");
	By txtOldPrice=By.xpath("//*[@id=\"OldPrice\"]");
	By btnSave=By.xpath("//button[@name=\"save\"]");
	By message=By.xpath("//div[@class='alert alert-success alert-dismissable']");
	By btnLogOut=By.xpath("//*[@id='navbarText']/ul/li[3]/a");
	
	public void clickAddNew() {
		driver.findElement(addNew).click();
	}
	public void clickProductInfo() {
		driver.findElement(productInfo).click();
	}
	public void inputProductName(String name) {
		driver.findElement(productName).sendKeys(name);
	}
	public void inputShortDescription(String shortDescript) {
		driver.findElement(shortDescription).sendKeys(shortDescript);
	}
	public void inputSku(String skus) {
		driver.findElement(sku).sendKeys(skus);
	}
	public void inputcategories(String categorie) {
		driver.findElement(categories).sendKeys(categorie);
	}
	public void clickPrices() {
		driver.findElement(prices).click();
	}
	public void inputPrice(String price) {
		driver.findElement(txtPrice).sendKeys(price);
	}
	public void inputOldPrice(String oldprice) {
		driver.findElement(txtOldPrice).sendKeys(oldprice);
	}
	public void clickSave() {
		driver.findElement(btnSave).click();
	}
//	public String message() {
//		return driver.findElement(message).getText();
//		
//	}
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
