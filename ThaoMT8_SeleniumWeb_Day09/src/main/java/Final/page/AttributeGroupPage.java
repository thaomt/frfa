package Final.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Final.core.BasePage;


public class AttributeGroupPage extends BasePage{

	public AttributeGroupPage(WebDriver driver) {
		super(driver);
	}
	By catalog=By.xpath("//li[@class='has-ul'][1]//a[@href='#']//span");
	By attributeGroup=By.xpath("//li[@class='has-ul active']//ul[@class='hidden-ul']//li[3]//a//span");
	By btnCreat=By.xpath("//*[@id='action-toolbar-create']");
	By txtAttributeGroupName=By.xpath("//input[@id='productattributegroup-name']");
	By txtSortOrder=By.xpath("//input[@id='productattributegroup-sort_order']");
	By btnSave=By.xpath("//button[@id='save']");
	By elementTable=By.xpath("//table[@class='table dataTable no-footer']/tbody/tr[3]/td[2]");
	By update=By.xpath("//*[@id='update-productattributegroup-5']");
	By select=By.xpath("//select[@id='viewbrowsemodels']");
	By managementAttributeGroup=By.xpath("//ul[@class='breadcrumb']//li[2]");
	By table=By.xpath("//*[@id='grid-view']/div/div[2]/div[1]/table/tbody");
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
	public void navigateAttributeGroup() {
		driver.findElement(attributeGroup).click();
	}
	public void clickCreatButton() {
		driver.findElement(btnCreat).click();
	}
	public boolean verifyDisplayAttributeGroupName() {
		return checkDisplay(txtAttributeGroupName);
	}
	public boolean verifyDisplaySortOrder() {
		return checkDisplay(txtSortOrder);
	}
	public void inputAttributeGroupName(String name) {
		driver.findElement(txtAttributeGroupName).sendKeys(name);
	}
	public void clickSave() {
		driver.findElement(btnSave).click();
	}
	public String checkInTable() {
		return driver.findElement(elementTable).getText();
	}
	public void clickUpdate() {
		driver.findElement(update).click();
	}
	public void slectMemory(String text) {
		Select slect=new Select(driver.findElement(select));
		slect.selectByVisibleText(text);
	}
	public void clickBack() {
		driver.findElement(managementAttributeGroup).click();
	}
	public boolean checkTitle() {
		return driver.getTitle().equals("Create Attribute Group");
	}
	public boolean checkVerify(String name) {
		driver.findElement(table);
		List<WebElement> rows = driver.findElement(table).findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			List<WebElement> cols = row.findElements(By.tagName("td"));
			if (cols.get(1).getText().equals(name)) {
				return true;
			}			
		}
		return false;
	}

	

}
