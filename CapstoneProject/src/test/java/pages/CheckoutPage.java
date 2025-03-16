package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

public class CheckoutPage {
//write a function to enter the  Billing address details and validate text "Select a shipping address from your address book or enter a new address." 
	private WebDriver driver;
	private WebDriverWait wait;
	ExtentTest test;

	public CheckoutPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.test = test;
	}
//write a function to click continue on the shipping Address section and validate it 
//write a function to select the shipping method click continue on the shipping method section	and validate it
//write a function to select the payment type and click continue button on the payment section and validate it 
//write a function to click on the continue button on the payment-info section and validate it 	
//write a function to click on the confirm button on the confirm-order section and validate it 	
}
