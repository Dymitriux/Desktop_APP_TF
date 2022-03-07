package elements;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class Elements {

    public Elements(WindowsDriver<?> windowsDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(windowsDriver, Duration.ofSeconds(2)), this);
    }

    @WindowsFindBy(xpath = ".//MenuItem[@Name='Help']")
    public WindowsElement help;

    @WindowsFindBy(accessibility = "26")
    public WindowsElement timedate;
}
