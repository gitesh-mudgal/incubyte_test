package runner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "features",
        glue = "stepDefinitions",
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"},
        monochrome = true
)
public class TestRunner {
}
