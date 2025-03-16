package testdefinations;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import utils.Base;

public class Hooks extends Base{
	
	static ExtentSparkReporter spark;
	static ExtentReports extReports;
	static ExtentTest test;

	@BeforeAll()
	public static void setUpReport() {
		spark = new ExtentSparkReporter(".\\Report\\ExtentReport.html");
		extReports = new ExtentReports();
		extReports.attachReporter(spark);
	}

	@AfterAll()
	public static void afterAll() {
		extReports.flush();
	}

	@Before()
	public void before() {
		test=extReports.createTest("Register User");
		launchBrowser();
	}

	@After()
	public void after() {
		driver.quit();
	}
	
	

}
