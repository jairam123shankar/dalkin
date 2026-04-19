package qafoxpage;

import java.io.FileInputStream;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.Landingpage;
import Pages.Loginpage;
import Pages.Loginsuccesspage;
import base.Base;
import util.DataUtil;
import util.MyXLSReader;
import util.Utilities;

public class loginfordatadriven extends Base {
	
	public WebDriver driver;
	FileInputStream fis;
	Utilities ut;
	Landingpage landingpage;
	Loginpage loginpage;
	Loginsuccesspage loginsuccesspage;
	MyXLSReader myxlsread;
	Object[][] data;
	HashMap<String,String> currentdatafromexcel;
	String browse;
	
	/*
	@BeforeMethod
	public void setup(){
		
		String browse=currentdatafromexcel.get("Browser");
		driver=openapplication(browse);
	}*/
	@AfterMethod
	public void teardown() {
		closeapplication();
	}
	
	@Test(dataProvider="supplydata")
	public void loginusing_validcredentials(HashMap<String,String>h1) {
		currentdatafromexcel=h1;
		browse=currentdatafromexcel.get("Browser");
		driver=openapplication(browse);
		landingpage=new Landingpage(driver);
		landingpage.click_My_Account_Drop_menu();
		driver=landingpage.click_Login_option();
		loginpage=new Loginpage(driver);
		loginpage.send_validUsername_email(h1.get("Username"));
		loginpage.send_validUsername_password(h1.get("Password"));
		driver=loginpage.click_Login_button();
		loginsuccesspage=new Loginsuccesspage(driver);
		loginsuccesspage.check_Logoutmessage();
	}
	
	@DataProvider
	public Object[][] supplydata() {
		String filepath=System.getProperty("user.dir")+"\\src\\test\\resources\\\\Tutorialsninjaupdate.xlsx";
		try {
			myxlsread=new MyXLSReader(filepath);
			data = DataUtil.getTestData(myxlsread, "LoginTest", "Data");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}
