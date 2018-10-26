package com.automation.stepDefinitions;

import static org.testng.AssertJUnit.*;
import com.automation.pageObjects.*;
import cucumber.api.java.en.*;
import org.openqa.selenium.WebElement;
import com.automation.utils.SeleniumUtils;

public class LoginStepDefinition {

    @Given("I have logged into Automation Practice")
    public void loginAutomationPractice() {
        SeleniumUtils.navigateToURL(Hooks.url);
        SeleniumUtils.clickElement(LoginPage.loginElement);
        LoginPage.login(Hooks.email, Hooks.password);
        //assert log in was successful
        String actualTextaccount= SeleniumUtils.getTextWebElement(LoginPage.accountElement);
        assertEquals(actualTextaccount, "automation test");
    }

    @Then("I log out Automation Practice")
    public void i_log_out_Automation_Practice() {
        SeleniumUtils.clickElement(LoginPage.logoutElement);
        //assert log out was successful
        String actualTextalreadyRegistered = SeleniumUtils.getTextWebElement(LoginPage.alreadyRegistered);
        assertEquals(actualTextalreadyRegistered, "ALREADY REGISTERED?");
    }
}
