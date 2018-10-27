package com.automation.stepDefinitions;

import com.automation.pageObjects.*;
import cucumber.api.java.en.*;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import com.automation.utils.*;

public class MyAddressStepDefinition {

    @Then("I delete address \"([^\"]*)\"")
    public void i_delete_address(String addressToDelete) {
        for (WebElement webEle : MyAddress.addressesList) {
            List<WebElement> addressDetails = MyAddress.getAddressDetails(webEle);
            String foundAddressName = SeleniumUtils.getTextWebElement(addressDetails.get(0)).toLowerCase();
            if (foundAddressName.toLowerCase().equals(addressToDelete.toLowerCase())) {
                WebElement btnDelete = MyAddress.getDeleteButton(addressDetails.get(addressDetails.size()-1));
                SeleniumUtils.clickElement(btnDelete);
                SeleniumUtils.acceptAlert();
                break;
            }
        }
        //Verify deletion of address works as expected
        assert(!MyAddress.isAddressExisted(addressToDelete));
    }

    @Then("I update address \"([^\"]*)\"")
    public void i_updates_address(String addressToUpdated) {
        //Looking for address to be updated
        for (WebElement webEle : MyAddress.addressesList) {
            List<WebElement> addressDetails = MyAddress.getAddressDetails(webEle);
            String foundAddressName = SeleniumUtils.getTextWebElement(addressDetails.get(0)).toLowerCase();
            if (foundAddressName.toLowerCase().equals(addressToUpdated.toLowerCase())) {
                WebElement btnUpdate = MyAddress.getUpdateButton(addressDetails.get(addressDetails.size()-1));
                SeleniumUtils.clickElement(btnUpdate);
                break;
            }
        }

        //Updating
        SeleniumUtils.enterText(MyAddress.address1, MyAddress.address1.getAttribute("value")+"Updated");
        SeleniumUtils.enterText(MyAddress.city, MyAddress.city.getAttribute("value")+"Updated");
        String newAlias = MyAddress.alias.getAttribute("value")+"Updated";
        SeleniumUtils.enterText(MyAddress.alias, newAlias);
        SeleniumUtils.clickElement(MyAddress.submitAddressButton);

        //Verify updating address works as expected
        assert(MyAddress.isAddressExisted(newAlias));
    }

    @Then("I add an address from test data")
    public void i_add_address() {
        HashMap<String,String> dataAddress = TestDataJSONReader.readJsonArray("addresses").get(1);
        SeleniumUtils.clickElement(MyAddress.addAddressButton);
        SeleniumUtils.enterText(MyAddress.address1, dataAddress.get("address1"));
        SeleniumUtils.enterText(MyAddress.city, dataAddress.get("city"));
        SeleniumUtils.clickElementForcefully(MyAddress.id_state);
        for (WebElement webEle : MyAddress.state_options) {
          String foundState = SeleniumUtils.getTextWebElement(webEle).toLowerCase();
          if (foundState.toLowerCase().equals(dataAddress.get("state_option").toLowerCase())) {
              SeleniumUtils.clickElement(webEle);
              break;
          }
        }
        SeleniumUtils.enterText(MyAddress.postcode, dataAddress.get("postcode"));
        SeleniumUtils.clickElementForcefully(MyAddress.id_country);
        for (WebElement webEle : MyAddress.country_options) {
          String foundCountry = SeleniumUtils.getTextWebElement(webEle).toLowerCase();
          if (foundCountry.toLowerCase().equals(dataAddress.get("country_option").toLowerCase())) {
              SeleniumUtils.clickElement(webEle);
              break;
          }
        }
        SeleniumUtils.enterText(MyAddress.phone, dataAddress.get("phone"));
        SeleniumUtils.enterText(MyAddress.alias, dataAddress.get("alias"));
        SeleniumUtils.clickElement(MyAddress.submitAddressButton);

        //Verify adding address works as expected
        assert(MyAddress.isAddressExisted(dataAddress.get("alias")));
    }

    @Then("I add all addressses from test data")
    public void i_all_address() {
        for (HashMap<String,String> dataAddress: TestDataJSONReader.readJsonArray("addresses")){
            SeleniumUtils.clickElement(MyAddress.addAddressButton);
            SeleniumUtils.enterText(MyAddress.address1, dataAddress.get("address1"));
            SeleniumUtils.enterText(MyAddress.city, dataAddress.get("city"));
            SeleniumUtils.clickElementForcefully(MyAddress.id_state);
            for (WebElement webEle : MyAddress.state_options) {
                String foundState = SeleniumUtils.getTextWebElement(webEle).toLowerCase();
                if (foundState.toLowerCase().equals(dataAddress.get("state_option").toLowerCase())) {
                    SeleniumUtils.clickElement(webEle);
                    break;
                }
            }
            SeleniumUtils.enterText(MyAddress.postcode, dataAddress.get("postcode"));
            SeleniumUtils.clickElementForcefully(MyAddress.id_country);
            for (WebElement webEle : MyAddress.country_options) {
                String foundCountry = SeleniumUtils.getTextWebElement(webEle).toLowerCase();
                if (foundCountry.toLowerCase().equals(dataAddress.get("country_option").toLowerCase())) {
                    SeleniumUtils.clickElement(webEle);
                    break;
                }
            }
            SeleniumUtils.enterText(MyAddress.phone, dataAddress.get("phone"));
            SeleniumUtils.enterText(MyAddress.alias, dataAddress.get("alias"));
            SeleniumUtils.clickElement(MyAddress.submitAddressButton);
        }

        //Verify adding address works as expected
        for (HashMap<String,String> dataAddress: TestDataJSONReader.readJsonArray("addresses")){
            assert(MyAddress.isAddressExisted(dataAddress.get("alias")));
        }
    }
}
