package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginsuccesspage {
	WebDriver driver;
	public Loginsuccesspage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText="Logout")
	private WebElement Logoutmessage;
	
	public boolean check_Logoutmessage() {
		return Logoutmessage.isDisplayed();
	}
	
}
