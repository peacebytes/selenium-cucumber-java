package com.shopback.stepDefinitions;

import com.shopback.pageObjects.BasePage;
import com.shopback.pageObjects.LoginPage;
import cucumber.api.java.en.Given;

public class LoginStepDefinition {

    @Given("I have logged into Automation Practice")
    public void loginAutomationPractice() {
        BasePage.navigateToLoginPage();
        LoginPage.login(Hooks.email, Hooks.password);
    }
}
