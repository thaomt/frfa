package stepdefine;

import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.AccountPage;
import page.HomePage;

public class Step_scenario03 {
	HomePage homepage=new HomePage();
	AccountPage accountPage=new AccountPage();

	// scenario 03
	@When("Click Account on footer menu")
	public void click_account_on_footer_menu() throws InterruptedException {
		homepage.clickAccount();	  
	}

	@When("Click View All Order")
	public void click_view_all_order() throws InterruptedException {
		accountPage.clickViewAllOrder();	 
	}

	@Then("the login screen should be displayed with: Email, password and Sign In button.")
	public void the_login_screen_should_be_displayed_with_email_password_and_sign_in_button() throws InterruptedException {
		assertTrue(accountPage.verifyDisplayEmail());
		assertTrue(accountPage.verifyDisplayPassword());
		assertTrue(accountPage.verifyDisplayBtnSignIn());
	 
	}


}
