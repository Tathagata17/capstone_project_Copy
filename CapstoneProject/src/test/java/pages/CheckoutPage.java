package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import objectrepository.Locators;
import utils.Reporter;

public class CheckoutPage {

	private WebDriver driver;
	private WebDriverWait wait;
	ExtentTest test;

	public CheckoutPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.test = test;
	}
	public WebElement getElementUtility(By value)
	{
		return driver.findElement(value);
	}
//write a function to enter the  Billing address details and validate text "Select a shipping address from your address book or enter a new address." 
	public boolean validateBillingAddressSection(String firstName,String lastName ,String email ,String Company, String country,String city, String address1,String Zipcode,String PhoneNo)
	{
		boolean actResult=true;
		try
		{
			getElementUtility(Locators.fNameInAddress).clear();
			getElementUtility(Locators.fNameInAddress).sendKeys(firstName);
			//
			getElementUtility(Locators.lNameInAddress).clear();
			getElementUtility(Locators.lNameInAddress).sendKeys(lastName);
			//
			getElementUtility(Locators.emailInAddress).clear();
			getElementUtility(Locators.emailInAddress).sendKeys(email);
			//
			getElementUtility(Locators.companyInAddress).clear();
			getElementUtility(Locators.companyInAddress).sendKeys(Company);
			//
			getElementUtility(Locators.countryInAddress).clear();
			getElementUtility(Locators.countryInAddress).sendKeys(country);
			//
			getElementUtility(Locators.cityInAddress).clear();
			getElementUtility(Locators.cityInAddress).sendKeys(city);
			//
			getElementUtility(Locators.address1).clear();
			getElementUtility(Locators.address1).sendKeys(address1);
			//
			getElementUtility(Locators.postalCode).clear();
			getElementUtility(Locators.postalCode).sendKeys(Zipcode);
			//
			getElementUtility(Locators.phoneNumber).clear();
			getElementUtility(Locators.phoneNumber).sendKeys(PhoneNo);
			getElementUtility(Locators.continueBtnInAdress).click();
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Locators.shippingdetail));
			Reporter.generateReport(driver, test, Status.PASS, "Billing Address success");
		}
		catch(TimeoutException Te)
		{
			actResult=false;
			Reporter.generateReport(driver, test, Status.FAIL, "Billing address failure");
		}
		return actResult;
	}
//write a function to click continue on the shipping Address section and validate it 
	public boolean validateClickContinueOnShippingAddress()
	{
		boolean actResult=true;
		try
		{
		getElementUtility(Locators.continueBtnInShipping).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Locators.shipingmethodText));
		Reporter.generateReport(driver, test, Status.PASS, "shipping Address success");
		}
		catch(TimeoutException Te)
		{
			actResult=false;
			Reporter.generateReport(driver, test, Status.FAIL, "shipping address failure");
		}
		return actResult;
	}
//write a function to select the shipping method click continue on the shipping method section	and validate it
	public boolean validateClickContinueOnShippingMethod(String shippingtype)
	{
		boolean actResult=true;
		try
		{
		getElementUtility(Locators.continueBtnInShipping).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Locators.payemntMethodText));
		Reporter.generateReport(driver, test, Status.PASS, "shipping menthod sucess");
		}
		catch(TimeoutException Te)
		{
			actResult=false;
			Reporter.generateReport(driver, test, Status.FAIL, "shipping menthod failure");
		}
		return actResult;
	}
//write a function to select the payment type and click continue button on the payment section and validate it
	public boolean validateClickContinueOnPaymentMetod(String shippingtype)
	{
		boolean actResult=true;
		try
		{
		getElementUtility(Locators.continueBtnInpay).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Locators.payemntMethodText));
		Reporter.generateReport(driver, test, Status.PASS, "shipping menthod sucess");
		}
		catch(TimeoutException Te)
		{
			actResult=false;
			Reporter.generateReport(driver, test, Status.FAIL, "payment method failed");
		}
		return actResult;
	}
//write a function to click on the continue button on the payment-info section and validate it
	public boolean validateClickContinueOnPaymentInfoMetod()
	{
		boolean actResult=true;
		try
		{
		getElementUtility(Locators.continueBtnInpay).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Locators.payemntMethodText));
		Reporter.generateReport(driver, test, Status.PASS, "shipping menthod sucess");
		}
		catch(TimeoutException Te)
		{
			actResult=false;
			Reporter.generateReport(driver, test, Status.FAIL, "shipping menthod sucess");
		}
		return actResult;
	}
//write a function to click on the confirm button on the confirm-order section and validate it
	public boolean validateClickConfirmOnConfirmOrderPage()
	{
		boolean actResult=true;
		try
		{
		getElementUtility(Locators.continueBtnInconfirm).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Locators.PlaceOrderText));
		Reporter.generateReport(driver, test, Status.PASS, "confirm sucess");
		}
		catch(TimeoutException Te)
		{
			actResult=false;
			Reporter.generateReport(driver, test, Status.FAIL, "confirm failed");
		}
		return actResult;
	}
}
