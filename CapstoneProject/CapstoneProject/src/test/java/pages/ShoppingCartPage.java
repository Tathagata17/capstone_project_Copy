package pages;

// write a function to enter the parameters "<country>","<zipcode>" and click on
	// the
	// T&C checkbox and clicks on checkout button
	// and validates the "checkout" text in checkout page

	/*private WebDriver driver;
	// Locators

	private By countryField = By.id("CountryId");

	private By zipCodeField = By.id("ZipPostalCode");

	private By termsCheckbox = By.id("termsofservice");

	private By checkoutButton = By.id("checkout");

	private By checkoutText = By.xpath("//h1[contains(text(),'Checkout')]");

	public ShoppingCartPage(WebDriver driver) {

		this.driver = driver;

	}
	// Method to fill in country, zip code, click T&C, and checkout

	public void proceedToCheckout(String country, String zipCode) {

		driver.findElement(countryField).sendKeys(country);

		driver.findElement(zipCodeField).sendKeys(zipCode);

		driver.findElement(termsCheckbox).click();

		driver.findElement(checkoutButton).click();

	}

	// Method to validate if the Checkout page is displayed

	public boolean isCheckoutPageDisplayed() {

		WebElement checkoutHeader = driver.findElement(checkoutText);

		return checkoutHeader.isDisplayed();

	}*/
	
	import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import objectrepository.Locators;
import utils.Reporter;

	public class ShoppingCartPage {
		private WebDriver driver;
		private WebDriverWait wait;
		private ExtentTest test;
		
		public ShoppingCartPage(WebDriver driver,ExtentTest test) {
			//super();
			this.driver = driver;
			this.test=test;
			wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		}
		public boolean ValidateCheckoutButtonClick(String country, String zipcode) {
			Select countryDropDown=new Select(driver.findElement(Locators.countryId));
			countryDropDown.selectByContainsVisibleText(country);
			driver.findElement(Locators.zipCode).sendKeys(zipcode);
			Actions action =new Actions(driver);
			WebElement TermsAndConditioncheckbox=driver.findElement(Locators.termsCheckBox);
			action.moveToElement(TermsAndConditioncheckbox).click().perform();
			driver.findElement(Locators.checkOutBtn).click();
			boolean actResult=true;
			try {
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.BillingAddressText));
				Reporter.generateReport(driver, test, Status.PASS, "shopping cart sucess");
				
			} catch (TimeoutException e) {
				actResult=false;
				Reporter.generateReport(driver, test, Status.PASS, "shopping cart failure");
			}
			return actResult;
			
		}

	}


