package com.automation.stepDefinitions;

import static org.testng.AssertJUnit.*;
import com.automation.pageObjects.*;
import cucumber.api.java.en.*;

public class CommonStepDefinition extends utils {

    @Then("^I should \"([^\"]*)\" \"([^\"]*)\" button$")
    public void i_should_button(String arg1, String arg2) throws Throwable {
        if (arg1.equals("not see")) {
          boolean actualFlag = confirmWebElementInvisibled(LoginPage.loginElement);
          System.out.println("actualFlag: " + actualFlag);
          assertEquals(actualFlag, true);
        } else {
          boolean actualFlag = confirmWebElementVisibled(LoginPage.logoutElement);
          System.out.println("actualFlag: " + actualFlag);
          assertEquals(actualFlag, true);
        }

    }

}
