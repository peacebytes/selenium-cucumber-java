package com.automation.stepDefinitions;

import static com.automation.utils.ElementUtils.*;
import com.automation.pageObjects.*;
import cucumber.api.java.en.*;
import org.openqa.selenium.WebElement;

public class MyAccountStepDefinition {

    @Then("I click My Account")
    public void i_click_myaccount() {
        clickElement(MyAccount.myaccountElement);
        //assert i am at My Account
        String actualTextmyaccountWelcome = getTextWebElement(MyAccount.myaccountWelcome);
        assert(actualTextmyaccountWelcome.contains("Welcome to your account"));
    }

    @And("I click on \"([^\"]*)\"")
    public void i_click_on(String optionToClick) {
        for (WebElement webEle : MyAccount.myaccountLinkList) {
            if (getTextWebElement(webEle).toLowerCase().equals(optionToClick.toLowerCase())) {
                clickElement(webEle);
                break;
            }
        }
        //assert i clicked on expected option successfully
        assert(optionToClick.toLowerCase().contains(getTextWebElement(MyAccount.pageHeader).toLowerCase()));
    }
}
