package stepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", glue = {
		"stepDefinitions" }, dryRun = false, monochrome = true, stepNotifications = true, plugin = { "pretty",
				"json:target/JSONReports/Cucumber.json", "junit:target/Cukes.xml",
				"html:target/HtmlReports/HtmlReports.html" })

public class TestRunner {
	
	

}
