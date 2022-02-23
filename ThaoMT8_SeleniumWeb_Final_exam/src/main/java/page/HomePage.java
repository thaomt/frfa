package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import core.BasePage;
public class HomePage extends BasePage{
	public HomePage(WebDriver driver) {
		super(driver);
	}
	By leftMenu=By.xpath("//ul[@class='nav nav-pills nav-sidebar flex-column nav-legacy']");
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
	
	

}
