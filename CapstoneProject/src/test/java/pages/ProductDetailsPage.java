
//write a function to enter the parameters 
//"<processor>","<ram>","<hdd>","<software>" and clcik add to cart button
//validate the text "The product has been added to your shopping cart"

//**********
//write a function to hover on the shopping cart link 
//and click on Go to cart button using mouse action
// and validate the text "Shopping cart"

package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import objectrepository.Locators;
import utils.Reporter;

public class ProductDetailsPage {
	private WebDriver driver;
	private WebDriverWait wait;
	ExtentTest test;

	public ProductDetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		this.test = test;
	}

	//ask sir do we need to wait for every  statement to be executed
	public boolean ValidateaddTocart(String processor, String ram, String hdd, String software) {
		driver.findElement(By.xpath("//label[text()='" + processor + "']//preceding-sibling::input")).click();
		driver.findElement(By.xpath("//label[text()='" + ram + "']//preceding-sibling::input")).click();
		driver.findElement(By.xpath("//label[text()='" + hdd + "']//preceding-sibling::input")).click();
		driver.findElement(By.xpath("//label[text()='" + software + "']//preceding-sibling::input")).click();
		wait.until(ExpectedConditions.elementToBeClickable(Locators.addtocartbutton));
		driver.findElement(Locators.addtocartbutton).click();
		boolean actResult = true;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.message));
			Reporter.generateReport(driver, test, Status.PASS, "Product Detail success");
		} catch (TimeoutException te) {

			actResult = false;
			Reporter.generateReport(driver, test, Status.FAIL, "Product detail Failure");
		}
		return actResult;
	}

	public boolean gotoShoppingCart() {
		wait.until(ExpectedConditions.elementToBeClickable(Locators.shoppingcartbutton));
		WebElement cartLink = driver.findElement(Locators.shoppingcartbutton);
		WebElement goToCart = driver.findElement(Locators.goToCartBtn);
		Actions acts = new Actions(driver);
		acts.moveToElement(cartLink).pause(Duration.ofSeconds(2)).moveToElement(goToCart).pause(Duration.ofSeconds(2))
				.click().perform();
		boolean actResult = true;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.shoppingCartText));
			Reporter.generateReport(driver, test, Status.PASS, "shopping cart success");
		} catch (TimeoutException te) {
			actResult = false;
			Reporter.generateReport(driver, test, Status.PASS, "shopping cart failure");
		}
		return actResult;

	}

}
