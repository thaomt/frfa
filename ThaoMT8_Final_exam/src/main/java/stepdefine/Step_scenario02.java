package stepdefine;

import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.HomePage;
import page.HotCategoriesPage;

public class Step_scenario02 {
	HomePage homePage = new HomePage();
	HotCategoriesPage hotCategoriesPage=new HotCategoriesPage();

	// scenario 02
	@When("scroll to “Hot Categories”")
	public void scroll_to_hot_categories() throws InterruptedException {
		homePage.scrollHotCategories();
	}

	@When("Click to the first category")
	public void click_to_the_first_category() throws InterruptedException {
		homePage.clickFirstCategories();
	}

	@When("Click to the first product")
	public void click_to_the_first_product() throws InterruptedException {
		hotCategoriesPage.clickFirstProduct();

	}

	@Then("The product detail page should be displayed : Product name, product price, Buy now button and Add to Cart button.")
	public void the_product_detail_page_should_be_displayed_product_name_product_price_buy_now_button_and_add_to_cart_button() throws InterruptedException {
		assertTrue(hotCategoriesPage.verifyDisplayName());
		assertTrue(hotCategoriesPage.verifyDisplayPrice());
		assertTrue(hotCategoriesPage.verifybtnBuyNow());
		assertTrue(hotCategoriesPage.verifyDisplaybtnAdd());

	}

	@When("Click “Add to Cart”")
	public void click_add_to_cart() throws InterruptedException {
		hotCategoriesPage.clickAddToCart();
	}

	@When("Click to “Add to Cart” button")
	public void click_to_add_to_cart_button() throws InterruptedException {
		hotCategoriesPage.clickAddToCartButton();

	}

	@When("Click to Cart icon on footer")
	public void click_to_cart_icon_on_footer() throws InterruptedException {
		hotCategoriesPage.clickCartIcon();

	}

	@Then("product name, product size, product price and quantity should be dislayed")
	public void product_name_product_size_product_price_and_quantity_should_be_dislayed() throws InterruptedException {
		assertTrue(hotCategoriesPage.verifyDisplayName());
		assertTrue(hotCategoriesPage.verifyDisplayPrice());
		assertTrue(hotCategoriesPage.verifyDisplayQuantity());

	}

}
