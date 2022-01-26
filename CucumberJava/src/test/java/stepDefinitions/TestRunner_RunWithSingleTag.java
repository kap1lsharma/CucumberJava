  package stepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/FeaturesWithTags",
glue = {"stepDefinitions"}, 
tags = "@smoke"

		)

public class TestRunner_RunWithSingleTag {
	
	

}
