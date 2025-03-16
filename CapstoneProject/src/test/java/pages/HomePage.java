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

public class HomePage {
	private WebDriver driver;
	private WebDriverWait wait;
	ExtentTest test;

	public HomePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.test = test;
	}
	//verify if its Home page
	public  boolean verifyHomePage() {
		String currentUrl = driver.getCurrentUrl();
		boolean actResult;
		Properties prop = Readproperty.readProperites();
		if (currentUrl.equals(prop.getProperty("URL"))) {
			actResult = true;
			Reporter.generateReport(driver, test, Status.PASS, "Home Page Launch is Sucess");
		} else {
			actResult = false;
			Reporter.generateReport(driver, test, Status.FAIL, "Home Page Launch is failure");
		}
		return actResult;
	}
	
	//validate selection of computer tab and desktop option from the list
	public boolean ValidateSelectComputerTab() {
		boolean actResult;
		Actions action = new Actions(driver);
		WebElement computer = driver.findElement(Locators.computer);
		WebElement desktop = driver.findElement(Locators.desktop);
		action.moveToElement(computer).pause(Duration.ofSeconds(5)).moveToElement(desktop).click().perform();
		try {
			WebElement desktopResultText = driver.findElement(Locators.desktopResultText);
			wait.until(ExpectedConditions.visibilityOf(desktopResultText));
			String actResultText = desktopResultText.getText();
			if (actResultText.equals("Desktops")) {
				actResult = true;
				Reporter.generateReport(driver, test, Status.PASS, "Navigates to Computers menu success");
			} else {
				actResult = false;
				Reporter.generateReport(driver, test, Status.FAIL, "Navigates to Computers menu failure");
			}
		} catch (TimeoutException Te) {
			actResult = false;
			Reporter.generateReport(driver, test, Status.FAIL, "Navigates to Computers menu failure");
		}
		return actResult;
	}
	
	//validation of logout functionality
	public boolean validateLogOut() {
		boolean actResult;
		Actions action = new Actions(driver);
		WebElement LogoutLink = driver.findElement(Locators.logoutlink);
		action.moveToElement(LogoutLink).click().perform();
		try {
			WebElement logInLink = driver.findElement(Locators.logInLink);
			wait.until(ExpectedConditions.visibilityOf(logInLink));
			String actResultText = logInLink.getText();
			if (actResultText.equals("Log in")) {
				actResult = true;
				Reporter.generateReport(driver, test, Status.PASS, "Log out is successfull");
			} else {
				actResult = false;
				Reporter.generateReport(driver, test, Status.FAIL, "Log out failed ");
			}
		} catch (TimeoutException Te) {
			actResult = false;
			Reporter.generateReport(driver, test, Status.FAIL, "Log out failed");
		}
		return actResult;
	}
	
	//write function to click to register page and validate it 
	
	public boolean validateClcikToRegisterLink()
	{
		Actions action = new Actions(driver);
		WebElement registerLink = driver.findElement(Locators.registerLink);
		action.moveToElement(registerLink).click().perform();
		boolean actResult=true;
		try
		{
			WebElement registerPageText=driver.findElement(Locators.registerPageText);
			wait.until(ExpectedConditions.visibilityOf(registerPageText));
		}
		catch(TimeoutException Te)
		{
			actResult=false;
		}
		return actResult;
	}
	//write function to click on login link and validate
	public boolean validateClickToLoginLink()
	{
		Actions action = new Actions(driver);
		WebElement loginLink = driver.findElement(Locators.logInLink);
		action.moveToElement(loginLink).click().perform();
		boolean actResult=true;
		try
		{
			WebElement logInTextInLoginPage=driver.findElement(Locators.logInTextInLoginPage);
			wait.until(ExpectedConditions.visibilityOf(logInTextInLoginPage));
		}
		catch(TimeoutException Te)
		{
			actResult=false;
		}
		return actResult;
	}
}
