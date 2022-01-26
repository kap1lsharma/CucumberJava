package stepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(features = "src/test/resources/Hooks/Hooks.feature",glue = {"StepsForHooks"}, 
monochrome = true,
plugin={"pretty", "junit:target/JUnitReports/report.xml", 
		"json:target/JSONReports/report.json",
		"html:target/HtmlReports/HtmlReports.html"} 

		)
public class TestRunnerForHooks {

}
