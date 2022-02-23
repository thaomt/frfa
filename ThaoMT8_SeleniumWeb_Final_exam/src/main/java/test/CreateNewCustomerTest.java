package test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import core.BaseTest;
import core.ExcelUtils;
import page.CreateProductsPage;
import page.HomePage;
import page.LoginPage;
import page.ProductsPage;

public class CreateNewCustomerTest extends BaseTest {
	@Test(dataProvider = "TC")
	public void TC02(Object name,Object descript,Object sku,Object price,Object oldprice, Object message) throws InterruptedException {
		String valueName=name.toString();
		String shortDescript=descript.toString();
		String skus=sku.toString();
		String prices=price.toString();
		String pricess=oldprice.toString();
		String mes=message.toString();
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
		//1. click login
		loginPage.inputEmail("admin@yourstore.com");
		loginPage.inputPassWord("admin");
		loginPage.clickLogin();
		Thread.sleep(2000);
		// checkDislayLeftMenu
		homePage.checkDisplayleftMenu();
		Thread.sleep(2000);
		ProductsPage productsPage=new ProductsPage(driver);
		//2. click 
		// click catalog
		productsPage.clickCatalog();
		// click categories
		productsPage.clickProducts();
		// check display
		assertTrue(productsPage.checkDisplayAddNew());
		assertTrue(productsPage.checkDisplayExport());
		assertTrue(productsPage.checkDisplayImport());
		assertTrue(productsPage.checkDisplayDelete());
		assertTrue(productsPage.checkDisplayProductName());
		assertTrue(productsPage.checkDisplayCategory());
		assertTrue(productsPage.checkDisplayProductType());
		assertTrue(productsPage.checkDisplayWareHouse());
		CreateProductsPage createProductsPage=new CreateProductsPage(driver);
		// 3. click add new
		createProductsPage.clickAddNew();
		// 4. input
		//createProductsPage.clickProductInfo();
		// input categories name
		createProductsPage.inputProductName(valueName);
		//input Short description
		Thread.sleep(1000);
		createProductsPage.inputShortDescription(shortDescript);
		//input SKU
		createProductsPage.inputSku(skus);
		//createProductsPage.clickPrices();
		// input Price
//		Thread.sleep(2000);
//		createProductsPage.inputPrice(prices);
		// input Old price
//		createProductsPage.inputOldPrice(pricess);
		//5. click save
		createProductsPage.clickSave();
		Thread.sleep(2000);
		// verify message
		assertEquals(createProductsPage.message(),mes);
		// 6. Click log out 
		createProductsPage.clickLogOut();

	}
	@DataProvider(name = "TC")
    public Object[][] getDataFromExcel() throws Exception {
	 Object[][] testObjArray = ExcelUtils.getValue(System.getProperty("user.dir") +"\\src\\main\\java\\data\\Datas.xlsx","Sheet1");
		return (testObjArray);
	 
 }


}
