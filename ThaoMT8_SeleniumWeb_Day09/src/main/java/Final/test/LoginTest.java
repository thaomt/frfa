package Final.test;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Final.core.BaseTest;
import Final.page.HomePage;
import Final.page.LoginPage;

public class LoginTest extends BaseTest{
	@Test
	public void TC01_verifyLoginPage() {
		LoginPage loginPage = new LoginPage(driver);
		assertTrue(loginPage.checkDisplayUserName());
		assertTrue(loginPage.checkDisplayPassWord());
		assertTrue(loginPage.checkDisplayRememberMe());
		assertTrue(loginPage.checkDisplaySignIn());
	}

	@Test(dataProvider = "TC02")
	public void TC02_verifyLoginSuccess(String name,String password) throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
		loginPage.enterUserName(name);
		loginPage.enterPassWord(password);
		loginPage.clickSignIn();
		Thread.sleep(2000);
		homePage.checkDisplayleftMenu();
		Thread.sleep(2000);
		assertTrue(homePage.checkDisplayLastCustomer());
		assertTrue(homePage.checkDisplayLastOrders());
		assertTrue(homePage.checkDisplayLastProductTable());
		assertTrue(homePage.checkDisplaylastViewrTable());

	}
	@DataProvider(name="TC02")
	public static Object[][] setDataTC02(){
		return new Object[][] {{"super","admin"}};
	}
	

}
