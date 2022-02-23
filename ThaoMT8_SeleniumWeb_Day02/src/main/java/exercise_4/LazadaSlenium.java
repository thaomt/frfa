package exercise_4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.edge.EdgeDriver;



public class LazadaSlenium {
	EdgeDriver edgeDriver;
	String lazada = "https://www.lazada.vn/";

	public void getTitlePage() {

		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\thaoc\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		edgeDriver = new EdgeDriver();

		edgeDriver.manage().window().maximize();

		edgeDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		edgeDriver.get(lazada);

		String titleOfThePage = edgeDriver.getTitle();
		System.out.println(titleOfThePage);

		if (titleOfThePage.contains("LAZADA")) {
			System.out.println("Title of page is contains \"LAZADA\" ");
		} else {
			System.out.println("Title of page isn't contains \"LAZADA\" ");
		}
		edgeDriver.quit();

	}

	public static void main(String[] args) {
		LazadaSlenium lazadaSlenium = new LazadaSlenium();
		lazadaSlenium.getTitlePage();

	}

}
