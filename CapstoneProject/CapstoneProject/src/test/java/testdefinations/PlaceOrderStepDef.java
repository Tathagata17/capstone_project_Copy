package testdefinations;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderPlacedPage;
import pages.ProductDetailsPage;
import pages.ProductSelectPage;
import pages.ShoppingCartPage;

public class PlaceOrderStepDef {
	
	private WebDriver driver=Hooks.driver;
	private ExtentTest test=Hooks.test;
	
	HomePage homepage;
	LoginPage loginpage;
	ProductSelectPage productselectpage;
	ProductDetailsPage productdetailspage;
	ShoppingCartPage shoppingcartpage;
	CheckoutPage checkoutPage;
	OrderPlacedPage orderplacedpage;
	
	@Given("user is on home page")
	public void user_is_on_home_page() {
		homepage=new HomePage(driver,test);
		Assert.assertTrue(homepage.verifyHomePage());
	}

	@When("user clicks on login link")
	public void user_clicks_on_login_link() {
		Assert.assertTrue(homepage.validateClickToLoginLink());
	}

	@When("user enters email {string} and password {string} and click login button")
	public void user_enters_email_and_password_and_click_login_button(String email   , String password) {
		loginpage=new LoginPage(driver,test);
		boolean actResult=loginpage.validateLogin(email, password);
		Assert.assertTrue(actResult);
	}

	@When("user navigates to Computers menu and selects item {string} from the list and clicks")
	public void user_navigates_to_computers_menu_and_selects_item_from_the_list_and_clicks(String item) {
		Assert.assertTrue(homepage.ValidateSelectComputerTab(item));
	}

	@When("user selects the product {string}")
	public void user_selects_the_product(String product) {
		productselectpage=new ProductSelectPage(driver,test);
		Assert.assertTrue(productselectpage.validateSelectingProduct(product));
	}

	@When("user selects the processor {string},RAM {string},HDD {string},Software {string} and clicks on add to cart button")
	public void user_selects_the_processor_ram_hdd_software_and_clicks_on_add_to_cart_button(String processor,
			String RAM, String hdd  , String software) {
		productdetailspage=new ProductDetailsPage(driver,test);
		Assert.assertTrue(productdetailspage.ValidateaddTocart(processor, RAM, hdd, software));
	}

	@When("user clicks on the shopping cart link")
	public void user_clicks_on_the_shopping_cart_link() {
		Assert.assertTrue(productdetailspage.gotoShoppingCart());
	}

	@When("user selects country {string},Zipcode {string} , clicks on terms and conditions checkbox and clicks on checkout button")
	public void user_selects_country_zipcode_clicks_on_terms_and_conditions_checkbox_and_clicks_on_checkout_button(
			String country, String zipcode) {
		shoppingcartpage=new ShoppingCartPage(driver,test); 
		Assert.assertTrue(shoppingcartpage.ValidateCheckoutButtonClick(country, zipcode));
	}

	@When("user enters Billing address firstname {string},lastname {string} ,email {string} ,company {string},country {string},city {string},address1 {string},zipcode {string}, Phone no {string} and clicks on continue button")
	public void user_enters_billing_address_firstname_lastname_email_company_country_city_address1_zipcode_phone_no_and_clicks_on_continue_button(
			String firstName, String lastname, String email,String Company,String country, String city, String address1, String zipcode,String PhoneNo
			) {
		checkoutPage = new CheckoutPage(driver,test);
		boolean actResult=checkoutPage.validateBillingAddressSection(firstName, lastname, email, Company, country, city, address1, zipcode, PhoneNo);
		Assert.assertTrue(actResult);
	}

	@When("user verifies default address is selected and clicks on continue button")
	public void user_verifies_default_address_is_selected_and_clicks_on_continue_button() {
		Assert.assertTrue(checkoutPage.validateClickContinueOnShippingAddress());
	}

	@When("user selects the shippingType {string} and clicks on continue button")
	public void user_selects_the_shipping_type_and_clicks_on_continue_button(String string) {
		Assert.assertTrue(checkoutPage.validateClickContinueOnShippingMethod(string));
	}

	@When("user selects the PaymentType {string} and clicks on continue button")
	public void user_selects_the_payment_type_and_clicks_on_continue_button(String string) {
		Assert.assertTrue(checkoutPage.validateClickContinueOnPaymentMetod(string));
	}

	@When("user verifies cod selected by default and clicks on continue button")
	public void user_verifies_cod_selected_by_default_and_clicks_on_continue_button() {
		Assert.assertTrue(checkoutPage.validateClickContinueOnPaymentInfoMetod());
	}

	@When("user verifies the product information clicks on confirm button")
	public void user_verifies_the_product_information_clicks_on_confirm_button() {
		Assert.assertTrue(checkoutPage.validateClickConfirmOnConfirmOrderPage());
	}

	@Then("user validates the order and clicks on continue button")
	public void user_validates_the_order_and_clicks_on_continue_button() {
		 orderplacedpage =new OrderPlacedPage(driver,test);
		Assert.assertTrue(orderplacedpage.validatePlacingOrder());
	}

	@Then("user Logs out")
	public void user_logs_out() {
		Assert.assertTrue(homepage.validateLogOut());
	}

	@When("user selects credit card Type {string}, enters card holder name {string}, card number {string},expiry month {string},expiry year {string} and cvv {string} and clicks on continue button")
	public void user_selects_credit_card_type_enters_card_holder_name_card_number_expiry_month_expiry_year_and_cvv_and_clicks_on_continue_button(
			String creditCardType, String 
			cardHolderName, String cardNumber, String expiryMonth, String expiryYear, String cardCode) {
		Assert.assertTrue(checkoutPage.validateFillingPaymentDetails(creditCardType, cardHolderName, cardNumber, expiryMonth, expiryYear, cardCode));
	}

	@Then("user validates the error message Wrong card code is displayed")
	public void user_validates_the_error_message_wrong_card_code_is_displayed() {
		Assert.assertTrue(checkoutPage.validateTheErorrMessage());
	}
}
