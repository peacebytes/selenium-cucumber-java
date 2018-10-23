package com.automation.stepDefinitions;

import static org.testng.AssertJUnit.*;
import com.automation.pageObjects.*;
import com.automation.utils.SeleniumUtils;
import cucumber.api.java.en.*;

public class LoginStepDefinition {

    @Given("I have logged into Automation Practice")
    public void loginAutomationPractice() {
        LoginPage.navigateToPage(Hooks.url);
        SeleniumUtils.clickElement(LoginPage.login());
        LoginPage.login(Hooks.email, Hooks.password);
        //assert log in was successful
        SeleniumUtils.waitWebElement(BasePage.account());
        String actualTextaccount= BasePage.account().getText();
        assertEquals(actualTextaccount, "automation test");
    }

    @Then("I log out Automation Practice")
    public void i_log_out_Automation_Practice() {
        SeleniumUtils.clickElement(BasePage.logout());
        //assert log out was successful
        SeleniumUtils.waitWebElement(LoginPage.alreadyRegistered());
        String actualTextforgotPassword = LoginPage.alreadyRegistered().getText();
        assertEquals(actualTextforgotPassword, "ALREADY REGISTERED?");
    }
}
