package com.automation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import java.util.List;

public class MyAddress extends BasePage {

    public MyAddress(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath="//a[@title='Add an address']")
    public static WebElement addAddressButton;

    @FindBy(css="div.address")
    public static List<WebElement> addressesList;

    public static List<WebElement> getAddressDetails(WebElement parentWebElement) {
        return parentWebElement.findElements(By.cssSelector("ul > li"));
    }

    public static WebElement getUpdateButton(WebElement parentWebElement) {
        return parentWebElement.findElement(By.xpath("//a[@title='Update']"));
    }

    public static WebElement getDeleteButton(WebElement parentWebElement) {
        return parentWebElement.findElement(By.xpath("//a[@title='Delete']"));
    }
}
