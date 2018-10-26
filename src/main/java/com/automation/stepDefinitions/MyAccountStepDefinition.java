package com.automation.stepDefinitions;

import com.automation.pageObjects.*;
import com.automation.utils.SeleniumUtils;
import cucumber.api.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

public class MyAccountStepDefinition {

    public WebDriver d;

    public MyAccountStepDefinition() {
        d = Hooks.driver;
    }

    @Then("I click My Account")
    public void i_click_myaccount() {
        PageFactory.initElements(d, MyAccount.class);
        SeleniumUtils.clickElement(MyAccount.myaccountElement);
        //assert i am at My Account
        String actualTextmyaccountWelcome = SeleniumUtils.getTextWebElement(MyAccount.myaccountWelcome);
        assert(actualTextmyaccountWelcome.contains("Welcome to your account"));
    }

    @And("I click on \"([^\"]*)\"")
    public void i_click_on(String optionToClick) {
        PageFactory.initElements(d, MyAccount.class);
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
