package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registerpage {
	WebDriver driver;
	public Registerpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement Firstname;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement Lastname;
	
	@FindBy(xpath="//div[@class='text-danger'][text()='First Name must be between 1 and 32 characters!']")
	private WebElement firstsection_name;
	
	public boolean regeisterfailure_firstnamemessage() {
		return firstsection_name.isDisplayed();
	}
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement EmailSection;
	
	@FindBy(xpath="//input[@name='telephone']")
	private WebElement Telephonesection;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement Passwordsection;
	
	@FindBy(xpath="//input[@name='confirm']")
	private WebElement Confirmpasswordsection;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement NewsLetter_subscribe;
	
	public void register_NewsLetter_subscribe() {
		NewsLetter_subscribe.click();
	}
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement Privacypolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement Registerpagecontinuebutton;
	
	public WebDriver register_pagecontinuebutton() {
		Registerpagecontinuebutton.click();
		return driver;
	}
	
	public void register_privacypolicy() {
		Privacypolicy.click();
	}
	
	public void register_Confirmpasswordsection(String confirmpassword) {
		Confirmpasswordsection.sendKeys(confirmpassword);
	}
	
	public void register_Passwordsection(String password) {
		Passwordsection.sendKeys(password);
	}
	
	public void register_Telephonesection(String telephone) {
		Telephonesection.sendKeys(telephone);
	}
	
	public void register_EmailSection(String Email) {
		EmailSection.sendKeys(Email);
	}
	
	public void register_Lastname(String lname) {
		Lastname.sendKeys(lname);
	}
	
	public void register_Firstname(String fname) {
		Firstname.sendKeys(fname);
	}
}
