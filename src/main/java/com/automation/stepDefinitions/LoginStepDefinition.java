package com.automation.stepDefinitions;

import static org.testng.AssertJUnit.*;
import com.automation.pageObjects.*;
import cucumber.api.java.en.*;
import com.automation.env.Global;

public class LoginStepDefinition extends utils {

    @Given("I have logged into Automation Practice")
    public void loginAutomationPractice() {
        LoginPage.login(Global.email, Global.password);
        //assert log in was successful
        String actualTextaccount= getTextWebElement(LoginPage.accountElement);

        System.out.println("actualTextaccount:");
        System.out.println(actualTextaccount);
        assertEquals("automation qa", actualTextaccount.toLowerCase());
    }

    @Then("I log out Automation Practice")
    public void i_log_out_Automation_Practice() {
        LoginPage.logout();
        //assert log out was successful
        String actualTextalreadyRegistered = getTextWebElement(LoginPage.alreadyRegistered);
        assertEquals(actualTextalreadyRegistered, "ALREADY REGISTERED?");
    }
}
