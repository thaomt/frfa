package exercise_3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;

public class AmazonSelenium {

	FirefoxDriver firefoxDriver;
	String amazon = "https://www.amazon.com/";

	public void getTitlePage() {

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\thaoc\\Downloads\\geckodriver-v0.30.0-win64\\geckodriver.exe");
		firefoxDriver = new FirefoxDriver();

		firefoxDriver.manage().window().maximize();

		firefoxDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		firefoxDriver.get(amazon);

		String titleOfThePage = firefoxDriver.getTitle();
		System.out.println(titleOfThePage);

		if (titleOfThePage.contains("Amazon.com")) {
			System.out.println("Title of page is contains \"Amazon.com\" ");
		} else {
			System.out.println("Title of page isn't contains \"Amazon.com\" ");
		}
		

	}

	public static void main(String[] args) {
		AmazonSelenium amazonSelenium = new AmazonSelenium();
		amazonSelenium.getTitlePage();

	}
}
