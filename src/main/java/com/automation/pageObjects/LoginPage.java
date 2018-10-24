package com.automation.pageObjects;

import org.openqa.selenium.WebElement;
import com.automation.utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(how=How.ID, using="email")
    public static WebElement loginEmailField;

    @FindBy(how=How.ID, using="passwd")
    public static WebElement loginPasswordField;

    @FindBy(how=How.ID, using="SubmitLogin")
    public static WebElement buttonToLogin;

    @FindBy(how=How.CSS, using="#login_form > h3.page-subheading")
    public static WebElement alreadyRegistered;

    public static void login(String email, String password) {
        SeleniumUtils.enterText(loginEmailField, email);
        SeleniumUtils.enterText(loginPasswordField, password);
        SeleniumUtils.clickElement(buttonToLogin);
    }

}
