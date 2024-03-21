package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "Features/Customers.feature",
        tags = "@regression",
        glue = {"stepDefinitions"},
        monochrome = true,
        dryRun = false,
        plugin = {
                "pretty",
                "html:test-output"
        }
)



public class TestRunner {
}
