package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	WebDriver driver;
	public Loginpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement Username_email;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement Username_password;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement Login_button;
	
	@FindBy(xpath="//i[@class='fa fa-exclamation-circle']")
	private WebElement Login_failure_information;
	
	public boolean login_failuremessage() {
		return Login_failure_information.isDisplayed();
	}
	
	public WebDriver click_Login_button() {
		Login_button.click();
		return driver;
	}
	
	public void send_validUsername_password(String password) {
		Username_password.sendKeys(password);
	}
	
	public void send_validUsername_email(String Emailfield) {
		Username_email.sendKeys(Emailfield);
	}
}
