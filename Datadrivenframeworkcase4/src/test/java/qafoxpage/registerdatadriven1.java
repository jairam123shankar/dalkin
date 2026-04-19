package qafoxpage;

import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.Landingpage;
import Pages.Registerpage;
import Pages.Registersuccesspage;
import util.DataUtil;
import util.MyXLSReader;
import util.Utilities;

public class registerdatadriven1 {
	public WebDriver driver;
	Properties prop;
	Landingpage landingpage;
	Registerpage registerpage;
	Registersuccesspage registersuccesspage;
	MyXLSReader myxlsreader;
	Object[][] data;
	String browser;
	@Test(dataProvider="supplydata")
	public void case1(HashMap<String,String>h1) {
		if(!DataUtil.isRunnable(myxlsreader, "RegisterTest", "Testcases") || h1.get("Runmode").equals("N")) {
			throw new SkipException("We can't able to run the file as the run mode is N");
		}
		prop=Utilities.propertiescase_file();
		
		browser=h1.get("Browser");
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("edge")){
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get(prop.getProperty("Website"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		landingpage = new Landingpage(driver);
		landingpage.click_My_Account_Drop_menu();
		driver=landingpage.click_Register_option();
		registerpage = new Registerpage(driver);
		registerpage.register_Firstname(h1.get("FirstName"));
		registerpage.register_Lastname(h1.get("LastName"));
		registerpage.register_EmailSection(Utilities.generate_newemail());
		registerpage.register_Telephonesection(h1.get("Telephone"));
		registerpage.register_Passwordsection(h1.get("Password"));
		registerpage.register_Confirmpasswordsection(h1.get("PasswordConfirm"));
		registerpage.register_privacypolicy();
		driver=registerpage.register_pagecontinuebutton();
		registersuccesspage = new Registersuccesspage(driver);
		registersuccesspage.registersuccess_RegisterSuccesscontinue();
		registersuccesspage.registersuccess_Successpage_info();
		driver.quit();
	}
	
	@DataProvider
	public Object[][] supplydata() {
		String filepath=System.getProperty("user.dir")+"\\src\\test\\resources\\Tutorialsninjaupdate1.xlsx";
		try {
			myxlsreader=new MyXLSReader(filepath);
			data = DataUtil.getTestData(myxlsreader, "RegisterTest", "Data");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return data;
		
		
	}
}
