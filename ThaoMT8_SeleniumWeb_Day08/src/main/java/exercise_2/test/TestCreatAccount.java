package exercise_2.test;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import exercise_2.page.CreateAccount;
import exercise_2.page.Message;

public class TestCreatAccount {
	WebDriver driver;
	CreateAccount createAccount ;
	Message message;
	String link = "http://automationpractice.com/index.php?controller=authentication";
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\thaoc\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get(link);
		createAccount=new CreateAccount(driver);
		message=new Message(driver);
	}
	@Test
	public void TC_01_ValidEmail() throws InterruptedException {
		createAccount.enterEmail("thaoo@gmail.com");
		createAccount.clickCreate();
		Thread.sleep(2000);	
		try{
			System.out.println("Message: " + message.getMessage());
		}catch(Exception e){
			System.out.println("Your account is not creat, let creat now");
		}
		
	}
	@Test
	public void TC_02_InValidEmail() throws InterruptedException {
		createAccount.enterEmail("thao@gmail");
		createAccount.clickCreate();
		Thread.sleep(2000);	
		System.out.println("Message: " + message.getMessage());
		
	}
	@Test
	public void TC_03_BlankEmail() throws InterruptedException {
		createAccount.enterEmail("");
		createAccount.clickCreate();
		Thread.sleep(2000);	
		System.out.println("Message: " + message.getMessage());
		
	}
	
	@Test
	public void TC_04_ExistEmail() throws InterruptedException {
		createAccount.enterEmail("thao@gmail.com");
		createAccount.clickCreate();
		Thread.sleep(2000);	
	    System.out.println("Message: " + message.getMessage());		
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	/*public boolean isElementVisible(By locator, int timeOutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } catch (Exception e1) {
            return false;
        }
    }*/
	// bo sung wait o basetest

}
