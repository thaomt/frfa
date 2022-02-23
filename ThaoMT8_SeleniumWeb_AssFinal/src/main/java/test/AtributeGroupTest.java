package test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import core.BaseTest;
import page.AttributeGroupPage;
import page.LoginPage;

public class AtributeGroupTest extends BaseTest{
	public void set() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName("super");
		loginPage.enterPassWord("admin");
		loginPage.clickSignIn();
	}
	@Test
	public void TC08_verifyAttributeGroupPage() throws InterruptedException {
		set();
		AttributeGroupPage attributeGroupPage=new AttributeGroupPage(driver);
		Thread.sleep(3000);
		attributeGroupPage.navigateCatalog();
		Thread.sleep(3000);
		attributeGroupPage.navigateAttributeGroup();
		attributeGroupPage.clickCreatButton();
		assertTrue(attributeGroupPage.verifyDisplayAttributeGroupName());
		assertTrue(attributeGroupPage.verifyDisplaySortOrder());
	}
	@Test(dataProvider = "TC09")
	public void TC09_verifyCreateNewAttributeGroup(String attributeGroupName,String attributeGroupNameInTable) throws InterruptedException {
		set();
		AttributeGroupPage attributeGroupPage=new AttributeGroupPage(driver);
		Thread.sleep(3000);
		attributeGroupPage.navigateCatalog();
		Thread.sleep(3000);
		attributeGroupPage.navigateAttributeGroup();
		attributeGroupPage.clickCreatButton();
		attributeGroupPage.inputAttributeGroupName(attributeGroupName);
		attributeGroupPage.clickSave();
		Thread.sleep(3000);
		if(attributeGroupPage.checkTitle()) {
			Thread.sleep(3000);
			attributeGroupPage.clickBack();
		}
		Thread.sleep(3000);
		assertTrue(attributeGroupPage.checkVerify(attributeGroupNameInTable));
	}
	@DataProvider(name="TC09")
	public static Object[][] setDataTC09(){
		return new Object[][] {{"test","test"}};
	}
	

}
