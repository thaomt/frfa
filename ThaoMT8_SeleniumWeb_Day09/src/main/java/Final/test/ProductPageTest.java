package Final.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Final.core.BaseTest;
import Final.core.ExcelUtilsForProduct;
import Final.page.LoginPage;
import Final.page.ProductsCreatePage;
import Final.page.ProductsPage;
public class ProductPageTest extends BaseTest{
	public void set() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName("super");
		loginPage.enterPassWord("admin");
		loginPage.clickSignIn();
	}
	@Test
	public void TC05_verifyProductsPage() throws InterruptedException {
		set();
		ProductsPage productsPage=new ProductsPage(driver);
		Thread.sleep(3000);
		productsPage.navigateCatalog();
		Thread.sleep(2000);
		productsPage.navigateProducts();
		assertTrue(productsPage.checkDisplayCreat());
		assertTrue(productsPage.checkDisplaySetting());
		assertTrue(productsPage.checkDisplayBulkEdit());
		assertTrue(productsPage.checkDisplayBulkDelete());
		assertTrue(productsPage.checkDisplayManageProductTable());
	}
	@Test(dataProvider = "testData06")
	public void TC06_verifyNameRequiredFieldProductsPage(Object alias, Object SKU,Object price, Object quantity,Object categories,Object image,Object message) throws InterruptedException {
		String valueAlias=alias.toString();
		String valueSKU=SKU.toString();
		String valuePrices=price.toString();
		String valueQuantity=quantity.toString();
		String valueCategories=categories.toString();
		String valueMessage=message.toString();
		String valueImage=image.toString();
		set();
		ProductsPage productsPage=new ProductsPage(driver);
		Thread.sleep(3000);
		productsPage.navigateCatalog();
		Thread.sleep(3000);
		productsPage.navigateProducts();
		productsPage.clickCreatButton();
		ProductsCreatePage productsCreatePage=new ProductsCreatePage(driver);
		productsCreatePage.inputAlias(valueAlias);
		productsCreatePage.uploadImage(valueImage);
		productsCreatePage.clickSpecifications();
		productsCreatePage.inputSKU(valueSKU);
		productsCreatePage.inputPrice(valuePrices);
		productsCreatePage.inputQuantity(valueQuantity);
		productsCreatePage.inputCategories(valueCategories);
		productsCreatePage.clickSaveNotifiName();
		Thread.sleep(3000);
		assertEquals(productsCreatePage.notifyName(), valueMessage);
	}
	@DataProvider(name = "testData06")
    public Object[][] getDataFromExcel06() throws Exception {
		Object[][] testObjArray = ExcelUtilsForProduct.getValue06(System.getProperty("user.dir") +"\\src\\main\\java\\data\\Data.xlsx","Sheet2");
		return (testObjArray);	 
 }
	@Test(dataProvider = "testData07")
	public void TC07_verifyImageRequiredFieldProductsPage(Object name, Object SKU,Object price, Object quantity,Object categories,Object message) throws InterruptedException {
		String valueName=name.toString();
		String valueSKU=SKU.toString();
		String valuePrices=price.toString();
		String valueQuantity=quantity.toString();
		String valueCategories=categories.toString();
		String valueMessage=message.toString();
		set();
		ProductsPage productsPage=new ProductsPage(driver);
		Thread.sleep(3000);
		productsPage.navigateCatalog();
		Thread.sleep(3000);
		productsPage.navigateProducts();
		productsPage.clickCreatButton();
		ProductsCreatePage productsCreatePage=new ProductsCreatePage(driver);
		productsCreatePage.inputName(valueName);
		productsCreatePage.clickSpecifications();
		productsCreatePage.inputSKU(valueSKU);
		productsCreatePage.inputPrice(valuePrices);
		productsCreatePage.inputQuantity(valueQuantity);
		productsCreatePage.inputCategories(valueCategories);
		productsCreatePage.clickSaveNotifiImage();
		Thread.sleep(3000);
		assertEquals(productsCreatePage.notifyImage(), valueMessage);
	}
	@DataProvider(name = "testData07")
    public Object[][] getDataFromExcel07() throws Exception {
	 Object[][] testObjArray = ExcelUtilsForProduct.getValue07(System.getProperty("user.dir") +"\\src\\main\\java\\data\\Data.xlsx","Sheet2");
		return (testObjArray);
	 
 }
	 

}
