package com.automation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.automation.utils.SeleniumUtils;
import java.util.List;

public class MyAddress extends BasePage {

    public MyAddress(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath="//a[@title='Add an address']")
    public static WebElement addAddressButton;

    @FindBy(css="div.address")
    public static List<WebElement> addressesList;

    @FindBy(id="address1")
    public static WebElement address1;

    @FindBy(id="city")
    public static WebElement city;

    @FindBy(css="#id_state")
    public static WebElement id_state;

    @FindBy(xpath="//*[@id='id_state']/option")
    public static List<WebElement> state_options;

    @FindBy(id="postcode")
    public static WebElement postcode;

    @FindBy(id="id_country")
    public static WebElement id_country;

    @FindBy(xpath="//*[@id='id_country']/option")
    public static List<WebElement> country_options;

    @FindBy(id="phone")
    public static WebElement phone;

    @FindBy(id="alias")
    public static WebElement alias;

    @FindBy(id="submitAddress")
    public static WebElement submitAddressButton;

    public static List<WebElement> getAddressDetails(WebElement parentWebElement) {
        return SeleniumUtils.getWebElements(parentWebElement, "css","ul > li");
    }

    public static WebElement getUpdateButton(WebElement parentWebElement) {
        return SeleniumUtils.getWebElement(parentWebElement, "xpath","a[@title='Update']");
    }

    public static WebElement getDeleteButton(WebElement parentWebElement) {
        return SeleniumUtils.getWebElement(parentWebElement, "xpath","a[@title='Delete']");
    }

    public static Boolean isAddressExisted(String addressName) {
        Boolean flag = Boolean.FALSE;
        for (WebElement webEle : addressesList) {
            String s = SeleniumUtils.getTextWebElement(getAddressDetails(webEle).get(0)).toLowerCase();
            if (s.equals(addressName.toLowerCase())) {
                flag = Boolean.TRUE;
            }
        }
        return flag;
    }
}
