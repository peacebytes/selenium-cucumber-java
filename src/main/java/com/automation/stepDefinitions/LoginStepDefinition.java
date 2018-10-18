package com.automation.stepDefinitions;

import com.automation.pageObjects.LoginPage;
import cucumber.api.java.en.Given;

public class LoginStepDefinition {

    @Given("I have logged into Automation Practice")
    public void loginAutomationPractice() {
        LoginPage.navigateToPage(Hooks.url);
        LoginPage.login(Hooks.email, Hooks.password);
    }
}
