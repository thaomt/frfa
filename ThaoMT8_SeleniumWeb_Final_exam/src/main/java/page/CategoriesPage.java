package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import core.BasePage;

public class CategoriesPage extends BasePage{

	public CategoriesPage(WebDriver driver) {
		super(driver);
	}
	By catalog=By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[2]/a");
	By categories=By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[2]/ul/li[2]/a/p");
	By addNew=By.xpath("/html/body/div[3]/div[1]/div[1]/div/a");
	By export=By.xpath("//button[@class='btn btn-success']");
	By btnImport=By.xpath("//button[@name='importexcel']");
	By delete=By.xpath("//button[@id='delete-selected']");
	By categoriesName=By.xpath("//input[@class='form-control text-box single-line']");
	By published=By.xpath("//*[@id='SearchPublishedId']");
	public void clickCatalog() {
		driver.findElement(catalog).click();
	}
	public void clickCategories() {
		driver.findElement(categories).click();
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
	public boolean checkDisplayCategoriesName() {
		return checkDisplay(categoriesName);
	}
	public boolean checkDisplayPublished() {
		return checkDisplay(published);
	}
	
	

}
