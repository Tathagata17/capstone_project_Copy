package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\KIIT\\eclipse-workspace\\CapstoneProject\\src\\test\\resources\\features\\placeOrder.feature",
		glue = "testdefinations",
		plugin = {"pretty","html:reports/HTMLReports.html",
				  "json:reports/json_report.json",
				  "junit:reports/junit_report.xml"
				   } 
		)
public class testRunner {
//C:\\Users\\KIIT\\eclipse-workspace\\CapstoneProject\\src\\test\\resources\\features\\register.feature
}
