package exercise_2.page;

import exercise_2.core.AppiumBases;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class DienThoaiPage extends AppiumBases {
	String dienthoai = "vn.tiki.app.tikiandroid.category2:id/tvName";
	String alert = "com.android.permissioncontroller:id/permission_allow_foreground_only_button";
	String thuonghieu = "vn.tiki.app.tikiandroid.productList2:id/title";
	String sanpham = "vn.tiki.app.tikiandroid:id/button";
	public MobileElement scrollSp(String text ) {
		return (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
						+ ".scrollIntoView(new UiSelector().text(\""+text+"\"))"));
	}

	public void clickDienThoai() throws InterruptedException {
		Thread.sleep(2000);
		getDriver().findElementsById(dienthoai).get(2).click();
	}

	public void clickAccept() throws InterruptedException {
		Thread.sleep(2000);
		getDriver().findElementById(alert).click();
	}

	public void scrollPhoBien(){
		MobileElement element1 = scrollSp("Bộ Lọc Phổ Biến");	
	}

	public void clickThuongHieu() throws InterruptedException {
		Thread.sleep(4000);
		getDriver().findElementsById(thuonghieu).get(1).click();
	}
	public void scrolluButton(){
		MobileElement element2 = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
		        "new UiScrollable(new UiSelector().scrollable(true))" +
		         ".scrollIntoView(new UiSelector().resourceIdMatches(\".*vn.tiki.app.tikiandroid:id/button.*\"))"));	
	}

	public boolean checkDisplaySanPham() {
		if(getDriver().findElementsById(sanpham).get(0).isDisplayed()) {
			return true;
		}
		return false;
	}

	public void clickButtonXemSanPham() throws InterruptedException {
		Thread.sleep(4000);
		getDriver().findElementsById(sanpham).get(0).click();
	}

}
