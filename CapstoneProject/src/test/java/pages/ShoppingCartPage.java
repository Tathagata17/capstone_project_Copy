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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectrepository.Locators;

	public class ShoppingCartPage {
		private WebDriver driver;
		private WebDriverWait wait;
		Select country;
		public ShoppingCartPage(WebDriver driver) {
			super();
			this.driver = driver;
			wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		}
		public boolean ValidateCheckoutButtonClick() {
			country=new Select(driver.findElement(Locators.countryId));
			country.selectByContainsVisibleText("India");
			driver.findElement(Locators.termsCheckBox).click();
			driver.findElement(Locators.checkOutBtn).click();
			boolean actResult=true;
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.fNameInAddress));
				
			} catch (TimeoutException e) {
				actResult=false;
				
			}
			return actResult;
			
		}

	}


