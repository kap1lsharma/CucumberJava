package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
//import pages.Wizard3Page;
import pages.loginPage;

public class EasyIntLoginSteps_POM {

	WebDriver driver = null;
	loginPage login;

//	Wizard3Page wp; 

	@Given("browser is open")
	public void browser_is_open() {

		System.out.println("===I am inside Login Steps POM====");

		String projectPath = System.getProperty("user.dir");
		System.out.println("Project Path is: " + projectPath);

		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	}

	@And("user is on login page")
	public void user_is_on_login_page() {

		driver.navigate().to("https://test.salesforce.com/");
		driver.manage().window().maximize();
	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) {

		login = new loginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);

	}

	@And("user clicks on login")
	public void user_clicks_on_login() throws InterruptedException {

		login.clickLogin();

	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {

		System.out.println("You are on : " + driver.getTitle());

	}

	@Then("user keeps filling details till endpointUrl and JSON")
	public void user_keeps_filling_details_till_endpointUrl_and_JSON() {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		login.NewButton();

		login.APICallType();

		login.ObtainAccessToken();

		login.LoginForToken();

		login.afterGettingToken();

		login.PostCall();

		login.Wizard_3();

		login.wizard_4();
//		login.tearDown();
	}

}
