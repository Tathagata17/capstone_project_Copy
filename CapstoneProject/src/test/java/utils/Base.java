package utils;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	public  static WebDriver driver;

	public void launchBrowser() {
		Properties prop = Readproperty.readProperites();
		if (prop.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (prop.getProperty("Browser").equalsIgnoreCase("FireFox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("Select a proper browser");
		}
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));
	}
	public void closeBrowser()
	{
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.close();
	}

}
