package qafoxpage;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.Landingpage;
import Pages.Registerpage;
import Pages.Registersuccesspage;
import base.Base;
import util.DataUtil;
import util.MyXLSReader;
import util.Utilities;

public class registerfordatadriven extends Base{
	WebDriver driver;
	Landingpage landingpage;
	Registerpage registerpage;
	Registersuccesspage registersuccesspage;
	MyXLSReader myxlreader;
	Object[][] data;
	HashMap<String, String> registerdatacase;
	String browse;
	@AfterMethod
	public void tearDown() {
		closeapplication();
	}
	
	
	@Test(dataProvider="supply_data")
	public void verify_registerpage_withmandatory_fields(HashMap<String,String>h1) {
		registerdatacase=h1;
		browse = registerdatacase.get("Browser");
		driver=openapplication(browse);
		landingpage=new Landingpage(driver);
		landingpage.click_My_Account_Drop_menu();
		driver=landingpage.click_Register_option();
		registerpage=new Registerpage(driver);
		registerpage.register_Firstname(h1.get("FirstName"));
		registerpage.register_Lastname(h1.get("LastName"));
		registerpage.register_EmailSection(Utilities.generate_newemail());
		registerpage.register_Telephonesection(h1.get("Telephone"));
		registerpage.register_Passwordsection(h1.get("Password"));
		registerpage.register_Confirmpasswordsection(h1.get("PasswordConfirm"));
		registerpage.register_privacypolicy();
		driver=registerpage.register_pagecontinuebutton();
		registersuccesspage=new Registersuccesspage(driver);
		registersuccesspage.registersuccess_RegisterSuccesscontinue();
		registersuccesspage.registersuccess_Successpage_info();
	}
	
	@DataProvider
	public Object[][] supply_data() {
		String filepath=System.getProperty("user.dir")+"\\src\\test\\resources\\Tutorialsninjaupdate1.xlsx";
		
		try {
			myxlreader=new MyXLSReader(filepath);
			data = DataUtil.getTestData(myxlreader, "RegisterTest", "Data");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}
