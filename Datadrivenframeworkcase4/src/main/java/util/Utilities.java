package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {
	
	public static String generate_newemail() {
		Date date=new Date();
		String Emailfield="Ramesh"+date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
		return Emailfield;
	}
	
	public static Properties propertiescase_file() {
		FileInputStream fis;
		Properties prop;
		prop=new Properties();
		String filepath=System.getProperty("user.dir")+"\\Projectdata.properties";
		try {
			fis=new FileInputStream(filepath);
			prop.load(fis);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return prop;
		
	}
	
	public static String takeScreenshot(WebDriver driver,String testName) {
		
		TakesScreenshot tsDriver = (TakesScreenshot)driver;
		File screenshotFile = tsDriver.getScreenshotAs(OutputType.FILE);
		
		String screenshotFilePath = null;
		
		try {
			Properties prop = Utilities.propertiescase_file();
			screenshotFilePath = System.getProperty("user.dir")+prop.getProperty("screenshotsPath")+testName+".png";
			FileHandler.copy(screenshotFile,new File(screenshotFilePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return screenshotFilePath;
		
	}
	
	
}
