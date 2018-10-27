package com.automation.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import com.automation.pageObjects.BasePage;
import com.automation.stepDefinitions.Hooks;

public class SeleniumUtils extends BasePage {

    private static WebDriver d;

    public SeleniumUtils(WebDriver driver){
        super(driver);
        d = driver;
    }

    public static void navigateToURL(String url) {
        d.get(url);
    }

    public static void enterText(WebElement webElement, String textValue) {
        waitWebElementClickable(webElement).clear();
        webElement.sendKeys(textValue);
    }

    public static void clickElement(WebElement webElement) {
        waitWebElementClickable(webElement).click();
    }

    /*
    * Pay extra careful to use this. Should be sure the form contains webElement is loaded.
    * If some elements are clearly loaded in a form but seems not set to clickable
    * i.e waitWebElementClickable would not work for them, use this method to click.
    */
    public static void clickElementForcefully(WebElement webElement) {
        if (waitWebElementVisibility(webElement))
          webElement.click();
    }

    public static List<WebElement> getWebElements(WebElement parentWebElement, String type, String accessValue) {

        switch (type) {
            case "id":
                return parentWebElement.findElements(By.id(accessValue));
            case "name":
                return parentWebElement.findElements(By.name(accessValue));
            case "class":
                return parentWebElement.findElements(By.className(accessValue));
            case "xpath":
                return parentWebElement.findElements(By.xpath(accessValue));
            case "css":
                return parentWebElement.findElements(By.cssSelector(accessValue));
            case "linkText":
                return parentWebElement.findElements(By.linkText(accessValue));
            case "partialLinkText":
                return parentWebElement.findElements(By.partialLinkText(accessValue));
            case "tagName":
                return parentWebElement.findElements(By.tagName(accessValue));
            default:
                return null;
        }
    }

    public static WebElement getWebElement(WebElement parentWebElement, String type, String accessValue) {

        switch (type) {
            case "id":
                return parentWebElement.findElement(By.id(accessValue));
            case "name":
                return parentWebElement.findElement(By.name(accessValue));
            case "class":
                return parentWebElement.findElement(By.className(accessValue));
            case "xpath":
                return parentWebElement.findElement(By.xpath(accessValue));
            case "css":
                return parentWebElement.findElement(By.cssSelector(accessValue));
            case "linkText":
                return parentWebElement.findElement(By.linkText(accessValue));
            case "partialLinkText":
                return parentWebElement.findElement(By.partialLinkText(accessValue));
            case "tagName":
                return parentWebElement.findElement(By.tagName(accessValue));
            default:
                return null;
        }
    }

    public static WebElement waitWebElementClickable(WebElement webElement) {
      WebDriverWait Wait = new WebDriverWait(d, Hooks.timeout);
      return Wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static Boolean waitWebElementVisibility(WebElement webElement) {
        WebDriverWait WaitAbitToCheckVisibility = new WebDriverWait(d, 1);
        return !WaitAbitToCheckVisibility.until(ExpectedConditions.invisibilityOf(webElement));
    }

    public static void scollToViewWebElement(WebElement webElement) {
        ((JavascriptExecutor)d).executeScript("arguments[0].scrollIntoView();", waitWebElementClickable(webElement));
    }

    public static String getTextWebElement(WebElement webElement) {
        waitWebElementClickable(webElement);
        return  webElement.getText();
    }

    public static void acceptAlert() {
        try {
            WebDriverWait Wait = new WebDriverWait(d, Hooks.timeout);
            Wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = d.switchTo().alert();
            alert.accept();
            //if alert present, accept and move on.
            d.switchTo().defaultContent();
        }
        catch (NoAlertPresentException e) {
            //do what you normally would if you didn't have the alert.
            System.out.println("Alert is NOT Displayed");
        }
    }
}
