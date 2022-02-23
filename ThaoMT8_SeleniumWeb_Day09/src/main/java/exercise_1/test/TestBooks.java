package exercise_1.test;


import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import exercise_1.core.BaseTest;
import exercise_1.core.ExelUtils;
import exercise_1.page.HomePage;
import exercise_1.page.SeleniumPage;

public class TestBooks extends BaseTest{
	@Test(dataProvider = "testData")
	public void test(Object item, Object expectTitle) {
		String valueItem=item.toString();
		String valueTitileExpect=expectTitle.toString();
		HomePage homePage= new HomePage(driver);
		SeleniumPage seleniumPage=new SeleniumPage(driver);
		//4.Select “Books” from search category drop down
		homePage.selectBooks("Books");
		//5.Enter search key
		homePage.sendValueSearch(valueItem);
		//6.Click “Go” button
		homePage.clickGo();
		//7.Click the first search result item title
		seleniumPage.clikFirtItem();
		//8.Verify product title
		assertEquals(seleniumPage.getTititle(), valueTitileExpect," Books found not match title");
	}
	 @DataProvider(name = "testData")
	    public Object[][] getDataFromExcel() throws Exception {
		 Object[][] testObjArray = ExelUtils.getValue(System.getProperty("user.dir") + "\\src\\main\\java\\exercise_1\\data\\Book.xlsx");
			return (testObjArray);
		 
	 }

}
