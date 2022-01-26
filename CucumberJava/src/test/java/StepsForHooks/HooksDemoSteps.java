package StepsForHooks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.*;
import pages.loginPage;

public class HooksDemoSteps {

	WebDriver driver = null;
	loginPage login;
	

	@Before
	public void browserSetup() {

		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@After
	public void teardown() {

		driver.close();
		driver.quit();

	}

	@Given("user is on login Page")
	public void user_is_on_login_Page() {

		driver.navigate().to("https://test.salesforce.com/");
	}

	@When("^user enters valid (.*) and (.*)$")
	public void user_enters_valid_username_and_password(String username, String password) {

		login = new loginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);

	}

	@And("clicks on login button")
	public void clicks_on_login_button() throws InterruptedException {

		login.clickLogin();
		Thread.sleep(4000);

	}

	@Then("user is navigated to the Home Page")
	public void user_is_navigated_to_the_home_page() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		login.NewButton();
		
		login.wizard_2();
		
		login.ObtainAccessToken();
		
		login.tearDown();
		


	}

}
