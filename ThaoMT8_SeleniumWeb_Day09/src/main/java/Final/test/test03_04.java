package Final.test;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Final.core.ExcelUtils;
import Final.page.LoginPage;
import Final.page.ProductCategoriesCreatePage;
import Final.page.ProductCategoriesPage;

public class test03_04 {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\thaoc\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("http://demo.whatacart.com/backend/index.php/users/default/login");
	}
	
	@Test(dataProvider = "testData03_04")
	public void test(Object name,Object alias,Object image,Object code,Object message) throws InterruptedException{
		String valueAlias=alias.toString();
		String valueCode=code.toString();
		String valueMessage=message.toString();
		String valueName=name.toString();
		String valueImage=image.toString();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName("super");
		loginPage.enterPassWord("admin");
		loginPage.clickSignIn();
		ProductCategoriesPage productCategoriesPage=new ProductCategoriesPage(driver);
		Thread.sleep(2000);
		productCategoriesPage.navigateToCatalog();
		Thread.sleep(2000);
		productCategoriesPage.navigateToProductCategories();
		ProductCategoriesCreatePage productCategoriesCreatePage=new ProductCategoriesCreatePage(driver);
		productCategoriesPage.clickCreatButton();
		productCategoriesCreatePage.inputName(valueName);
		productCategoriesCreatePage.inputAlias(valueAlias);
		productCategoriesCreatePage.inputCode(valueCode);
		if(name.equals("")) {
			productCategoriesCreatePage.uploadImage(valueImage);
			productCategoriesCreatePage.clickSave();
			Thread.sleep(2000);
			assertEquals(productCategoriesCreatePage.notifyName(), valueMessage);
		}
		if(image.equals("")) {
			productCategoriesCreatePage.clickSave();
			Thread.sleep(2000);
			assertEquals(productCategoriesCreatePage.notifyImage(), valueMessage);
		}
		if(code.equals("")) {
			productCategoriesCreatePage.uploadImage(valueImage);
			productCategoriesCreatePage.clickSave();
			Thread.sleep(2000);
			assertEquals(productCategoriesCreatePage.notifyCode(),valueMessage);
		}

				
	}
	@DataProvider(name = "testData03_04")
    public Object[][] getDataFromExcel() throws Exception {
	 Object[][] testObjArray = ExcelUtils.getValue03_04(System.getProperty("user.dir") +"\\src\\main\\java\\data\\Datas.xlsx","Sheet1");
		return (testObjArray);
	 
 }

}
