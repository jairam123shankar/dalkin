package utils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * Utility to capture screenshots from a WebDriver instance (test-scope).
 */
public class ScreenshotUtils {

    /**
     * Takes a screenshot and writes it to the project "Screenshots" folder.
     * @param driver WebDriver instance
     * @param name short name to include in file name (e.g. test method name)
     * @return absolute path to saved screenshot or null on error
     */
    public static String takeScreenshot(WebDriver driver, String name) {
        if (driver == null) return null;
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);

            String dir = System.getProperty("user.dir") + File.separator + "Screenshots";
            Files.createDirectories(Paths.get(dir));

            String safeName = (name == null || name.isEmpty()) ? "screenshot" : name.replaceAll("[^a-zA-Z0-9-_\\.]+", "_");
            String destPath = dir + File.separator + System.currentTimeMillis() + "_" + safeName + ".png";

            Files.copy(src.toPath(), Paths.get(destPath), StandardCopyOption.REPLACE_EXISTING);
            return destPath;
        } catch (Throwable t) {
            t.printStackTrace();
            return null;
        }
    }

}
