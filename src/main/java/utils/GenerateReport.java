package utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class GenerateReport {
	WebDriver driver;
	public GenerateReport(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public static ExtentReports generateReport() {
		ExtentReports extent =new ExtentReports();
		ExtentSparkReporter sparkreport=new ExtentSparkReporter(System.getProperty("user.dir")+"\\Reports\\generateReport.html");
		sparkreport.config().setReportName("Operation work space Results");
		extent.attachReporter(sparkreport);
		
		return extent;
	}
	
	public void takesScreenshot() throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String filepath = System.getProperty("user.dir")+"\\Reports\\reports.png";
		FileHandler.copy(src, new File(filepath));
		
	}
}
