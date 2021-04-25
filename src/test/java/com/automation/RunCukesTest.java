package com.automation;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features/Smoketest.feature",
        glue = "com.automation.stepDefinitions",
        tags = {"not @skip"},
        strict = true,
        plugin = {"pretty", "com.epam.reportportal.cucumber.StepReporter"}
)
class RunCukesTest {
}
