package Final.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Final.core.BaseTest;
import Final.page.AttributePage;
import Final.page.LoginPage;
public class AtributePageTest extends BaseTest{
	public void set() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName("super");
		loginPage.enterPassWord("admin");
		loginPage.clickSignIn();
	}
	@Test(dataProvider = "TC10")
	public void TC10_verifyNewCreateAttribute(String attributeName,String attributeGroup) throws InterruptedException {
		set();
		AttributePage attributePage=new AttributePage(driver);
		Thread.sleep(3000);
		attributePage.navigateCatalog();
		Thread.sleep(2000);
		attributePage.navigateAttribute();
		attributePage.clickCreatButton();
		attributePage.inputAttributeName(attributeName);
		attributePage.selectAttributeGroup(attributeGroup);
		attributePage.clickSave();
		Thread.sleep(2000);
		if(attributePage.checkTitle()) {
			Thread.sleep(2000);
			attributePage.clickBack();
		}
		Thread.sleep(2000);
		assertTrue(attributePage.checkVerify(attributeName,attributeGroup));		
	}
	@DataProvider(name="TC10")
	public static Object[][] setDataTC10(){
		return new Object[][] {{"test","Memory"}};
	}

}
