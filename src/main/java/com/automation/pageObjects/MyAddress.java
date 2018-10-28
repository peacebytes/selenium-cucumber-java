package com.automation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.automation.utils.SeleniumUtils;

import java.util.HashMap;
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

    //Return false if no address found; otherwise, return true
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

    //Return false if no address found for delete; return true if deletion is complete
    public static Boolean deleteAddress(String addressName) {
        Boolean flag = Boolean.FALSE;
        for (WebElement webEle : addressesList) {
            List<WebElement> addressDetails = getAddressDetails(webEle);
            String foundAddressName = SeleniumUtils.getTextWebElement(addressDetails.get(0)).toLowerCase();
            if (foundAddressName.toLowerCase().equals(addressName.toLowerCase())) {
                WebElement btnDelete = getDeleteButton(addressDetails.get(addressDetails.size()-1));
                SeleniumUtils.clickElement(btnDelete);
                SeleniumUtils.acceptAlert();
                flag = Boolean.TRUE;
                break;
            }
        }
        return flag;
    }

    //Return null if no address found for update; return new alias if update is complete
    public static String updateAddress(String addressName) {
        String newAlias = null;

        //Looking for address to be updated
        for (WebElement webEle : addressesList) {
            List<WebElement> addressDetails = getAddressDetails(webEle);
            String foundAddressName = SeleniumUtils.getTextWebElement(addressDetails.get(0)).toLowerCase();
            if (foundAddressName.toLowerCase().equals(addressName.toLowerCase())) {
                WebElement btnUpdate = getUpdateButton(addressDetails.get(addressDetails.size()-1));
                SeleniumUtils.clickElement(btnUpdate);
                //Updating
                SeleniumUtils.enterText(address1, address1.getAttribute("value")+"Updated");
                SeleniumUtils.enterText(city, city.getAttribute("value")+"Updated");
                newAlias = alias.getAttribute("value")+"Updated";
                SeleniumUtils.enterText(alias, newAlias);
                SeleniumUtils.clickElement(submitAddressButton);
                break;
            }
        }
        return newAlias;
    }

    //Return false if address is already existed; return true if addition is complete
    public static Boolean addAddress(HashMap<String,String> dataAddress) {
        Boolean flag = isAddressExisted(dataAddress.get("alias"));

        if (!flag){
            SeleniumUtils.clickElement(addAddressButton);
            SeleniumUtils.enterText(address1, dataAddress.get("address1"));
            SeleniumUtils.enterText(city, dataAddress.get("city"));
            SeleniumUtils.clickElementForcefully(id_state);
            for (WebElement webEle : state_options) {
                String foundState = SeleniumUtils.getTextWebElement(webEle).toLowerCase();
                if (foundState.toLowerCase().equals(dataAddress.get("state_option").toLowerCase())) {
                    SeleniumUtils.clickElement(webEle);
                    break;
                }
            }
            SeleniumUtils.enterText(postcode, dataAddress.get("postcode"));
            SeleniumUtils.clickElementForcefully(id_country);
            for (WebElement webEle : country_options) {
                String foundCountry = SeleniumUtils.getTextWebElement(webEle).toLowerCase();
                if (foundCountry.toLowerCase().equals(dataAddress.get("country_option").toLowerCase())) {
                    SeleniumUtils.clickElement(webEle);
                    break;
                }
            }
            SeleniumUtils.enterText(phone, dataAddress.get("phone"));
            SeleniumUtils.enterText(alias, dataAddress.get("alias"));
            SeleniumUtils.clickElement(submitAddressButton);
        }
        return !flag;
    }
}
