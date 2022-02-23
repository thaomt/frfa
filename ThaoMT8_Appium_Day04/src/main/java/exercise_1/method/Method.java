package exercise_1.method;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Method {
	@Given("a website is at the google home page")
	public void a_website_is_at_the_google_home_page() {
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("the user enters {string} into the search bar")
	public void the_user_enters_into_the_search_bar(String string) {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("links related to {string} are shown on the result page")
	public void links_related_to_are_shown_on_the_result_page(String string) {
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("the user clicks on {string} link at the top of the results page")
	public void the_user_clicks_on_link_at_the_top_of_the_results_page(String string) {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("images related to {string} are shown on the results page")
	public void images_related_to_are_shown_on_the_results_page(String string) {
	    // Write code here that turns the phrase above into concrete actions
	}

}
