package exercise_2.test;


import static org.testng.Assert.assertEquals;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import exercise_2.core.BaseTest;
import exercise_2.core.ExelUtils;
import exercise_2.page.CartPage;
import exercise_2.page.FirstProductPage;
import exercise_2.page.HomePage;
import exercise_2.page.SearchStorePage;

public class TestSearch extends BaseTest{
	@Test(dataProvider = "testData")
	public void test(Object product, Object price) throws InterruptedException {
		String titleProductExpect=product.toString();
		String priceProductExpect=price.toString(); 
		String displayNotifyExpect="Product successfully added to your shopping cart";
		HomePage homePage= new HomePage(driver);
		FirstProductPage firstProductPage=new FirstProductPage(driver);
		SearchStorePage searchStorePage=new SearchStorePage(driver);
		CartPage cartPage=new CartPage(driver);
		//4.Enter search key
		homePage.sendValueSearch(titleProductExpect);
		//5.Click “Search” button
		homePage.clickSearch();	
		//6.Click the first search result item title
		searchStorePage.clikFirtItem();	
		//7.Verify product price
		assertEquals(firstProductPage.getPrice(), "$"+priceProductExpect,"Not match price product");
		String nameProductFind=firstProductPage.getTitle();
		//8.Verify product title 
		assertEquals(nameProductFind,titleProductExpect,"Not match title product name");
		//9.Click Add to cart button
		Thread.sleep(2000);
		firstProductPage.clickAdd();
		Thread.sleep(2000);
		//10.Verify confirmation test appears
		assertEquals(firstProductPage.notifyDisplay(), displayNotifyExpect);
		//11.Navigate to Cart page from main menu
		cartPage.navigateCart();
		//12.Verify item is displayed on Shopping Cart list
		assertEquals(cartPage.getCheck(),nameProductFind,"Not exist on Cart");
		
	}
	@DataProvider(name = "testData")
    public Object[][] getDataFromExcel() throws Exception {
	 Object[][] testObjArray = ExelUtils.getValue(System.getProperty("user.dir") +"\\src\\main\\java\\exercise_2\\data\\Product.xlsx");
		return (testObjArray);
	 
 }
	 

}
