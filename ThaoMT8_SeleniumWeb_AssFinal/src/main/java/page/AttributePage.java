package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import core.BasePage;

public class AttributePage extends BasePage{

	public AttributePage(WebDriver driver) {
		super(driver);
	}
	By catalog=By.xpath("//li[@class='has-ul'][1]//a[@href='#']//span");
	By attribute=By.xpath("//li[@class='has-ul active']//ul[@class='hidden-ul']//li[4]//a//span");
	By btnCreat=By.xpath("//*[@id='action-toolbar-create']");
	By txtAttributeName=By.xpath("//input[@id='productattribute-name']");
	By selectAttributeGroup=By.xpath("//select[@id='productattribute-attribute_group']");
	By btnSave=By.xpath("//button[@id='save']");
	By table=By.xpath("//*[@id='grid-view']/div/div[2]/div[1]/table/tbody");
	By managementContribute=By.xpath("//ul[@class='breadcrumb']//li[2]/a");
	By attributeNameInTable=By.xpath("//table[@class='table dataTable no-footer']/tbody/tr[3]/td[2]");
	By attributeGroupInTable=By.xpath("//table[@class='table dataTable no-footer']/tbody/tr[3]/td[3]");
	public void navigateCatalog() {
		driver.findElement(catalog).click();
	}
	public void navigateAttribute() {
		driver.findElement(attribute).click();
	}
	public void clickCreatButton() {
		driver.findElement(btnCreat).click();
	}
	public void inputAttributeName(String name) {
		driver.findElement(txtAttributeName).sendKeys(name);
	}
	public void selectAttributeGroup(String attribute) {
		Select select=new Select(driver.findElement(selectAttributeGroup));
		select.selectByVisibleText(attribute);
	}
	public void clickSave() {
		driver.findElement(btnSave).click();
	}
	public String verifyAttributeName() {
		return driver.findElement(attributeNameInTable).getText();
	}
	public String verifyAttributeGroup() {
		return driver.findElement(attributeGroupInTable).getText();
	}
	public void clickBack() {
		driver.findElement(managementContribute).click();
	}
	public boolean checkTitle() {
		return driver.getTitle().equals("Create Attribute");
	}
	public boolean checkVerify(String name, String group) {
		driver.findElement(table);
		List<WebElement> rows = driver.findElement(table).findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			List<WebElement> cols = row.findElements(By.tagName("td"));
			if (cols.get(1).getText().equals(name) && cols.get(2).getText().equals(group)) {
				return true;
			}			
		}
		return false;
	}
	

}
