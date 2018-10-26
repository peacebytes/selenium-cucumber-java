package com.automation.stepDefinitions;

import static org.testng.AssertJUnit.*;
import com.automation.pageObjects.*;
import cucumber.api.java.en.*;
import org.openqa.selenium.WebElement;
import com.automation.utils.SeleniumUtils;

public class MyAccountStepDefinition {

    @Then("I click My Account")
    public void i_click_myaccount() {
        SeleniumUtils.clickElement(MyAccount.myaccountElement);
        //assert i am at My Account
        String actualTextmyaccountWelcome = SeleniumUtils.getTextWebElement(MyAccount.myaccountWelcome);
        assert(actualTextmyaccountWelcome.contains("Welcome to your account"));
    }

    @And("I click on \"([^\"]*)\"")
    public void i_click_on(String optionToClick) {
        for (WebElement webEle : MyAccount.myaccountLinkList) {
            if (SeleniumUtils.getTextWebElement(webEle).toLowerCase().equals(optionToClick.toLowerCase())) {
                SeleniumUtils.clickElement(webEle);
                break;
            }
        }
        //assert i clicked on expected option successfully
        assert(optionToClick.toLowerCase().contains(SeleniumUtils.getTextWebElement(MyAccount.pageHeader).toLowerCase()));
    }
}
