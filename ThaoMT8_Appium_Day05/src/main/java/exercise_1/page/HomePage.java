package exercise_1.page;

import exercise_1.core.AppiumBase;
public class HomePage extends AppiumBase{
	String danhmuc="vn.tiki.app.tikiandroid:id/navCategories";
	public void clickDanhmuc() throws InterruptedException{
		Thread.sleep(3000);
		getDriver().findElementById(danhmuc).click();
	}
}
