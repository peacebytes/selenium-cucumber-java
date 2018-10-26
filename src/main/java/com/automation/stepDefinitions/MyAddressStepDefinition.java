package com.automation.stepDefinitions;

import com.automation.pageObjects.*;
import cucumber.api.java.en.*;
import org.openqa.selenium.WebElement;
import java.util.List;
import com.automation.utils.SeleniumUtils;

public class MyAddressStepDefinition {

    @Then("I view all addresses")
    public void i_view_all_addresses() {
        for (WebElement webEle : MyAddress.addressesList) {
            for (WebElement detailLine : MyAddress.getAddressDetails(webEle)) {
                System.out.println(SeleniumUtils.getTextWebElement(detailLine).toLowerCase());
            }
            System.out.println("------");
        }
    }

    @Then("I delete address \"([^\"]*)\"")
    public void i_delete_address(String addressToDelete) {
        for (WebElement webEle : MyAddress.addressesList) {
            List<WebElement> addressDetails = MyAddress.getAddressDetails(webEle);
            String foundAddressName = SeleniumUtils.getTextWebElement(addressDetails.get(0)).toLowerCase();
            System.out.println(foundAddressName);
            if (foundAddressName.toLowerCase().equals(addressToDelete.toLowerCase())) {
                SeleniumUtils.clickElement(MyAddress.getDeleteButton(webEle));
                SeleniumUtils.acceptAlert();
                break;
            }
        }
    }

    @Then("I add address \"([^\"]*)\"")
    public void i_add_address(String addressToAdd) {
        SeleniumUtils.clickElement(MyAddress.addAddressButton);
        SeleniumUtils.enterText(MyAddress.address1, "Test4 Address");
        SeleniumUtils.enterText(MyAddress.city, "Test4 City");
        SeleniumUtils.clickElementForcefully(MyAddress.id_state);
        for (WebElement webEle : MyAddress.state_options) {
          String foundState = SeleniumUtils.getTextWebElement(webEle).toLowerCase();
          if (foundState.toLowerCase().equals("Washington".toLowerCase())) {
              SeleniumUtils.clickElement(webEle);
              break;
          }
        }
        SeleniumUtils.enterText(MyAddress.postcode, "02123");
        SeleniumUtils.clickElementForcefully(MyAddress.id_country);
        for (WebElement webEle : MyAddress.country_options) {
          String foundCountry = SeleniumUtils.getTextWebElement(webEle).toLowerCase();
          if (foundCountry.toLowerCase().equals("United States".toLowerCase())) {
              SeleniumUtils.clickElement(webEle);
              break;
          }
        }
        SeleniumUtils.enterText(MyAddress.phone, "0212346789");
        SeleniumUtils.enterText(MyAddress.alias, "Test4");
        SeleniumUtils.clickElement(MyAddress.submitAddressButton);

        //Verify adding address works as expected
        for (WebElement webEle : MyAddress.addressesList) {
            for (WebElement detailLine : MyAddress.getAddressDetails(webEle)) {
                System.out.println(SeleniumUtils.getTextWebElement(detailLine).toLowerCase());
            }
            System.out.println("------");
        }
    }
}
