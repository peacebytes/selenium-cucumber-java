package com.shopback;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        format ={"pretty",
                "html:target/cucumber/cucumber.html", "json:target/cucumber/cucumber.json"},
        glue = "com.shopback.stepDefinitions",
        strict = true)
public class RunCukeTest {
}
