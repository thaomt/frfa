package test;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import core.BaseSetup;
import page.GooglePage;
import utiliti.ExcelUtils;

public class TestGooglePage extends BaseSetup {
	@Test(dataProvider = "testData")
	public void testMethod(String xpath, String content) throws InterruptedException {
		GooglePage googlePage=new GooglePage(driver);
		WebElement btnInput=googlePage.btnInput(xpath);
		googlePage.inputValue(btnInput, content);
		googlePage.pressEnter(btnInput);
		String actualResult=googlePage.checkResult();
		assertTrue(actualResult.contains(content));

	}

	@DataProvider(name = "testData")
	public Object[][] getDataFromExcel() throws Exception {
		Object[][] testObjArray = ExcelUtils
				.getTableArray(System.getProperty("user.dir") + "\\src\\main\\java\\utiliti\\Data_Test.xlsx", "Sheet1");
		return (testObjArray);
	}
}
