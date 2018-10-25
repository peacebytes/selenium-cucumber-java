package com.automation.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.automation.utils.SeleniumUtils;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id="email")
    public static WebElement loginEmailField;

    @FindBy(id="passwd")
    public static WebElement loginPasswordField;

    @FindBy(id="SubmitLogin")
    public static WebElement buttonToLogin;

    @FindBy(css="#login_form > h3.page-subheading")
    public static WebElement alreadyRegistered;

    public static void login(String email, String password) {
        SeleniumUtils.enterText(loginEmailField, email);
        SeleniumUtils.enterText(loginPasswordField, password);
        SeleniumUtils.clickElement(buttonToLogin);
    }

}
