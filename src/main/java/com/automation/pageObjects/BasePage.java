package com.automation.pageObjects;

import org.openqa.selenium.WebElement;
import com.automation.stepDefinitions.Hooks;
import com.automation.utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public static WebDriver driver;
    public static boolean bResult;

    public  BasePage(WebDriver driver){
        BasePage.driver = driver;
        BasePage.bResult = true;
    }

     /*
     * Common WebElements that should be available to all Page Objects
     */

    @FindBy(how=How.CSS, using="div.header_user_info > a.account")
    public static WebElement accountElement;

    @FindBy(how=How.CSS, using="div.header_user_info > a.logout")
    public static WebElement logoutElement;

    @FindBy(how=How.ID, using="contact-link")
    public static WebElement contactElement;

    @FindBy(how=How.CSS, using="div.header_user_info > a.login")
    public static WebElement loginElement;

    @FindBy(how=How.XPATH, using="//a[@title='Manage my customer account']")
    public static WebElement myaccountElement;
}
