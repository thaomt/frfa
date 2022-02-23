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
import Final.page.ProductsCreatePage;
import Final.page.ProductsPage;

public class test06_07 {
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
	
	@Test(dataProvider = "testData")
	public void test(Object name,Object alias,Object image, Object SKU,Object price, Object quantity,Object categories,Object message) throws InterruptedException{
		String valueAlias=alias.toString();
		String valueSKU=SKU.toString();
		String valuePrices=price.toString();
		String valueQuantity=quantity.toString();
		String valueCategories=categories.toString();
		String valueMessage=message.toString();
		String valueName=name.toString();
		String valueImage=image.toString();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName("super");
		loginPage.enterPassWord("admin");
		loginPage.clickSignIn();
		ProductsPage productsPage=new ProductsPage(driver);
		Thread.sleep(3000);
		productsPage.navigateCatalog();
		Thread.sleep(3000);
		productsPage.navigateProducts();
		productsPage.clickCreatButton();
		ProductsCreatePage productsCreatePage=new ProductsCreatePage(driver);
		productsCreatePage.inputName(valueName);
		productsCreatePage.inputAlias(valueAlias);
		productsCreatePage.clickSpecifications();
		productsCreatePage.inputSKU(valueSKU);
		productsCreatePage.inputPrice(valuePrices);
		productsCreatePage.inputQuantity(valueQuantity);
		productsCreatePage.inputCategories(valueCategories);
		if(image.equals("")){			
			productsCreatePage.clickSaveNotifiImage();
			Thread.sleep(3000);
			assertEquals(productsCreatePage.notifyImage(),valueMessage);
		}
		if(name.equals("")){
			productsCreatePage.uploadImage(valueImage);
			productsCreatePage.clickSaveNotifiName();
			Thread.sleep(3000);
			assertEquals(productsCreatePage.notifyName(), valueMessage);
		}
				
	}
	@DataProvider(name = "testData")
    public Object[][] getDataFromExcel() throws Exception {
	 Object[][] testObjArray = ExcelUtils.getValue06_07(System.getProperty("user.dir") +"\\src\\main\\java\\data\\Datas.xlsx","Sheet2");
		return (testObjArray);
	 
 }
	 
	
	
	/*
	 * 01,02 vào 1 class: LoginTest
@Test 
public void verifyLoginPage()
@Test
public void verifyLoginSuccess()

liên quan tới product page-> ProductCategoriesTest
@Test 
public void verifyProductCategoriesPage()
@Test
public void verifyNameFiles()

liên quan tới AtrributeGroupTest
@Test 
public void verify()
@Test
public void verify()

LoginPage
HomePage/Darbord Page
ProductPage
	 */

}
