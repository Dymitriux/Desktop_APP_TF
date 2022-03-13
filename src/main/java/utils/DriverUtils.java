package utils;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class DriverUtils {

    private static WindowsDriver<WindowsElement> windowsDriver = null;
    private static Process p;

    public static WindowsDriver<WindowsElement> getWindowsDriver() {
        if (windowsDriver == null) {
            getWinDriver();
        }
        return windowsDriver;
    }

    private static void getWinDriver() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app", "C:\\Windows\\System32\\notepad.exe");
            capabilities.setCapability("platformName", "windows");

            windowsDriver = new WindowsDriver<>(new URL("http://127.0.0.1:4723"), capabilities);
            windowsDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            windowsDriver.setLogLevel(Level.ALL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void quitWinDriver() {
        if (windowsDriver != null) {
            windowsDriver.quit();
        }
        windowsDriver = null;
    }

    public static void runWinAppDriver() throws IOException {
        String command = "C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver.exe";
        ProcessBuilder builder = new ProcessBuilder(command).inheritIO();
        builder.redirectError(ProcessBuilder.Redirect.DISCARD); /* Discard TBD, need to check WinAppDriver errors */
        builder.redirectOutput(ProcessBuilder.Redirect.DISCARD);
        p = builder.start();
    }

    public static void quitWinAppDriver() {
        if (p != null) {
            p.destroy();
        }
        p = null;
    }
}
