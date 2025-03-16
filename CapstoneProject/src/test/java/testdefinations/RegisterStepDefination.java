package testdefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterStepDefination {

	@Given("user is on the home page")
	public void user_is_on_the_home_page() {

	}

	@When("user clicks on register link and user navigates to register page")
	public void user_clicks_on_register_link_and_user_navigates_to_register_page() {

	}

	@When("user selects {string}, enters personal details  {string},{string},{string},{string} and {string} and clicks on register button")
	public void user_selects_enters_personal_details_and_and_clicks_on_register_button(String string, String string2,
			String string3, String string4, String string5, String string6) {

	}

	@Then("user verifies Your registration completed message and clicks on continue button")
	public void user_verifies_your_registration_completed_message_and_clicks_on_continue_button() {

	}

	@Then("user logs out")
	public void user_logs_out() {

	}

	@Then("user validates the error message The specified email already exists")
	public void user_validates_the_error_message_the_specified_email_already_exists() {

	}

}
