package test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import core.BaseTest;
import page.CategoriesPage;
import page.CreateCategoriesPage;
import page.HomePage;
import page.LoginPage;

public class CreateNewCategoryTest extends BaseTest {
	@Test(dataProvider = "test")
	public void TC01(String email,String password, String name, String message) throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
		//1. click login
		loginPage.inputEmail(email);
		loginPage.inputPassWord(password);
		loginPage.clickLogin();
		Thread.sleep(2000);
		// checkDislayLeftMenu
		homePage.checkDisplayleftMenu();
		Thread.sleep(2000);
		CategoriesPage categoriesPage=new CategoriesPage(driver);
		// 2. click		
		// click catalog
		Thread.sleep(2000);
		categoriesPage.clickCatalog();
		// click categories
		Thread.sleep(2000);
		categoriesPage.clickCategories();
		// check display
		assertTrue(categoriesPage.checkDisplayAddNew());
		assertTrue(categoriesPage.checkDisplayExport());
		assertTrue(categoriesPage.checkDisplayImport());
		assertTrue(categoriesPage.checkDisplayDelete());
		assertTrue(categoriesPage.checkDisplayCategoriesName());
		assertTrue(categoriesPage.checkDisplayPublished());
		CreateCategoriesPage createCategoriesPage=new CreateCategoriesPage(driver);
		//3. click add new
		createCategoriesPage.clickAddNew();
		//4/ input categories name
		createCategoriesPage.inputCategoriesName(name);
		//5. click save
		createCategoriesPage.clickSave();
		Thread.sleep(2000);
		// verify message
		System.out.println(createCategoriesPage.message());
		assertEquals(createCategoriesPage.message(),message);
		//6.Click Log out 
		createCategoriesPage.clickLogOut();

	}
	@DataProvider(name="test")
	public static Object[][] setDataTC02(){
		return new Object[][] {{"admin@yourstore.com","admin","thao","The new category has been added successfully."}};
	}

}
