package com.automation.pageObjects;

import org.openqa.selenium.WebElement;
import com.automation.utils.SeleniumUtils;

public class LoginPage extends BasePage {

    public static WebElement loginEmailField = SeleniumUtils.getWebElement("id", "email");
    public static WebElement loginPasswordField = SeleniumUtils.getWebElement("id", "passwd");
    public static WebElement buttonToLogin = SeleniumUtils.getWebElement("id", "SubmitLogin");
    public static WebElement alreadyRegistered() {return SeleniumUtils.getWebElement("css", "#login_form > h3.page-subheading");}

    public static void login(String email, String password) {
        SeleniumUtils.enterText(loginEmailField, email);
        SeleniumUtils.enterText(loginPasswordField, password);
        SeleniumUtils.clickElement(buttonToLogin);
    }


}
