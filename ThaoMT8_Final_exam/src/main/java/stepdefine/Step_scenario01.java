package stepdefine;

import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.HomePage;
import page.CategoryPage;

public class Step_scenario01 {
	HomePage homepage=new HomePage();
	CategoryPage categoryPage=new CategoryPage();
	@Given("user opened Banggood Easy Online Shopping App")
	public void user_opened_banggood_easy_online_shopping_app() {
	}
	// scenario 01

	@When("Click to the Category on footer menu")
	public void click_to_the_category_on_footer_menu() throws InterruptedException {
		homepage.clickCategory();
	}

	@When("Scroll and click to “Home and Garden” in Left menu")
	public void scroll_and_click_to_home_and_garden_in_left_menu() throws InterruptedException {
		categoryPage.scrollandClickHomeGardenAndClick();
	}

	@Then("the right category displayed")
	public void the_right_category_displayed() throws InterruptedException {
		assertTrue(categoryPage.verifyDisplayRight());
	}

	@When("click to the “Home Decor”")
	public void click_to_the_home_decor() throws InterruptedException {
		categoryPage.clickHomeDecor();
	 
	}
	@When("Click to the Filter and input price from {int} to {int}")
	public void click_to_the_filter_and_input_price_from_to(Integer int1, Integer int2) throws InterruptedException {
		categoryPage.clickFilter();
		categoryPage.inputPrice();

	}

	@When("Click Done")
	public void click_done() throws InterruptedException {
		categoryPage.clickBtnDone();
	}

	@When("Click first product")
	public void click_first_product() throws InterruptedException {
		categoryPage.clickFirstProduct();

	}
	@Then("product name should be displayed and product price in range {int} to {int}")
	public void product_name_should_be_displayed_and_product_price_in_range_to(Integer int1, Integer int2) throws InterruptedException {
		assertTrue(categoryPage.verifyDisplayName());
		assertTrue(categoryPage.verifyDisplayPrice());

	}
	
}
