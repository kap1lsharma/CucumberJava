//package stepDefinitions;
//
//import java.time.Duration;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.JavascriptExecutor;
//
////import java.util.concurrent.TimeUnit;
//
////import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import io.cucumber.java.en.*;
//import pageFactory.HomePage_PF;
//import pages.loginPage;
//
//public class LoginSteps_PF {
//
//	WebDriver driver = null;
//	
//	JavascriptExecutor js = null;
//
//	loginPage login;
//
//	HomePage_PF home = new HomePage_PF(driver);;
//
//	@Given("browser is open")
//	public void browser_is_open() {
//
//		System.out.println("===I am inside LoginSteps_PF class=== ");
//
//		String projectPath = System.getProperty("user.dir");
//		System.out.println("Poject Path is:" + projectPath);
//
//		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");
//
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
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
//		login = new loginPage(driver);
//
//		login.enterUsername(username);
//		login.enterPassword(password);
//
////
////		driver.findElement(By.id("username")).sendKeys(username);
////		driver.findElement(By.id("password")).sendKeys(password);
//	}
//
//	@And("user clicks on login")
//	public void user_clicks_on_login() throws InterruptedException {
//
//		login.clickLogin();
//
//		// driver.findElement(By.id("Login")).click();
//	}
//
//	@Then("user is navigated to the home page")
//	public void user_is_navigated_to_the_home_page() throws InterruptedException {
//		
//		System.out.println("checKViewProfileDisplayed");
//		 
//		  
//		  //         driver.switchTo().alert().accept();
//			
//
//		home.checKViewProfileDisplayed();
//
////		driver.close();
////		driver.quit();
//	}
//
//}
