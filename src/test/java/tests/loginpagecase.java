package tests;


import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import pages.HeaderOptions;
import pages.LoginPage;
import pages.MyAccountPage;
import utils.CommonUtils;
import utils.MyXLSReader;

public class loginpagecase extends Base{
	HeaderOptions headeroption;
	LoginPage loginpage;
	MyAccountPage myaccountpage;
	@BeforeMethod
	public void setup() {
		driver = openBrowserAndApplicationURL();
	}
	@AfterMethod
	public void teardown() {
		quitBrowser(driver);
	}
	
	@Test(priority=1,dataProvider="Datadump")
	public void logindiffernetCredentials(HashMap<String,String>hmap) {
		headeroption=new HeaderOptions(driver);
		headeroption.clickOnMyAccount();
		loginpage = headeroption.selectLoginOption();
		loginpage.enterEmail(hmap.get("Email"));
		loginpage.enterPassword(hmap.get("Password"));
		myaccountpage = loginpage.clickOnLoginButton();
		String Actualdata="Logout";
		String expecteddata=myaccountpage.LogoutFieldSection();
		Assert.assertEquals(Actualdata,expecteddata);
	}
	
	@DataProvider(name="Datadump")  
	public Object[][] supplydata() {
		Object[][] data=null;
		MyXLSReader reader=null;
		try {
			reader=new MyXLSReader("\\src\\test\\resources\\TutorialsNinjaData.xlsx");
			data = CommonUtils.getTestData(reader, "loginWithValidCredentials", "login");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return data;
		
		
	}
}
