package com.automation.stepDefinitions;

import com.automation.pageObjects.BasePage;
import com.automation.pageObjects.LoginPage;
import cucumber.api.java.en.Given;

public class LoginStepDefinition {

    @Given("I have logged into Automation Practice")
    public void loginAutomationPractice() {
        BasePage.navigateToLoginPage();
        LoginPage.login(Hooks.email, Hooks.password);
    }
}
