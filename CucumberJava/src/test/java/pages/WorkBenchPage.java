package pages;

import org.apache.http.protocol.HTTP;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorkBenchPage {

	protected WebDriver driver;

	// For dropdown
	Select drpAPI;

	loginPage login;

	// For workbench
	private By Environment = By.xpath("//*[@id=\'oauth_env\']");
//	private By API_Version = By.xpath("//*[@id=\'oauth_apiVersion\']");
	private By termsAccept = By.xpath("//*[@id=\'termsAccepted\']");
	private By LoginWithSalesforce = By.xpath("//*[@id=\'loginBtn\']");

	// To login into workbench by salesforce
	private By txt_username = By.id("username");
	private By txt_password = By.id("password");
	private By btn_login = By.id("Login");

	// For selecting the REST
	private By Utilities = By.xpath("(//*[@class=\'down\'])[6]");
	private By RestExplorer = By.xpath("(//*[text()=\'REST Explorer\'])[1]");

	public WorkBenchPage(WebDriver driver) {

		this.driver = driver;

		if (!driver.getTitle().equals("Workbench")) {
			throw new IllegalStateException("This is not a login page. The current page is :" + driver.getCurrentUrl());
		}
	}

	public void openWorkBench() {

		try {

			System.out.println("Ready to enter the details into workbench");

			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(Environment)).click();

			Thread.sleep(2000);

			drpAPI = new Select(driver.findElement(Environment));

			drpAPI.selectByVisibleText("Sandbox");

			driver.findElement(By.xpath("//*[text()='Sandbox']"));

			driver.findElement(termsAccept).click();

			driver.findElement(LoginWithSalesforce).click();

		} catch (Exception e) {

			System.out.println("Issue in workbench landing page" + e);

		}

	}

	public void LoginIntoSalesforce() {

		try {

			WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.presenceOfElementLocated(txt_username)).click();

			driver.findElement(txt_username).sendKeys("samriddh.malik@psagtechnologies.com.psagorg.qa");
			driver.findElement(txt_password).sendKeys("SAMRIDDH@123");
			driver.findElement(btn_login).click();

		} catch (Exception e) {

			System.out.println("Issue in LoginIntoSalesforce" + e);

		}

	}

	public void ChooseUtilities() {

		try {

			WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.presenceOfElementLocated(Utilities)).click();

			driver.findElement(Utilities).click();
			driver.findElement(RestExplorer).click();

		} catch (Exception e) {

			System.out.println("Issue in Choosing Utilities" + e);

		}

	}

	public void chooseProtocolMethod() {

		try {

			login = new loginPage(driver);

			login.Call();

		} catch (Exception e) {

			System.out.println("Issue in choosing HTTP Method" + e);
		}

	}
}
