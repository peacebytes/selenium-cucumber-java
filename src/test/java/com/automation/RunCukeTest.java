package com.automation;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features/Demo1.feature",
        // plugin = {"pretty", "com.epam.reportportal.cucumber.ScenarioReporter"},
        glue = "com.automation.stepDefinitions",
        tags = {"~@skip"},
        strict = true)
public class RunCukeTest {
}
