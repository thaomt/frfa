package Final.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Final.core.BasePage;
public class HomePage extends BasePage{
	public HomePage(WebDriver driver) {
		super(driver);
	}
	By leftMenu=By.xpath("//ul[@class='navigation']");
	By lastViewrTable=By.xpath("//div[@id='latestusersgridview-pjax']");
	By lastProductTable=By.xpath("//div[@id='latestproductgridview-pjax']");
	By lastCustomer=By.xpath("//div[@id='latestcustomergridview-pjax']");
	By lastOrders=By.xpath("//div[@id='latestordergridview-pjax']");
	public boolean checkDisplay(By elemnt) {
		if(driver.findElement(elemnt).isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}
	public void checkDisplayleftMenu() {
		driver.findElements(leftMenu);
		for(int i=0;i<driver.findElements(leftMenu).size();i++) {
			if(!driver.findElements(leftMenu).get(i).isDisplayed()) {
				System.out.println("element "+i+" of left menu is not display");
			}
		}
	}
	public boolean checkDisplaylastViewrTable() {
		return this.checkDisplay(lastViewrTable);
	}
	public boolean checkDisplayLastProductTable() {
		return this.checkDisplay(lastProductTable);
	}
	public boolean checkDisplayLastCustomer() {
		return this.checkDisplay(lastCustomer);
	}
	public boolean checkDisplayLastOrders() {
		return this.checkDisplay(lastOrders);
	}
	
	
	

}
