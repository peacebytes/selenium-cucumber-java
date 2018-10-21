package com.automation.stepDefinitions;

import com.automation.pageObjects.LoginPage;
import com.automation.utils.SeleniumUtils;
import cucumber.api.java.en.Given;

public class LoginStepDefinition {

    @Given("I have logged into Automation Practice")
    public void loginAutomationPractice() {
        LoginPage.navigateToPage(Hooks.url);
        SeleniumUtils.clickElement(LoginPage.login());
        LoginPage.login(Hooks.email, Hooks.password);
    }
}
