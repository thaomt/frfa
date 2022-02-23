package test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import core.BaseTest;
import core.ExcelUtils;
import page.LoginPage;
import page.ProductsCreatePage;
import page.ProductsPage;

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
		Thread.sleep(3000);
		productsPage.navigateProducts();
		assertTrue(productsPage.checkDisplayCreat());
		assertTrue(productsPage.checkDisplaySetting());
		assertTrue(productsPage.checkDisplayBulkEdit());
		assertTrue(productsPage.checkDisplayBulkDelete());
		assertTrue(productsPage.checkDisplayManageProductTable());
	}
	@Test(dataProvider = "TC06to07")
	public void TC06_07(Object name,Object alias,Object image, Object SKU,Object price, Object quantity,Object categories,Object message) throws InterruptedException{
		String valueAlias=alias.toString();
		String valueSKU=SKU.toString();
		String valuePrices=price.toString();
		String valueQuantity=quantity.toString();
		String valueCategories=categories.toString();
		String valueMessage=message.toString();
		String valueName=name.toString();
		String valueImage=image.toString();
		set();
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
	@DataProvider(name = "TC06to07")
    public Object[][] getDataFromExcel() throws Exception {
	 Object[][] testObjArray = ExcelUtils.getValue06_07(System.getProperty("user.dir") +"\\src\\main\\java\\data\\Datas.xlsx","Sheet2");
		return (testObjArray);
	 
 }

}
