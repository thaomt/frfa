package exercise_1.test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import exercise_1.page.Login;
import exercise_1.page.Message;

public class TestLogin {

	WebDriver driver;
	Login login ;
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
		login=new Login(driver);
		message=new Message(driver);
	}
	@Test
	public void TC_01_ValidEmailPassword() throws InterruptedException {
		login.enterEmail("thao@gmail.com");
		login.enterPassword("mail1111");
		login.clickLogin();
		Thread.sleep(2000);	
		System.out.println("Message: " + message.getMessage());
		
	}
	@Test
	public void TC_02_InValidEmailPassword() throws InterruptedException {
		login.enterEmail("thao@gmail");
		login.enterPassword("1234");
		login.clickLogin();
		Thread.sleep(2000);	
		System.out.println("Message: " + message.getMessage());
		
	}
	@Test
	public void TC_03_PassEmailPassword() throws InterruptedException {
		login.enterEmail("thao@gmail.com");
		login.enterPassword("123456");
		login.clickLogin();
		Thread.sleep(2000);	
		try{
			System.out.println("Message: " + message.getMessage());
		}catch(Exception e) {
			System.out.println("Your account is pressed");
		}		
	}
	@After
	public void tearDown() {
		driver.quit();
	}

}
