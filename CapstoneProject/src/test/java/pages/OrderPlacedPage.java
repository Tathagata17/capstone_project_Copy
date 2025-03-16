package pages;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import objectrepository.Locators;

public class OrderPlacedPage extends HomePage {
	private WebDriver driver;
	private WebDriverWait wait;
	ExtentTest test;

	public OrderPlacedPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		this.driver = driver;
		this.test = test;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	//to be reviewed
	public boolean validatePlacingOrder() {
		boolean actResult = true;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(Locators.continueBtnIncompleted));
			driver.findElement(Locators.continueBtnIncompleted).click();
			// boolean actResult=verifyHomePage();
		} catch (TimeoutException Te) {
			actResult = false;
		}
		if (verifyHomePage() && actResult) {
			return true;
		} else {
			return false;
		}
	}
}