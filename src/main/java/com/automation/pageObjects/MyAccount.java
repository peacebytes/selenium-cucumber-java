package com.automation.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class MyAccount extends BasePage {

    @FindBy(css="p.info-account")
    public static WebElement myaccountWelcome;

    @FindBy(css="ul.myaccount-link-list > li")
    public static List<WebElement> myaccountLinkList;

    @FindBy(css="h1")
    public static WebElement pageHeader;
}
