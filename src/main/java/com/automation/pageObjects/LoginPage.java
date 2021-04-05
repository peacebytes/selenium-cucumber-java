package com.automation.pageObjects;

import static com.automation.utils.ElementUtils.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id="email")
    public static WebElement loginEmailField;

    @FindBy(id="passwd")
    public static WebElement loginPasswordField;

    @FindBy(id="SubmitLogin")
    public static WebElement buttonToLogin;

    @FindBy(css="#login_form > h3.page-subheading")
    public static WebElement alreadyRegistered;

    public static void login(String email, String password) {
        clickElement(loginElement);
        enterText(loginEmailField, email);
        enterText(loginPasswordField, password);
        clickElement(buttonToLogin);
    }

    public static void logout() {
        clickElement(logoutElement);
    }
}
