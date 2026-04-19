package qafoxpage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Landingpage;
import Pages.Loginpage;
import Pages.Loginsuccesspage;
import util.Utilities;

public class login {
	public WebDriver driver;
	FileInputStream fis;
	Properties prop;
	Utilities ut;
	Landingpage landingpage;
	Loginpage loginpage;
	Loginsuccesspage loginsuccesspage;
	@BeforeMethod
	public void setup() throws IOException {
		prop=Utilities.propertiescase_file();
		String browser ="edge";
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();	
		}else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}else if(browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}
		driver.manage().window().maximize();
		driver.get(prop.getProperty("Website"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@AfterMethod
	public void teardown() {
		if(driver!=null) {
			driver.quit();
		}
	}
	
	@Test(priority=1)
	public void loginusing_validcredentials() {
		landingpage=new Landingpage(driver);
		landingpage.click_My_Account_Drop_menu();
		driver=landingpage.click_Login_option();
		loginpage=new Loginpage(driver);
		loginpage.send_validUsername_email(prop.getProperty("Login_validusername"));
		loginpage.send_validUsername_password(prop.getProperty("Login_validpassword"));
		driver=loginpage.click_Login_button();
		loginsuccesspage=new Loginsuccesspage(driver);
		loginsuccesspage.check_Logoutmessage();
	}
	@Test(priority=2)
	public void loginusing_validemailinvalidpassword() {
		landingpage=new Landingpage(driver);
		landingpage.click_My_Account_Drop_menu();
		driver=landingpage.click_Login_option();
		loginpage=new Loginpage(driver);
		loginpage.send_validUsername_email(prop.getProperty("Login_validusername"));
		loginpage.send_validUsername_password(prop.getProperty("Login_invalidpassword"));
		loginpage.click_Login_button();
		loginpage.login_failuremessage();
	}
	@Test(priority=3)
	public void withoutentering_Details() {
		landingpage=new Landingpage(driver);
		landingpage.click_My_Account_Drop_menu();
		driver=landingpage.click_Login_option();
		loginpage=new Loginpage(driver);
		loginpage.send_validUsername_email("");
		loginpage.send_validUsername_password("");
		loginpage.click_Login_button();
		loginpage.login_failuremessage();
	}
}
