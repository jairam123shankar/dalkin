package listeners;

import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * TestNG listener that captures a screenshot when a test fails.
 *
 * How it finds the driver:
 * - It attempts to reflectively read a field named `driver` from the test instance.
 * - The test classes should declare a field like: `protected WebDriver driver;`
 */
public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object testInstance = result.getInstance();
        if (testInstance == null) return;

        try {
            Field f = testInstance.getClass().getDeclaredField("driver");
            f.setAccessible(true);
            Object drv = f.get(testInstance);
            if (drv instanceof WebDriver) {
                WebDriver driver = (WebDriver) drv;
                String path = utils.ScreenshotUtils.takeScreenshot(driver, result.getName());
                System.out.println("Screenshot saved to: " + path);
            } else {
                System.out.println("Field 'driver' exists but is not a WebDriver");
            }
        } catch (NoSuchFieldException nsf) {
            System.out.println("No 'driver' field found on test class: " + testInstance.getClass().getName());
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    @Override public void onTestStart(ITestResult result) {}
    @Override public void onTestSuccess(ITestResult result) {}
    @Override public void onTestSkipped(ITestResult result) {}
    @Override public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
    @Override public void onStart(ITestContext context) {}
    @Override public void onFinish(ITestContext context) {}

}
