package exercise_1.page;

import exercise_1.core.AppiumBase;
public class LaptopPage extends AppiumBase{
	String laptop="vn.tiki.app.tikiandroid.category2:id/tvName";
	String alert="com.android.permissioncontroller:id/permission_allow_foreground_only_button";
	String hangmoi="android.widget.TextView";
	public void clickLaptop() throws InterruptedException {
		Thread.sleep(2000);
		getDriver().findElementsById(laptop).get(14).click();
	}
	public void clickAccept() throws InterruptedException {
		Thread.sleep(2000);
		getDriver().findElementById(alert).click();
	}
	public void clickHangMoi() throws InterruptedException {
		Thread.sleep(2000);
		getDriver().findElementsByClassName(hangmoi).get(8).click();
	}
	

}
