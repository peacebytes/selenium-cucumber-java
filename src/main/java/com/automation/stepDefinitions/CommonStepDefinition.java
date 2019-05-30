package com.automation.stepDefinitions;

import static org.testng.AssertJUnit.*;
import com.automation.pageObjects.*;
import cucumber.api.java.en.*;
import com.automation.utils.SeleniumUtils;

public class CommonStepDefinition {

    @Then("^I should \"([^\"]*)\" \"([^\"]*)\" button$")
    public void i_should_button(String arg1, String arg2) throws Throwable {
        if (arg1.equals("not see")) {
          boolean actualFlag = SeleniumUtils.confirmWebElementInvisibled(LoginPage.loginElement);
          System.out.println("actualFlag: " + actualFlag);
          assertEquals(actualFlag, true);
        } else {
          boolean actualFlag = SeleniumUtils.confirmWebElementVisibled(LoginPage.logoutElement);
          System.out.println("actualFlag: " + actualFlag);
          assertEquals(actualFlag, true);
        }

    }

}
