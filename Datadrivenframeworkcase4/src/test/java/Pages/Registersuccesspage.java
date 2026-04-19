package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registersuccesspage {
	
	WebDriver driver;
	public Registersuccesspage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="Continue")
	private WebElement RegisterSuccesscontinue;
	
	@FindBy(linkText="Edit your account information")
	private WebElement Successpage_info;
	
	public boolean registersuccess_Successpage_info() {
		return Successpage_info.isDisplayed();
	}
	
	public void registersuccess_RegisterSuccesscontinue() {
		RegisterSuccesscontinue.click();
	}
}
