package pages;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import objectrepository.Locators;
import utils.Readproperty;
import utils.Reporter;

public class LoginPage {
	private WebDriver driver;
	private WebDriverWait wait;
	ExtentTest test;

	public LoginPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.test = test;
	}

	//navigates to login link and enters detail these steps are validated 
	public boolean validateLogin(String email, String password) {

		WebElement logInLink = driver.findElement(Locators.logInLink);

		Actions action = new Actions(driver);
		action.moveToElement(logInLink).click().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.logInTextInLoginPage));

		boolean actResult;
		Properties prop = Readproperty.readProperites();
		driver.findElement(Locators.email).sendKeys(email);
		wait.until(ExpectedConditions.attributeToBe(Locators.email,"value", email));
		driver.findElement(Locators.password).sendKeys(password);
		wait.until(ExpectedConditions.attributeToBe(Locators.password,"value", password));
		driver.findElement(Locators.loginBtn).click();
		actResult = true;
		try {
			wait.until(ExpectedConditions.urlToBe(prop.getProperty("URL")));
			Reporter.generateReport(driver, test, Status.PASS, "Login is Success");
		} catch (TimeoutException te) {
			actResult = false;
			Reporter.generateReport(driver, test, Status.FAIL, "Login is failure");
		}
		return actResult;

	}
}