package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class loginPage {

	protected WebDriver driver;

	Select drpAPI;

	// Login into salesforce
	private By txt_username = By.id("username");
	private By txt_password = By.id("password");
	private By btn_login = By.id("Login");

	// Wizard 1 Creating Intrgration master
	private By btn_new = By.xpath("//*[@id=\'brandBand_1\']/div/div/div/div/div[1]/div[1]/div[2]/ul/li[1]/a/div");
	private By ForAppName = By.xpath("(//*[@class='slds-input'])[2]");
	private By nextBtn = By
			.xpath("//*[@id=\'brandBand_2\']/div/div/div/div/div/div/div/div/div/div/div/div[5]/button[2]");

	// Wizard 2 for Token generation
	private By Preferred_Interface_Name = By.xpath("(//*[@class=\'slds-input\'])[3]");
	private By EnterReqURL = By.xpath("(//*[@class='slds-input'])[4]");
	private By ChangeAuthType = By.xpath("(//*[@class='slds-select'])[4]");
	private By GetNewTokenAccess = By.xpath("//*[@id=\'Authorization\']/div/div[3]/span/button");

	// Token generation window creadentials
	private By AuthoCheckBox = By.xpath("(//*[@class='myCheckbox'])[2]");
	private By RefreshToken = By.xpath("(//*[@type='checkbox'])[23]"); // dynamic
	private By TokenName = By.xpath("(//*[@class='slds-input'])[15]"); // dynamic
	private By AuthorizationURL = By.xpath("(//*[@name='Authorization URL'])[2]"); // dynamic
	private By AccessTokenURL = By.xpath("((//*[@class='slds-input']))[18]"); // dynamic
	private By ClientID = By.xpath("(//*[@class=\"slds-input\"])[19]"); // dynamic
	private By ClientSecret = By.xpath("(//*[@class=\"slds-input\"])[20]"); // dynamic
	private By ReqTokenBtn = By
			.xpath("//*[@id=\'Authorization\']/div/div[3]/span/div[2]/div[2]/section/div/footer/div/button[1]"); // dynamic

	// after getting the token
	private By AvailableToken = By.xpath("(//*[@class='slds-select'])[3]");
	private By AuthTypeForToken = By.xpath("(//*[@class='slds-select'])[2]");

	// wizard_2
	private By SaveNext = By.xpath("(//*[@class='slds-button slds-button_brand'])[2]");

	// Element wizard_3
	private By SelectSalesforceObject = By.xpath("(//*[@class='slds-input'])[2]");

	// Element wizard _4
	private By Select_Object_One_By_One = By.xpath("(//*[@class='slds-select'])[2]");
	private By RequiredFieldsAdd = By.xpath("(//*[@class=\"slds-button slds-button_brand btnAddRemoveCID\"])[2]");

	public loginPage(WebDriver driver) {

		this.driver = driver;

		if (!driver.getTitle().equals("Login | Salesforce")) {
			throw new IllegalStateException("This is not a login page. The current page is :" + driver.getCurrentUrl());
		}
	}

	public void enterUsername(String username) {

		driver.findElement(txt_username).sendKeys(username);
	}

	public void enterPassword(String password) {

		driver.findElement(txt_password).sendKeys(password);
	}

	public void clickLogin() {

		driver.findElement(btn_login).click();
	}

	public void NewButton() {

		try {

			driver.findElement(btn_new).click();

			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(ForAppName)).click();
			driver.findElement(ForAppName).sendKeys("DemoMaster01");

			drpAPI = new Select(driver.findElement(By.xpath("(//*[@class='slds-select'])[1]")));
			drpAPI.selectByValue("REST");

			driver.findElement(nextBtn).click();

		} catch (Exception e) {

			System.out.println("Issue in wizard 1" + e);
		}
	}

	public void APICallType() {

		try {

			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.presenceOfElementLocated(Preferred_Interface_Name)).click();

			Thread.sleep(1000);

			driver.findElement(Preferred_Interface_Name).sendKeys("Auth");
//			driver.findElement(Preferred_Interface_Name).clear();
//			driver.findElement(Preferred_Interface_Name).sendKeys("Auth");
//
//			driver.findElement(AuthoCheckBox).click();
//			driver.findElement(AuthoCheckBox).click();
			driver.findElement(AuthoCheckBox).click();

			drpAPI = new Select(driver.findElement(By.xpath("(//*[@class='slds-select'])[2]")));
			drpAPI.selectByValue("POST");

			driver.findElement(EnterReqURL).sendKeys("http://login.salesforce.com/services/oauth2/authorize");

			drpAPI = new Select(driver.findElement(ChangeAuthType));
			drpAPI.selectByValue("OAuth2.0");

			driver.findElement(GetNewTokenAccess).click();

		} catch (Exception e) {

			System.out.println("Issue in 2nd wizard" + e);

		}
	}

	public void ObtainAccessToken() {

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(RefreshToken)).click();

		driver.findElement(TokenName).sendKeys("Token001");

		drpAPI = new Select(driver.findElement(By.xpath("(//*[@class='slds-select'])[8]")));
		drpAPI.selectByValue("Authorization_Code");

		driver.findElement(AuthorizationURL).sendKeys("https://login.salesforce.com/services/oauth2/authorize");
		driver.findElement(AccessTokenURL).sendKeys("https://login.salesforce.com/services/oauth2/token");
		driver.findElement(ClientID)
				.sendKeys("3MVG9fe4g9fhX0E4NgJkxKIlg9VN2ee4mYHFiBciZcsk.HBamuwmRnXTDmuj5tJHlV2UACrk8Fj0t4UaZrPvT");
		driver.findElement(ClientSecret).sendKeys("56599EC3DF233F5586013040315987C144A44B5B5E4C6092CD8DC950E5711E0B");

		drpAPI = new Select(driver.findElement(By.xpath("(//*[@class='slds-select'])[7]")));
		drpAPI.selectByValue("Send Client Credentials in body");

		driver.findElement(ReqTokenBtn).click();

	}

	public void LoginForToken() {

		driver.findElement(txt_username).sendKeys("ankitrawat07@resilient-panda-s7x8ue.com");
		driver.findElement(txt_password).sendKeys("Ankit@1234");
		driver.findElement(btn_login).click();

	}

	public void afterGettingToken() {

		try {

			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(AuthTypeForToken)).click();

			if (driver.getTitle().equals("Lightning Experience | Salesforce")) {

				drpAPI = new Select(driver.findElement(AuthTypeForToken));
				drpAPI.selectByValue("OAuth2.0");
				drpAPI = new Select(driver.findElement(AvailableToken));
				drpAPI.selectByIndex(1);

				String Token = driver.findElement(By.xpath("(//*[@class='slds-input'])[3]")).getAttribute("value");

				System.out.println("Token for this application is : " + Token);

			}

			else {

				System.out.println("This is not a Right page.The current page is :" + driver.getCurrentUrl());
			}

		} catch (Exception e) {

			System.out.println("Unable to Print the token." + e);
		}

	}

	// Prior to Wizard 3 for selecting particular api call
	public void PostCall() {

		try {

			Thread.sleep(1000);

			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='slds-input'])[1]")))
					.click();

			driver.findElement(By.xpath("(//*[@class='slds-input'])[1]")).sendKeys("PostInbound");
//			driver.findElement(By.xpath("(//*[@class='slds-input'])[1]")).clear();
//			driver.findElement(By.xpath("(//*[@class='slds-input'])[1]")).sendKeys("PostInbound");
//
//			driver.findElement(By.xpath("(//*[@class='myCheckbox'])[1]")).click();
//			driver.findElement(By.xpath("(//*[@class='myCheckbox'])[1]")).click();
			driver.findElement(By.xpath("(//*[@class='myCheckbox'])[1]")).click();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			drpAPI = new Select(driver.findElement(By.xpath("(//*[@class='slds-select'])[1]")));
			drpAPI.selectByValue("POST");

//			driver.findElement(By.xpath("(//*[@class='slds-input'])[2]")).sendKeys("https://resilient-panda-s7x8ue-dev-ed.my.salesforce.com/services/data/v50.0/sobjects/Account");

			driver.findElement(SaveNext).click();

		} catch (Exception e) {

			System.out.println("Issue in Wizard_2" + e);

		}
	}

	public void Wizard_3() {

		try {

			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(SelectSalesforceObject)).click();

			driver.findElement(SelectSalesforceObject).click();

			driver.findElement(SelectSalesforceObject).sendKeys("Account");
			driver.findElement(By.xpath("//*[@id=\"Account\"]")).click();

			driver.findElement(SelectSalesforceObject).clear();
			driver.findElement(SelectSalesforceObject).click();

			driver.findElement(SelectSalesforceObject).sendKeys("Contact");
			driver.findElement(By.xpath("//*[@id=\"Contact\"]")).click();
			
			
            //next button 
			driver.findElement(By.xpath("//*[@class=\"slds-button slds-button--success\"]")).click();

		} catch (Exception e) {

			System.out.println("Issue in wizard_3" + e);
		}

	}

	public void wizard_4() {

		try {

			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(Select_Object_One_By_One)).click();

			driver.findElement(By.xpath("//*[@value='Account']")).click();
			
			
//			drpAPI = new Select(driver.findElement(Select_Object_One_By_One));
//			drpAPI.selectByValue("Account");
//			
//			
			
			
			
			driver.findElement(RequiredFieldsAdd).click();

//			pick & drop into selected sf field
//			
//			
//			then select another object ie contact
//			
//			Relationship Fields
//			
//			& then next

		} catch (Exception e) {

			System.out.println("Issue in wizard_4" + e);

		}

	}

	public void tearDown() {

		driver.close();
		driver.quit();
	}

}