package stepdefine;
import static org.testng.Assert.assertTrue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.CaNhanPage;
import page.HomePage;
import page.ThuongHieuPage;
import page.UuDaiPage;
import page.VoucherPage;

public class Steps {
	HomePage homepage=new HomePage();
	ThuongHieuPage thuongHieuPage=new ThuongHieuPage();
	UuDaiPage uuDaiPage=new UuDaiPage();
	VoucherPage voucherPage=new VoucherPage();
	CaNhanPage caNhanPage=new CaNhanPage();
	@Given("user at splash activity")
	public void user_at_splash_activity() {		
	}
	@When("Click to bắt đầu trải nghiệm")
	public void click_to_bắt_đầu_trải_nghiệm() throws InterruptedException {
		homepage.clickKeepVersion();
		homepage.clickBatDauTraiNghiem();
	}
	@When("Click to Deny")
	public void click_to_deny() throws InterruptedException {
		homepage.clickDeny();
	}
	// Shopiness_TC_01- scenario 01
	@Then("The Home screen should displayed")
	public void the_home_screen_should_displayed() throws InterruptedException {
		assertTrue(homepage.checkDisplayCartIcon());
		assertTrue(homepage.checkDisplaySearchIcon());
		assertTrue(homepage.checkDisplayBatDauNgay());
		assertTrue(homepage.checkDisplayHoanTien());
		assertTrue(homepage.checkDisplayThuongHieu());
		assertTrue(homepage.checkDisplayUuDai());
		assertTrue(homepage.checkDisplayVoucher());
		assertTrue(homepage.checkDisplayCaNhan());
	}
	// Shopiness_TC_02 - scenario 02
	@When("Click to Thương hiệu on footer menu")
	public void click_to_thương_hiệu_on_footer_menu() throws InterruptedException {
		thuongHieuPage.clickThuongHieu();
	}
	@Then("The screen should be displayed {int} branch name")
	public void the_screen_should_be_displayed_branch_name(Integer int1) throws InterruptedException {
		assertTrue(thuongHieuPage.checkElementDisplay());

	}
	// Shopiness_TC_03 - scenario 03
	@When("Click to Ưu đãi on footer menu")
	public void click_to_ưu_đãi_on_footer_menu() throws InterruptedException {
		uuDaiPage.clickUuDai();

	}
	@When("Click to the first item")
	public void click_to_the_first_item() throws InterruptedException {
		uuDaiPage.clickFirstItem();
	}

	@Then("The screen should be displayed with some item")
	public void the_screen_should_be_displayed_with_some_item() throws InterruptedException {
		assertTrue(uuDaiPage.verifyDisplayDiscountImage());
		assertTrue(uuDaiPage.verifyDisplayDescription());
		assertTrue(uuDaiPage.verifyDisplayButtonMuaNhan());
	}
	// Shopiness_TC_04 - scenario 04
	@When("Click to Voucher on footer menu")
	public void click_to_voucher_on_footer_menu() throws InterruptedException {
		voucherPage.clickVoucher();

	}
	@When("Swipe and click to the last Voucher")
	public void swipe_and_click_to_the_last_voucher() throws InterruptedException {
		voucherPage.scrolll();
		voucherPage.clickLastItem();

	}
	@Then("Screen should be displayed with some item")
	public void screen_should_be_displayed_with_some_item() throws InterruptedException {
		assertTrue(voucherPage.verifyDisplayImageVoucher());
		assertTrue(voucherPage.verifyDisplayNameVoucher());
		assertTrue(voucherPage.verifyDisplayDescriptionVoucher());
		assertTrue(voucherPage.verifyDisplayButtonMuaNgay());
		assertTrue(voucherPage.verifyDisplayAddCart());
	}
	// Shopiness_TC_05 - scenario 05
	@When("Click to Cá nhân on footer menu")
	public void click_to_cá_nhân_on_footer_menu() throws InterruptedException {
		caNhanPage.clickCaNhan();

	}
	@Then("The screen should be displayed with {int} tabs: Mã ưu đãi, Ưu đãi, Voucher and Thương hiệu.")
	public void the_screen_should_be_displayed_with_tabs_mã_ưu_đãi_ưu_đãi_voucher_and_thương_hiệu(Integer int1) throws InterruptedException {
		assertTrue(caNhanPage.verifyDisplayMaUuDai());
		assertTrue(caNhanPage.verifyDisplayUuDai());
		assertTrue(caNhanPage.verifyDisplayVoucher());
		assertTrue(caNhanPage.verifyDisplayThuongHieu());
	}
}
