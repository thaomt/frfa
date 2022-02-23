package test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import core.BaseTest;
import core.ExcelUtils;
import page.LoginPage;
import page.ProductCategoriesCreatePage;
import page.ProductCategoriesPage;

public class ProductCategoriesTest extends BaseTest{
	public void set() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName("super");
		loginPage.enterPassWord("admin");
		loginPage.clickSignIn();
	}
	@Test
	public void TC03_1() throws InterruptedException {
		set();
		ProductCategoriesPage productCategoriesPage=new ProductCategoriesPage(driver);
		Thread.sleep(3000);
		productCategoriesPage.navigateToCatalog();
		Thread.sleep(3000);
		productCategoriesPage.navigateToProductCategories();
		assertTrue(productCategoriesPage.checkDisplayCreat());
		assertTrue(productCategoriesPage.checkDisplaySetting());
		assertTrue(productCategoriesPage.checkDisplayBulkEdit());
		assertTrue(productCategoriesPage.checkDisplayBulkDelete());
		assertTrue(productCategoriesPage.checkDisplayManageProductCategoriesTable());
	}
	@Test(dataProvider = "TC03_2to04")
	public void TC03_2toTC04(Object name,Object alias,Object image,Object code,Object message) throws InterruptedException{
		String valueAlias=alias.toString();
		String valueCode=code.toString();
		String valueMessage=message.toString();
		String valueName=name.toString();
		String valueImage=image.toString();
		set();
		ProductCategoriesPage productCategoriesPage=new ProductCategoriesPage(driver);
		Thread.sleep(3000);
		productCategoriesPage.navigateToCatalog();
		Thread.sleep(3000);
		productCategoriesPage.navigateToProductCategories();
		ProductCategoriesCreatePage productCategoriesCreatePage=new ProductCategoriesCreatePage(driver);
		productCategoriesPage.clickCreatButton();
		productCategoriesCreatePage.inputName(valueName);
		productCategoriesCreatePage.inputAlias(valueAlias);
		productCategoriesCreatePage.inputCode(valueCode);
		if(name.equals("")) {
			productCategoriesCreatePage.uploadImage(valueImage);
			productCategoriesCreatePage.clickSave();
			Thread.sleep(3000);
			assertEquals(productCategoriesCreatePage.notifyName(), valueMessage);
		}
		if(image.equals("")) {
			productCategoriesCreatePage.clickSave();
			Thread.sleep(3000);
			assertEquals(productCategoriesCreatePage.notifyImage(), valueMessage);
		}
		if(code.equals("")) {
			productCategoriesCreatePage.uploadImage(valueImage);
			productCategoriesCreatePage.clickSave();
			Thread.sleep(3000);
			assertEquals(productCategoriesCreatePage.notifyCode(),valueMessage);
		}				
	}
	@DataProvider(name = "TC03_2to04")
    public Object[][] getDataFromExcel() throws Exception {
	 Object[][] testObjArray = ExcelUtils.getValue03_04(System.getProperty("user.dir") +"\\src\\main\\java\\data\\Datas.xlsx","Sheet1");
		return (testObjArray);
	 
 }

}
