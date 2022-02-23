package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.BasePage;

public class ProductCategoriesPage extends BasePage{

	public ProductCategoriesPage(WebDriver driver) {
		super(driver);
	}
	By catalog=By.xpath("//li[@class='has-ul'][1]//a[@href='#']//span");
	By productCategories=By.xpath("//li[@class='has-ul active']//ul[@class='hidden-ul']//li[1]//a//span");
	By btnCreat=By.xpath("//*[@id='action-toolbar-create']");
	By btnSetting=By.xpath("//*[@id='grid-settings-form']");
	By btnBulkEdit=By.xpath("//*[@id='action-toolbar-bulkedit']");
	By btnBulkDelete=By.xpath("//*[@id='action-toolbar-bulkdelete']");
	By tblManageProductCategories=By.xpath("//table[@class='table dataTable no-footer']");
	public boolean checkDisplay(By elemnt) {
		if(driver.findElement(elemnt).isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}
	public void navigateToCatalog() {
		driver.findElement(catalog).click();
	}
	public void navigateToProductCategories() {
		driver.findElement(productCategories).click();
	}
	public boolean checkDisplayCreat() {
		return checkDisplay(btnCreat);
	}
	public boolean checkDisplaySetting() {
		return checkDisplay(btnSetting);
	}
	public boolean checkDisplayBulkEdit() {
		return checkDisplay(btnBulkEdit);
	}
	public boolean checkDisplayBulkDelete() {
		return checkDisplay(btnBulkDelete);
	}
	public boolean checkDisplayManageProductCategoriesTable() {
		return checkDisplay(tblManageProductCategories);
	}
	public void clickCreatButton() {
		driver.findElement(btnCreat).click();
	}

}
