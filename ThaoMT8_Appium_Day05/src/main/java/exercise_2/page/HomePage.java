package exercise_2.page;

import exercise_2.core.AppiumBases;

public class HomePage extends AppiumBases{
	String danhmuc="vn.tiki.app.tikiandroid:id/navCategories";
	public void clickDanhmuc() throws InterruptedException{
		Thread.sleep(3000);
		getDriver().findElementById(danhmuc).click();
	}
}
