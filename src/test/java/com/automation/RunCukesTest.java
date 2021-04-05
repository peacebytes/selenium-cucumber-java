package com.automation;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features/Demo1.feature",
        glue = "com.automation.stepDefinitions",
        tags = {"not @skip"},
        strict = true,
        plugin = {"pretty", "com.epam.reportportal.cucumber.StepReporter"}
)
public class RunCukesTest {
}
