package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Landingpage {
	WebDriver driver;
	public Landingpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@title='My Account']")
	private WebElement My_Account_Drop_menu;
	
	@FindBy(linkText="Login")
	private WebElement Login_option;
	
	@FindBy(linkText="Register")
	private WebElement Register_option; 
	
	public void click_My_Account_Drop_menu() {
		My_Account_Drop_menu.click();
	}
	
	public WebDriver click_Login_option() {
		Login_option.click();
		return driver;
	}
	
	public WebDriver click_Register_option() {
		Register_option.click();
		return driver;
	}

}
