package testdefinations;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.RegisterPage;

public class RegisterStepDefination {
	
	WebDriver driver = Hooks.driver;
	ExtentTest test = Hooks.test;
	
	HomePage homepage;
	RegisterPage registerpage;
	

	@Given("user is on the home page")
	public void user_is_on_the_home_page() {
		homepage=new HomePage(driver,test);
		Assert.assertTrue(homepage.verifyHomePage());
	}

	@When("user clicks on register link and user navigates to register page")
	public void user_clicks_on_register_link_and_user_navigates_to_register_page() {
		
		Assert.assertTrue(homepage.validateClcikToRegisterLink());
	}

	@When("user selects {string}, enters personal details  {string},{string},{string},{string} and {string} and clicks on register button")
	public void user_selects_enters_personal_details_and_and_clicks_on_register_button(String string, String string2,
			String string3, String string4, String string5, String string6) {
		registerpage=new RegisterPage(driver,test);
		registerpage.fillDetails(string, string2, string3, string4, string5, string6);
		//Assert.assertTrue(actResult);
	}

	@Then("user verifies Your registration completed message and clicks on continue button")
	public void user_verifies_your_registration_completed_message_and_clicks_on_continue_button() {
		Assert.assertTrue(registerpage.completeRegistration());
	}

	@Then("user logs out")
	public void user_logs_out() {
		Assert.assertTrue(homepage.validateLogOut());
	}

	@Then("user validates the error message The specified email already exists")
	public void user_validates_the_error_message_the_specified_email_already_exists() {
		Assert.assertTrue(registerpage.validateFailedRegistration());
	}

}
