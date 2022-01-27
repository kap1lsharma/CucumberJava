package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage2 {

	protected WebDriver driver;

	Select drpAPI;

	private By txt_username = By.id("username");

	private By txt_password = By.id("password");

	private By btn_login = By.id("Login");

	private By btn_new = By.xpath("//*[@id=\'brandBand_1\']/div/div/div/div/div[1]/div[1]/div[2]/ul/li[1]/a/div");

	private By ForAppName = By.xpath("//*[@id=\'input-72\']");

	private By nextBtn = By
			.xpath("//*[@id=\'brandBand_2\']/div/div/div/div/div/div/div/div/div/div/div/div[5]/button[2]");

	private By Preferred_Interface_Name = By.xpath("//*[@id=\'input-76\']");

	private By SaveNext = By.xpath("//*[@id=\'brandBand_2\']/div/div/div[2]/div/div/div[7]/div/span/button[2]");

	private By EnterReqURL = By.xpath("//*[@id=\'input-77\']");

	private By ChangeAuthType = By.xpath("//*[@id=\'1340:0\']");

	private By GetNewTokenAccess = By.xpath("//*[@id=\'Authorization\']/div/div[3]/span/button");

	private By AuthoCheckBox = By.xpath("//*[@id=\'1208:0\']");

	private By RefreshToken = By.xpath("//*[@id=\'1709:0\']"); // dynamic

	private By TokenName = By.xpath("//*[@id=\'input-98\']"); // dynamic

	private By AuthorizationURL = By.xpath("//*[@id=\'input-100\']"); // dynamic

	private By AccessTokenURL = By.xpath("//*[@id=\'input-101\']"); // dynamic

	private By ClientID = By.xpath("//*[@id=\'input-102\']"); // dynamic

	private By ClientSecret = By.xpath("//*[@id='input-103']"); // dynamic

	private By ReqTokenBtn = By
			.xpath("//*[@id=\'Authorization\']/div/div[3]/span/div[2]/div[2]/section/div/footer/div/button[1]"); // dynamic

	private By AvailableToken = By.xpath("//*[@id=\'653:0\']");

	private By AuthTypeForToken = By.xpath("(//*[@class='slds-select'])[2]");

	public loginPage2(WebDriver driver) {

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

			drpAPI = new Select(driver.findElement(By.xpath("//*[@id='1113:0']")));
			drpAPI.selectByValue("REST");

			driver.findElement(nextBtn).click();

		} catch (Exception e) {

			System.out.println("Issue in wizard 1" + e);
		}
	}

	public void wizard_2() {

		try {

			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(Preferred_Interface_Name)).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			driver.findElement(Preferred_Interface_Name).sendKeys("GetOutbound");
			driver.findElement(Preferred_Interface_Name).clear();
			driver.findElement(Preferred_Interface_Name).sendKeys("GetOutbound");

			driver.findElement(AuthoCheckBox).click();
			driver.findElement(AuthoCheckBox).click();
			driver.findElement(AuthoCheckBox).click();

			drpAPI = new Select(driver.findElement(By.xpath("//*[@id=\'1219:0\']")));
			drpAPI.selectByValue("POST");

			driver.findElement(EnterReqURL).sendKeys("http://login.salesforce.com/services/oauth2/authorize");

			drpAPI = new Select(driver.findElement(ChangeAuthType));
			drpAPI.selectByValue("OAuth2.0");

			driver.findElement(GetNewTokenAccess).click();

//			driver.findElement(SaveNext).click();

		} catch (Exception e) {

			System.out.println("Issue in 2nd wizard" + e);

		}
	}

	public void ObtainAccessToken() {

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(RefreshToken)).click();

		driver.findElement(TokenName).sendKeys("Token001");
		drpAPI = new Select(driver.findElement(By.xpath("//*[@id='1728:0']")));
		drpAPI.selectByValue("Authorization_Code");

		driver.findElement(AuthorizationURL).sendKeys("https://login.salesforce.com/services/oauth2/authorize");
		driver.findElement(AccessTokenURL).sendKeys("https://login.salesforce.com/services/oauth2/token");
		driver.findElement(ClientID)
				.sendKeys("3MVG9fe4g9fhX0E4NgJkxKIlg9VN2ee4mYHFiBciZcsk.HBamuwmRnXTDmuj5tJHlV2UACrk8Fj0t4UaZrPvT");
		driver.findElement(ClientSecret).sendKeys("56599EC3DF233F5586013040315987C144A44B5B5E4C6092CD8DC950E5711E0B");

		drpAPI = new Select(driver.findElement(By.xpath("//*[@id='1809:0']")));
		drpAPI.selectByValue("Send Client Credentials in body");

		driver.findElement(ReqTokenBtn).click();

	}

	public void LoginForToken() {

		driver.findElement(txt_username).sendKeys("ankitrawat07@resilient-panda-s7x8ue.com");
		driver.findElement(txt_password).sendKeys("Ankit@1234");
		driver.findElement(btn_login).click();

	}

	public void afterGettingToken() {
		
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AuthTypeForToken)).click();

		if (driver.getTitle().equals("Lightning Experience | Salesforce")) {

		 

			drpAPI = new Select(driver.findElement(AuthTypeForToken));
			drpAPI.selectByValue("OAuth2.0");
			drpAPI = new Select(driver.findElement(By.xpath("//*[@id=\'615:0\']")));
			drpAPI.selectByIndex(1);

		}

		else {

			System.out.println("This is not a Right page.The current page is :" + driver.getCurrentUrl());
		}

	}

	public void tearDown() {

		driver.close();
		driver.quit();
	}

}
