package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import core.BasePage;

public class ProductsPage extends BasePage{

	public ProductsPage(WebDriver driver) {
		super(driver);
	}
	By catalog=By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[2]/a");
	By products=By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[2]/ul/li[1]/a/p");
	By addNew=By.xpath("/html/body/div[3]/div[1]/form[1]/div/div/a");
	By export=By.xpath("//button[@class='btn btn-success dropdown-toggle']");
	By btnImport=By.xpath("//button[@name='importexcel']");
	By delete=By.xpath("//button[@id='delete-selected']");
	By productName=By.xpath("//input[@id='SearchProductName']");
	By wareHouse=By.xpath("//select[@id='SearchWarehouseId']");
	By category=By.xpath("//select[@id='SearchCategoryId']");
	By productType=By.xpath("//select[@id='SearchProductTypeId']");
	public void clickCatalog() {
		driver.findElement(catalog).click();
	}
	public void clickProducts() {
		driver.findElement(products).click();
	}
	public boolean checkDisplay(By elemnt) {
		if(driver.findElement(elemnt).isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}
	public boolean checkDisplayAddNew() {
		return checkDisplay(addNew);
	}
	public boolean checkDisplayExport() {
		return checkDisplay(export);
	}
	public boolean checkDisplayImport() {
		return checkDisplay(btnImport);
	}
	public boolean checkDisplayDelete() {
		return checkDisplay(delete);
	}
	public boolean checkDisplayProductName() {
		return checkDisplay(productName);
	}
	public boolean checkDisplayWareHouse() {
		return checkDisplay(wareHouse);
	}
	public boolean checkDisplayCategory() {
		return checkDisplay(category);
	}
	public boolean checkDisplayProductType() {
		return checkDisplay(productType);
	}
	
	

}
