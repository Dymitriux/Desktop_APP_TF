package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverUtils {

    private static WebDriver driver;

    public static WebDriver getWebDriver() {
        if (driver == null) {
            getChromeDriver();
        }
        return driver;
    }

    private static void getChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-popup-blocking", "--start-maximized");
        driver = new ChromeDriver(options);
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
        driver = null;
    }
}
