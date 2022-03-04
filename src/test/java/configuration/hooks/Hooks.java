package configuration.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.Logger;
import utils.LoggingUtils;
import utils.WebDriverUtils;

public class Hooks {

    protected static Logger logger = LoggingUtils.getLogger();

    @BeforeAll
    public static void setUpBeforeAll() {
        logger.info("Before all set up method.");
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {
        logger.info("Set up method.");
    }

    @After
    public void tearDown() {
        WebDriverUtils.quitDriver();
        logger.info("Tear down method.");
    }
}
