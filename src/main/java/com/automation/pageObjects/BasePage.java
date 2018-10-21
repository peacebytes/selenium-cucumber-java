package com.automation.pageObjects;

import org.openqa.selenium.WebElement;
import com.automation.stepDefinitions.Hooks;
import com.automation.utils.SeleniumUtils;

public class BasePage {

    /*
    * Common WebElements that should be available to all Page Objects
    * These WebElements are not always ready so they should be returned per request.
    */
    public static WebElement account() {return SeleniumUtils.getWebElement("css", "div.header_user_info > a.account");}
    public static WebElement logout() {return SeleniumUtils.getWebElement("css", "div.header_user_info > a.logout");}
    public static WebElement contact() {return SeleniumUtils.getWebElement("id", "contact-link");}
    public static WebElement login() {return SeleniumUtils.getWebElement("css", "div.header_user_info > a.login");}

    public static void navigateToPage(String expectedUrl) {
        SeleniumUtils.navigateToURL(expectedUrl);
        try {
            Thread.sleep(500);
        } catch (Exception e) {}
    }
}
