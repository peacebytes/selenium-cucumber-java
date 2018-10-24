package com.automation.pageObjects;

import org.openqa.selenium.WebElement;
import com.automation.utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.lang.String;

public class MyAccount extends BasePage {

    public MyAccount(WebDriver driver){
        super(driver);
    }

    @FindBy(how=How.CSS, using="p.info-account")
    public static WebElement myaccountWelcome;

    @FindBy(how=How.CSS, using="ul.myaccount-link-list > li")
    public static List<WebElement> myaccountLinkList;

    @FindBy(how=How.CSS, using="h1")
    public static WebElement pageHeader;
}
