package base;

import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import util.DataUtil;
import util.Utilities;

public class Base {
	public Properties prop;
	WebDriver driver;
	HashMap<String,String>h1;
	public Base() {
		prop=Utilities.propertiescase_file();
	}
	
	public WebDriver openapplication(String browser) {
		//String browser=prop.getProperty("driverlink");
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")){
			driver=new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get(prop.getProperty("Website"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	public void closeapplication() {
		if(driver!=null) {
			driver.quit();
		}
	}
}
