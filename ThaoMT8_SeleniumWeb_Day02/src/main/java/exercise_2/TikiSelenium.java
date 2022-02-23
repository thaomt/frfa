package exercise_2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class TikiSelenium {
	ChromeDriver chromeDriver;
	String tiki = "https://tiki.vn/";
	public void getTitlePage() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\thaoc\\Downloads\\chromedriver_win32\\chromedriver.exe");
		chromeDriver = new ChromeDriver();

		chromeDriver.manage().window().maximize();

		chromeDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		chromeDriver.get(tiki);

		String titleOfThePage = chromeDriver.getTitle();
		System.out.println(titleOfThePage);

		if (titleOfThePage.contains("tiki.vn")) {
			System.out.println(" Title of page is contains \"tiki.vn\" ");
		} else {
			System.out.println("Title of page isn't contains \"tiki.vn\" ");
		}
		chromeDriver.quit();

	}
	public static void main(String[] args) {
		TikiSelenium tikiSelenium = new TikiSelenium();
		tikiSelenium.getTitlePage();

	}

	

}
