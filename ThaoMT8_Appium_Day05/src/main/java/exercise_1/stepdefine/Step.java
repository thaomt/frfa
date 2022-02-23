package exercise_1.stepdefine;

import static org.testng.Assert.assertTrue;

import exercise_1.page.HangMoiPage;
import exercise_1.page.HomePage;
import exercise_1.page.LaptopPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step {
	HomePage homepage = new HomePage();
	LaptopPage laptopPage = new LaptopPage();
	HangMoiPage hangMoiPage = new HangMoiPage();

	@Given("user at homepage TIKI App")
	public void user_at_homepage_tiki_app() {
	}

	@When("on menu bar click Danh Muc San Pham")
	public void on_menu_bar_click_danh_muc_san_pham() throws InterruptedException {
		homepage.clickDanhmuc();

	}

	@When("Click Laptop – May Vi Tinh")
	public void click_laptop_may_vi_tinh() throws InterruptedException {
		laptopPage.clickLaptop();
	}

	@When("Scroll and click to “Hàng mới”")
	public void scroll_and_click_to_hàng_mới() throws InterruptedException {
		laptopPage.clickAccept();
		laptopPage.clickHangMoi();

	}

	@When("Click first the product")
	public void click_first_the_product() throws InterruptedException {
		hangMoiPage.clickFirstProduct();
	}

	@Then("the product name, product price display")
	public void the_product_name_product_price_display() throws InterruptedException {
		assertTrue(hangMoiPage.checkDisplayNameProduct());
		assertTrue(hangMoiPage.checkDisplayPriceProduct());

	}

}
