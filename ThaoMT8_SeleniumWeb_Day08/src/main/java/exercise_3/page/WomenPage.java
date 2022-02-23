package exercise_3.page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WomenPage {
	WebDriver driver;
	public WomenPage(WebDriver driver) {
		this.driver=driver;
	}
	By women=By.xpath("//a[@title='Women']");
	By dresses=By.xpath("//*[@id=\"categories_block_left\"]/div/ul/li[2]/a");
	By tops=By.xpath("//*[@id='categories_block_left']/div/ul/li[1]/a");
	public void checkDisplay() {
		if (driver.findElement(dresses).isEnabled() && driver.findElement(dresses).isDisplayed()) {		
			System.out.println("Element is display");
		} else {
			System.out.println("Element is not display");
		}	
	}
	
	public void clickTops() {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		WebElement tops=driver.findElement(By.xpath("//*[@id='categories_block_left']/div/ul/li[1]/a"));
		try {
			if (tops.isEnabled() && tops.isDisplayed()) {
				executor.executeScript("arguments[0].click();", tops);
			} else {
				System.out.println("Unable to click on element");
			}
		}catch (Exception e) {
			System.out.println("Unable to click on element "+ e.getStackTrace());
		}
	}

}
