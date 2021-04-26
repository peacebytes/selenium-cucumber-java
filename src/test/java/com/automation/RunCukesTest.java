package com.automation;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features/*.feature",
        glue = "com.automation.stepDefinitions",
        tags = {"not @skip"},
        strict = true,
        plugin = {"pretty", "com.epam.reportportal.cucumber.ScenarioReporter"}
)
public class RunCukesTest {
}
