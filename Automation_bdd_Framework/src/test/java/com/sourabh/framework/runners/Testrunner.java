package com.sourabh.framework.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"com.sourabh.framework.stepdefs", "com.sourabh.framework.hooks"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/Cucumber.html",
                "json:target/cucumber.json",
                "timeline:target/test-output-thread/"
        },
        monochrome = true
)

public class Testrunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
