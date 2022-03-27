package steps;

import elements.Elements;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import utils.DriverUtils;
import utils.LoggingUtils;

import java.time.LocalDate;

public class Steps {

    protected static Logger logger;
    private static WindowsDriver<WindowsElement> windowsDriver;
    Elements e;

    public Steps() {
        logger = LoggingUtils.getLogger();
        windowsDriver = DriverUtils.getWindowsDriver();
        e = new Elements(windowsDriver);
    }

    @Given("user open Notepad application")
    public void userOpenNotepadApplication() {
        String title = windowsDriver.getTitle();
        Assert.assertTrue(title.toLowerCase().contains("notepad"));
        logger.info("Notepad is open.");
    }

    @And("user open Help menu item")
    public void userOpenHelpMenuItem() {
        e.help.click();
    }

    @And("and press About Notepad")
    public void andPressAboutNotepad() {
        windowsDriver.findElementByName("About Notepad").click();
    }

    @And("press OK button")
    public void pressOKButton() {
        windowsDriver.findElementByName("OK").click();
    }

    @And("user type current date")
    public void userTypeCurrentDate() {
        LocalDate date = LocalDate.now();
        windowsDriver.findElementByClassName("Edit").sendKeys(date.toString());
    }

    @And("user Clear the results")
    public void userClearTheResults() {
        windowsDriver.findElementByClassName("Edit").clear();
    }

    @And("user open Edit menu item")
    public void userOpenEditMenuItem() {
        windowsDriver.findElementByName("Edit").click();
    }

    @And("press TimeDate in dropdown menu")
    public void pressTimeDateInDropdownMenu() {
        e.timedate.click();
    }

    @And("Confirm that the test is displayed in Notepad")
    public void confirmThatTheTestIsDisplayedInNotepad() {
        Assert.assertNotNull(windowsDriver.findElementByClassName("Edit"));
        windowsDriver.findElementByClassName("Edit").clear();
    }
}
