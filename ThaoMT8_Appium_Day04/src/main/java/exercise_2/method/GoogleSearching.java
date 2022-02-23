package exercise_2.method;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearching {
	// Google search result page elements
	@Given("^the user navigates to the Google home page$")
	public void the_user_navigates_to_the_Google_home_page() {
		// Write code here that turns the phrase above into concrete actions
		
	}
	@When("^the user entered (.*) at the search bar$")
	public void the_user_entered_panda_at_the_search_bar(String search){
		// Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^the results page shows links related to (.*)$")
	public void the_results_page_shows_links_related_to_panda(String search) {
		// Write code here that turns the phrase above into concrete actions
	}
	@And("^image links for (.*)$")
	public void image_links_for_panda(String search) {
		// Write code here that turns the phrase above into concrete actions
	    
	}
	@And("^video links for (.*)$")
	public void video_links_for_panda(String search) {
		// Write code here that turns the phrase above into concrete actions
	    
	}
	
	//Simple Google search
	@Given("^a web browser is on the Google page$")
	public void a_web_browser_is_on_the_Google_page() {
		// Write code here that turns the phrase above into concrete actions
	}
	@When("^the search phrase (.*) is entered$")
	public void the_search_phrase_panda_is_entered(String search){
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("^results for (.*) are shown$")
	public void results_for_panda_are_shown(String search) {
		// Write code here that turns the phrase above into concrete actions
	}
	@And("^the following related results are shown$")
	public void the_following_relate_results_are_shown() {
		// Write code here that turns the phrase above into concrete actions
	}
}
