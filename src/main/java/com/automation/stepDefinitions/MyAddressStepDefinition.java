package com.automation.stepDefinitions;

import com.automation.pageObjects.MyAddress;
import com.automation.utils.SeleniumUtils;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyAddressStepDefinition {

    @Then("I view all addresses")
    public void i_view_all_addresses() {
        PageFactory.initElements(Hooks.driver, MyAddress.class);

        for (WebElement webEle : MyAddress.addressesList) {
            for (WebElement detailLine : MyAddress.getAddressDetails(webEle)) {
                System.out.println(SeleniumUtils.getTextWebElement(detailLine).toLowerCase());
            }
            System.out.println("------");
        }
    }

    @Then("I delete address \"([^\"]*)\"")
    public void i_delete_address(String addressToDelete) {
        PageFactory.initElements(Hooks.driver, MyAddress.class);

        for (WebElement webEle : MyAddress.addressesList) {
            List<WebElement> addressDetails = MyAddress.getAddressDetails(webEle);
            String foundAddressName = SeleniumUtils.getTextWebElement(addressDetails.get(0)).toLowerCase();
            System.out.println(foundAddressName);
            if (foundAddressName.equals(addressToDelete.toLowerCase()))
                SeleniumUtils.clickElement(addressDetails.get(0));
        }
    }
}
