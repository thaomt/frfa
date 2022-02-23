package exercise_3.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopsPage {
	WebDriver driver;
	public TopsPage(WebDriver driver) {
		this.driver=driver;
	}
	By tShirts=By.xpath("//*[@id='categories_block_left']/div/ul/li[1]/a");
	public void movesBack() {
		driver.navigate().back(); 
	}
	public void  moveForward() {
		driver.navigate().forward(); 		
	}
	public void clickT_Shirts() {
		driver.findElement(tShirts).click();
	}
	
	

}
