package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.WebDriverUtils;

public abstract class PageInit {

    protected static WebDriver driver;

    public PageInit() {
        driver = WebDriverUtils.getWebDriver();
        PageFactory.initElements(driver, this);
    }
}
