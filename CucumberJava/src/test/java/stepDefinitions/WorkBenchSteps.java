package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.WorkBenchPage;

public class WorkBenchSteps {

	WebDriver driver = null;
	WorkBenchPage wb;

	@Given("^User enters the url$")
	public void user_enters_the_url() throws Throwable {

		System.out.println("===I am inside WorkBench====");

		String projectPath = System.getProperty("user.dir");
		System.out.println("Project Path is: " + projectPath);

		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		driver.navigate().to("https://workbench.developerforce.com/login.php");
		driver.manage().window().maximize();

	}

	@When("^User change the environment and clicks on login with salesforce$")
	public void user_change_the_environment_and_clicks_on_login_with_salesforce() throws Throwable {

		wb = new WorkBenchPage(driver);

		wb.openWorkBench();

	}

	@Then("^User login into same org$")
	public void user_login_into_same_org() throws Throwable {

		wb.LoginIntoSalesforce();

	}

	@Then("^User clicks on Rest Explorer$")
	public void user_clicks_on_rest_explorer() throws Throwable {
		
		wb.ChooseUtilities();

	}

	@And("^User the API Call type$")
	public void user_the_api_call_type() throws Throwable {

	}

}
