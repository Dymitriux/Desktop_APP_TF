package configuration;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = "pretty",
        features = {"features"},
        glue = {"steps"}
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

}
