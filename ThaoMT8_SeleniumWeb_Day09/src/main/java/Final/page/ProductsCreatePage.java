package Final.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Final.core.BasePage;
public class ProductsCreatePage extends BasePage {

	public ProductsCreatePage(WebDriver driver) {
		super(driver);
	}

	By txtName = By.xpath("//input[@id='product-name']");
	By txtAlias = By.xpath("//input[@id='product-alias']");
	By imgImage = By.xpath("//input[@id='product-image']");
	By txtSKU = By.xpath("//input[@id='product-sku']");
	By txtPrice = By.xpath("//input[@id='product-price']");
	By txtQuantity = By.xpath("//input[@id='product-quantity']");
	By txtCode = By.xpath("//input[@id='productcategory-code']");
	By txtCategories = By.xpath("//div[@id='s2id_product-categories']//ul[@class='select2-choices']");
	By selectCategories = By.xpath("//body/div[@id='select2-drop']/ul[1]/li[2]");
	By btnSave = By.xpath("//button[@id='save']");
	By notifyName = By.xpath("//*[@id='w0-tabgeneral']/div[1]/div/div");
	By notifyImage = By.xpath("//*[@id='w0-tabdata']/div[3]/div/div");
	By data = By.xpath("//*[@id='w0']/li[2]/a");
	By specifications = By.xpath("//*[@id='w0']/li[3]/a");
	By related = By.xpath("//*[@id='w0']/li[4]/a");

	public void inputAlias(String alias) {
		driver.findElement(txtAlias).sendKeys(alias);
	}

	public void uploadImage(String image) {
		driver.findElement(data).click();
		WebElement attachFile = driver.findElement(imgImage);
		attachFile.sendKeys(System.getProperty("user.dir") + "\\src\\main\\java\\data\\"+image);
	}

	public void clickSpecifications() {
		driver.findElement(specifications).click();
	}

	public void inputSKU(String SKU) {
		driver.findElement(txtSKU).sendKeys(SKU);
	}

	public void inputPrice(String price) {
		driver.findElement(txtPrice).sendKeys(price);
	}

	public void inputQuantity(String quantity) {
		driver.findElement(txtQuantity).sendKeys(quantity);
	}

	public void inputCategories(String categories) {
		driver.findElement(related).click();
		driver.findElement(txtCategories).click();
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(selectCategories)).perform();
		driver.findElement(selectCategories).click();
		builder.sendKeys(Keys.ESCAPE).build().perform(); 
	}

	public void clickSaveNotifiName() {
		driver.findElement(By.linkText("General")).click();
		driver.findElement(btnSave).click();
	}

	public void inputName(String name) {
		driver.findElement(By.linkText("General")).click();
		driver.findElement(txtName).sendKeys(name);
	}

	public String notifyName() {
		driver.findElement(By.linkText("General")).click();
		return driver.findElement(notifyName).getText();
	}

	public String notifyImage() {
		return driver.findElement(notifyImage).getText();
	}

	public void clickSaveNotifiImage() {
		driver.findElement(By.linkText("Data")).click();
		driver.findElement(btnSave).click();
	}

}
