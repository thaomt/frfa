package exercise_2.stepdefine;

import static org.testng.Assert.assertTrue;

import exercise_2.page.DienThoaiPage;
import exercise_2.page.HomePage;
import exercise_2.page.XemSanPhamPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step{
	HomePage homepage=new HomePage();
	DienThoaiPage dienThoaiPage=new DienThoaiPage();
	XemSanPhamPage xemSanPhamPage=new XemSanPhamPage();
	@Given("user at homepage App")
	public void user_at_homepage_app() {
	}

	@When("On menu bar click on Danh Muc San Pham")
	public void on_menu_bar_click_on_danh_muc_san_pham() throws InterruptedException {
		homepage.clickDanhmuc();
	}

	@When("Click “Điện thoại – Máy tính bảng”")
	public void click_điện_thoại_máy_tính_bảng() throws InterruptedException {
		dienThoaiPage.clickDienThoai();
	}

	@When("Scroll to “Bộ lọc Phổ Biến” and click “Thương Hiệu”")
	public void scroll_to_bộ_lọc_phổ_biến_and_click_thương_hiệu() throws InterruptedException {
		dienThoaiPage.clickAccept();
		dienThoaiPage.scrollPhoBien();
		dienThoaiPage.clickThuongHieu();

	}

	@Then("button “Xem +++ Sản Phẩm” should be displayed")
	public void button_xem_sản_phẩm_should_be_displayed() {
		dienThoaiPage.scrolluButton();
		assertTrue(dienThoaiPage.checkDisplaySanPham());
	
	}

	@When("Click “Xem +++ sản phẩm”")
	public void click_xem_sản_phẩm() throws InterruptedException {
		dienThoaiPage.clickButtonXemSanPham();

	}
	@When("Click the first product")
	public void click__the_first_product() throws InterruptedException {
		xemSanPhamPage.clickFirstProduct();
	}

	@Then("the product name, product price should be displayed")
	public void the_product_name_product_price_should_be_displayed() throws InterruptedException {
		assertTrue(xemSanPhamPage.checkDisplayNameProduct());
		assertTrue(xemSanPhamPage.checkDisplayPriceProduct());

	}
	
}
