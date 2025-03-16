package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import objectrepository.Locators;
import utils.Reporter;

public class RegisterPage {
	private WebDriver driver;
	private WebDriverWait wait;
	ExtentTest test;

	public RegisterPage(WebDriver driver, ExtentTest test) {
		super();
		this.driver = driver;
		this.test = test;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	}

	public boolean fillDetails(String gender, String fName, String lName, String email, String password,
			String cPassword) {
		driver.findElement(By.id("gender-" + gender)).click();
		//wait needs to be added 
		driver.findElement(Locators.firstName).sendKeys(fName);
		driver.findElement(Locators.lastName).sendKeys(lName);
		driver.findElement(Locators.email).sendKeys(email);
		driver.findElement(Locators.password).sendKeys(password);
		driver.findElement(Locators.confirmPassword).sendKeys(cPassword);
		driver.findElement(Locators.registerBtn).click();
		boolean actResult = true;
		try {
			// explicit wait for registration completed text
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.registerCompletedTxt));
			Reporter.generateReport(driver, test, Status.PASS, "registration is successful");
		} catch (TimeoutException te) {
			actResult = false;
			Reporter.generateReport(driver, test, Status.FAIL, "registration is failed");
		}
		return actResult;

	}

	public boolean completeRegistration() {
		driver.findElement(Locators.registerContinueBtn).click();
		boolean actResult = true;
		try {
			// explicit wait going back to home page
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.gmailValidationTxt));
			Reporter.generateReport(driver, test, Status.PASS, "registration is completed");
		} catch (TimeoutException te) {
			actResult = false;
			Reporter.generateReport(driver, test, Status.FAIL, "registration is not completed");
		}
		return actResult;

	}

	public boolean validateFailedRegistration(String gender, String fName, String lName, String email, String password,
			String cPassword) {
		driver.findElement(By.id("gender-" + gender)).click();
		//wait needs to be added
		driver.findElement(Locators.firstName).sendKeys(fName);
		driver.findElement(Locators.lastName).sendKeys(lName);
		driver.findElement(Locators.email).sendKeys(email);
		driver.findElement(Locators.password).sendKeys(password);
		driver.findElement(Locators.confirmPassword).sendKeys(cPassword);
		driver.findElement(Locators.registerBtn).click();
		boolean actResult = true;
		try {
			// explicit wait for error message text
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.errorMsgForRegistration));
			Reporter.generateReport(driver, test, Status.PASS, "error message is displayed");
		} catch (TimeoutException te) {
			actResult = false;
			Reporter.generateReport(driver, test, Status.FAIL, "error message is not displayed");
		}
		return actResult;
	}

}