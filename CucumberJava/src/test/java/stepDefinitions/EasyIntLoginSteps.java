//package stepDefinitions;
//
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import io.cucumber.java.en.*;
//
//public class EasyIntLoginSteps {
//
//	WebDriver driver = null;
//
//	@Given("browser is open")
//	public void browser_is_open() {
//
//		String projectPath = System.getProperty("user.dir");
//		System.out.println("Poject Path is:" + projectPath);
//
//		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");
//
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
//	}
//
//	@And("user is on login page")
//	public void user_is_on_login_page() {
//
//		driver.navigate().to("https://test.salesforce.com/");
//		driver.manage().window().maximize();
//	}
//
//	@When("^user enters (.*) and (.*)$")
//	public void user_enters_username_and_password(String username, String password) {
//
//		driver.findElement(By.id("username")).sendKeys(username);
//		driver.findElement(By.id("password")).sendKeys(password);
//	}
//
//	@And("user clicks on login")
//	public void user_clicks_on_login() {
//
//		driver.findElement(By.id("Login")).click();	
//	}
//
//	@Then("user is navigated to the home page")
//	public void user_is_navigated_to_the_home_page() {		
//		
//		driver.findElement(By.className("slds-button")).isDisplayed();	
//		
//		
//		 	
//        driver.close();
//        driver.quit();
//	
//
//	}
//
//}
