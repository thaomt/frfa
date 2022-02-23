package Final.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Final.core.BasePage;
public class ProductsPage extends BasePage{

	public ProductsPage(WebDriver driver) {
		super(driver);
	}
	By catalog=By.xpath("//li[@class='has-ul'][1]//a[@href='#']//span");
	By products=By.xpath("//li[@class='has-ul active']//ul[@class='hidden-ul']//li[2]//a//span");
	By btnCreat=By.xpath("//*[@id='action-toolbar-create']");
	By btnSetting=By.xpath("//*[@id='grid-settings-form']");
	By btnBulkEdit=By.xpath("//*[@id='action-toolbar-bulkedit']");
	By btnBulkDelete=By.xpath("//*[@id='action-toolbar-bulkdelete']");
	By tblManageProducts=By.xpath("//table[@class='table dataTable no-footer']");
	public boolean checkDisplay(By elemnt) {
		if(driver.findElement(elemnt).isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}
	public void navigateCatalog() {
		driver.findElement(catalog).click();
	}
	public void navigateProducts() {
		driver.findElement(products).click();
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
	public boolean checkDisplayManageProductTable() {
		return checkDisplay(tblManageProducts);
	}
	public void clickCreatButton() {
		driver.findElement(btnCreat).click();
	}

}
