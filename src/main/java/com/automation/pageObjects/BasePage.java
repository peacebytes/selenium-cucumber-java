package com.automation.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class BasePage {
     /*
     * Common WebElements that should be available to all Page Objects
     */

    @FindBy(css="div.header_user_info > a.account")
    public static WebElement accountElement;

    @FindBy(css="div.header_user_info > a.logout")
    public static WebElement logoutElement;

    @FindBy(id="contact-link")
    public static WebElement contactElement;

    @FindBy(css="div.header_user_info > a.login")
    public static WebElement loginElement;

    @FindBy(xpath="//a[@title='Manage my customer account']")
    public static WebElement myaccountElement;

    // BasePage or CommonPage can have elements of headers and footers or common pop-up, alerts, calendar in system
}
