package com.automation.utils;

import com.automation.stepDefinitions.Hooks;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class SeleniumUtils {

    public static WebDriver d = Hooks.driver;

    public static void navigateToURL(String url)
    {
        d.get(url);
    }

    public static void enterText(WebElement webElement, String textValue) {
        waitWebElement(webElement).sendKeys(textValue);
    }

    public static void clickElement(WebElement webElement)
    {
        waitWebElement(webElement).click();
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

    public static WebElement waitWebElement(WebElement webElement)
    {
        WebDriverWait Wait = new WebDriverWait(d, 1200);
        ((JavascriptExecutor)d).executeScript("arguments[0].scrollIntoView();", webElement);
        return Wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static String getTextWebElement(WebElement webElement)
    {
        waitWebElement(webElement);
        return  webElement.getText();
    }

    public static void acceptAlert() {
        try {
            d.switchTo().alert().accept();
            d.switchTo().defaultContent();
        } catch (WebDriverException ex) {
        }
    }

//    protected void dismissAlert() {
//        waitFor(new BooleanCondition() {
//            public Boolean apply(WebDriver webDriver) {
//                try {
//                    webDriver.switchTo().alert().dismiss();
//                    return true;
//                } catch (WebDriverException ex) {
//                    return false;
//                }
//            }
//            public String describeFailure() {
//                return COULD_NOT_LOCATE_OR_ACCEPT_ALERT_BOX;
//            }
//        });
//    }
}
