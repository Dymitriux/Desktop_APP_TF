package configuration;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = "pretty",
        features = {"src/test/resources/features"},
        glue = {"steps", "configuration.hooks"}
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

}
