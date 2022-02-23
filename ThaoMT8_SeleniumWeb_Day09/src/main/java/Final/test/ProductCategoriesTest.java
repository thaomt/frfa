package Final.test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Final.core.BaseTest;
import Final.core.ExcelUtilsForProductCategories;
import Final.page.LoginPage;
import Final.page.ProductCategoriesCreatePage;
import Final.page.ProductCategoriesPage;

public class ProductCategoriesTest extends BaseTest{
	public void set() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName("super");
		loginPage.enterPassWord("admin");
		loginPage.clickSignIn();
	}
	@Test
	public void TC03_1_verifyProductCategoriesPage() throws InterruptedException {
		set();
		ProductCategoriesPage productCategoriesPage=new ProductCategoriesPage(driver);
		Thread.sleep(2000);
		productCategoriesPage.navigateToCatalog();
		Thread.sleep(2000);
		productCategoriesPage.navigateToProductCategories();
		assertTrue(productCategoriesPage.checkDisplayCreat());
		assertTrue(productCategoriesPage.checkDisplaySetting());
		assertTrue(productCategoriesPage.checkDisplayBulkEdit());
		assertTrue(productCategoriesPage.checkDisplayBulkDelete());
		assertTrue(productCategoriesPage.checkDisplayManageProductCategoriesTable());
	}
	@Test(dataProvider = "testData03_2")
	public void TC03_2_verifyNameRequiredField(Object alias,Object code, Object image, Object message) throws InterruptedException {
		String valueAlias=alias.toString();
		String valueCode=code.toString();
		String valueImage=image.toString();
		String valueMessage=message.toString();
		set();
		ProductCategoriesPage productCategoriesPage=new ProductCategoriesPage(driver);
		Thread.sleep(2000);
		productCategoriesPage.navigateToCatalog();
		Thread.sleep(2000);
		productCategoriesPage.navigateToProductCategories();
		ProductCategoriesCreatePage productCategoriesCreatePage=new ProductCategoriesCreatePage(driver);
		productCategoriesPage.clickCreatButton();
		productCategoriesCreatePage.inputAlias(valueAlias);
		productCategoriesCreatePage.uploadImage(valueImage);
		productCategoriesCreatePage.inputCode(valueCode);
		productCategoriesCreatePage.clickSave();
		Thread.sleep(2000);
		assertEquals(productCategoriesCreatePage.notifyName(), valueMessage);
	}
	@DataProvider(name = "testData03_2")
    public Object[][] getDataFromExcel03_2() throws Exception {
	 Object[][] testObjArray = ExcelUtilsForProductCategories.getValueForTest03_2(System.getProperty("user.dir") +"\\src\\main\\java\\data\\Data.xlsx","Sheet1");
		return (testObjArray);
	}
	@Test(dataProvider = "testData03_3")
	public void TC03_3_Verify_ImageRequiredField(Object name, Object alias,Object code, Object message) throws InterruptedException {
		String valueName=name.toString();
		String valueCode=code.toString();
		String valueMessage=message.toString();
		set();
		ProductCategoriesPage productCategoriesPage=new ProductCategoriesPage(driver);
		Thread.sleep(2000);
		productCategoriesPage.navigateToCatalog();
		Thread.sleep(2000);
		productCategoriesPage.navigateToProductCategories();
		ProductCategoriesCreatePage productCategoriesCreatePage=new ProductCategoriesCreatePage(driver);
		productCategoriesPage.clickCreatButton();
		productCategoriesCreatePage.inputName(valueName);
		productCategoriesCreatePage.inputCode(valueCode);
		productCategoriesCreatePage.clickSave();
		Thread.sleep(2000);
		assertEquals(productCategoriesCreatePage.notifyImage(), valueMessage);
	}
	@DataProvider(name = "testData03_3")
    public Object[][] getDataFromExcel03_3() throws Exception {
		Object[][] testObjArray = ExcelUtilsForProductCategories.getValueForTest03_3(System.getProperty("user.dir") +"\\src\\main\\java\\data\\Data.xlsx","Sheet1");
		return (testObjArray);
	}
	@Test(dataProvider = "testData04")
	public void TC04_Verify_CodeRequiredField(Object name, Object alias,Object image, Object message) throws InterruptedException {
		String valueName=name.toString();
		String valueImage=image.toString();
		String valueMessage=message.toString();
		set();
		ProductCategoriesPage productCategoriesPage=new ProductCategoriesPage(driver);
		Thread.sleep(2000);
		productCategoriesPage.navigateToCatalog();
		Thread.sleep(2000);
		productCategoriesPage.navigateToProductCategories();
		ProductCategoriesCreatePage productCategoriesCreatePage=new ProductCategoriesCreatePage(driver);
		productCategoriesPage.clickCreatButton();
		productCategoriesCreatePage.inputName(valueName);
		productCategoriesCreatePage.uploadImage(valueImage);
		productCategoriesCreatePage.clickSave();
		Thread.sleep(2000);
		assertEquals(productCategoriesCreatePage.notifyCode(),valueMessage);
	}
	@DataProvider(name = "testData04")
    public Object[][] getDataFromExcel04() throws Exception {
		Object[][] testObjArray = ExcelUtilsForProductCategories.getValueForTest04(System.getProperty("user.dir") +"\\src\\main\\java\\data\\Data.xlsx","Sheet1");
		return (testObjArray);	
	}

}
