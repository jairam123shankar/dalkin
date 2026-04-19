package qafoxpage;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Landingpage;
import Pages.Registerpage;
import Pages.Registersuccesspage;
import util.Utilities;
public class register {
	WebDriver driver;
	Properties prop;
	Landingpage landingpage;
	Registerpage registerpage;
	Registersuccesspage registersuccesspage;
	@BeforeMethod
	public void setup(){
		prop=Utilities.propertiescase_file();
		
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("Website"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@AfterMethod
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}
	
	
	@Test(priority=1)
	public void verify_registerpage_withmandatory_fields() {
		landingpage=new Landingpage(driver);
		landingpage.click_My_Account_Drop_menu();
		driver=landingpage.click_Register_option();
		registerpage=new Registerpage(driver);
		registerpage.register_Firstname(prop.getProperty("Firstnameforregister"));
		registerpage.register_Lastname(prop.getProperty("Lastforregister"));
		registerpage.register_EmailSection(Utilities.generate_newemail());
		registerpage.register_Telephonesection(prop.getProperty("Telephoneforregister"));
		registerpage.register_Passwordsection(prop.getProperty("Validpasswordforregister"));
		registerpage.register_Confirmpasswordsection(prop.getProperty("Validpasswordconfirmforregister"));
		registerpage.register_privacypolicy();
		driver=registerpage.register_pagecontinuebutton();
		registersuccesspage=new Registersuccesspage(driver);
		registersuccesspage.registersuccess_RegisterSuccesscontinue();
		registersuccesspage.registersuccess_Successpage_info();
	}
	
	@Test(priority=2)
	public void Registerpage_Providingallthefields() {
		landingpage =new Landingpage(driver);
		landingpage.click_My_Account_Drop_menu();
		driver=landingpage.click_Register_option();
		registerpage=new Registerpage(driver);
		registerpage.register_Firstname(prop.getProperty("Firstnameforregister"));
		registerpage.register_Lastname(prop.getProperty("Lastforregister"));
		registerpage.register_EmailSection(Utilities.generate_newemail());
		registerpage.register_Telephonesection(prop.getProperty("Telephoneforregister"));
		registerpage.register_Passwordsection(prop.getProperty("Validpasswordforregister"));
		registerpage.register_Confirmpasswordsection(prop.getProperty("Validpasswordconfirmforregister"));
		registerpage.register_NewsLetter_subscribe();
		registerpage.register_privacypolicy();
		registerpage.register_pagecontinuebutton();
		registersuccesspage=new Registersuccesspage(driver);
		registersuccesspage.registersuccess_RegisterSuccesscontinue();
		registersuccesspage.registersuccess_Successpage_info();
	}
	@Test(priority=3)
	public void Registerpage_withoutenteringdetails() {
		landingpage=new Landingpage(driver);
		landingpage.click_My_Account_Drop_menu();
		driver=landingpage.click_Register_option();
		registerpage=new Registerpage(driver);
		registerpage.register_Firstname("");
		registerpage.register_Lastname("");
		registerpage.register_EmailSection("");
		registerpage.register_Telephonesection("");
		registerpage.register_Passwordsection("");
		registerpage.register_Confirmpasswordsection("");
		registerpage.register_pagecontinuebutton();
		registerpage.regeisterfailure_firstnamemessage();
	}
}
