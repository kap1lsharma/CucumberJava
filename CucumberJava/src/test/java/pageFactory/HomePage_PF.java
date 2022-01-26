package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_PF {

	@FindBy(xpath = "//*[@id=\"269:0;p\"]")
	WebElement viewProfile;
	
	@FindBy(tagName = "a[class=\"profile-link-label logout uiOutputURL\"]")
	WebElement LogOut;
	
	WebDriver driver;

	public HomePage_PF(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void checKViewProfileDisplayed() {
		
		
		//These steps are for logout from home page.
//		viewProfile.click();
//		LogOut.click();
	
	}

}
