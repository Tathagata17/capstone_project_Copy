package pages;

//write a function to select the product and validate

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

public class ProductSelectPage {
	private WebDriver driver;
	private WebDriverWait wait;
	ExtentTest test;

	public ProductSelectPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.test = test;
	}

	// selecting first product
	public boolean validateSelectingProduct(String productName) {
		boolean actResult = true;
		try {
			WebElement Product = driver.findElement(Locators.SelectproductXpath);
			//By.xpath("//a[contains(@title,'"+productName+"')]")
			wait.until(ExpectedConditions.elementToBeClickable(Product));
			Product.click();
			WebElement productPageText = driver.findElement(Locators.productNameInProductDetailPage);
			wait.until(ExpectedConditions.visibilityOf(productPageText));
			Reporter.generateReport(driver, test, Status.PASS, "selecting  product is successful");
		} catch (TimeoutException Te) {
			actResult = false;
			Reporter.generateReport(driver, test, Status.FAIL, "selecting  product is failure");
		}
		return actResult;
	}

}
