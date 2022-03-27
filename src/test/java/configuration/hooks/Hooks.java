package configuration.hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.apache.logging.log4j.Logger;
import utils.LoggingUtils;
import utils.DriverUtils;

import java.io.IOException;

public class Hooks {

    protected static Logger logger = LoggingUtils.getLogger();

    @BeforeAll
    public static void setUpBeforeAll() throws IOException {
        logger.info("Before all set up method.");
        DriverUtils.runWinAppDriver();
    }

    @Before
    public void setUp() {
        logger.info("Set up method.");
    }

    @After
    public void tearDown() {
        logger.info("Tear down method.");
        DriverUtils.quitWinDriver();
    }

    @AfterAll
    public static void tearDownAfterAll() {
        logger.info("After all tear down method.");
        DriverUtils.quitWinAppDriver();
    }
}
