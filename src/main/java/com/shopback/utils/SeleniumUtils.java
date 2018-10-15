package com.shopback.utils;

import com.shopback.env.DriverFactory;
import com.shopback.stepDefinitions.Hooks;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {

    private static WebDriver d = Hooks.driver;

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

    public static void selectDropDownValue(String type, String accessName)
    {
        WebElement dropdownMenu = getWebElement(type, accessName );
        dropdownMenu.click();
    }

    public static WebElement getWebElement(String type, String accessName) {

        switch (type) {
            case "id":
                return d.findElement(By.id(accessName));
            case "name":
                return d.findElement(By.name(accessName));
            case "class":
                return d.findElement(By.className(accessName));
            case "xpath":
                return d.findElement(By.xpath(accessName));
            case "css":
                return d.findElement(By.cssSelector(accessName));
            case "linkText":
                return d.findElement(By.linkText(accessName));
            case "partialLinkText":
                return d.findElement(By.partialLinkText(accessName));
            case "tagName":
                return d.findElement(By.tagName(accessName));
            default:
                return null;
        }
    }

    public static WebElement waitWebElement(WebElement webElement)
    {
        WebDriverWait Wait = new WebDriverWait(d, 120);
        return Wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
