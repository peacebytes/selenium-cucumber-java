package com.automation.stepDefinitions;

import com.automation.pageObjects.*;
import com.google.common.base.Strings;
import cucumber.api.java.en.*;

import java.util.HashMap;
import com.automation.utils.*;

public class MyAddressStepDefinition {

    @Then("I delete address \"([^\"]*)\"")
    public void i_delete_address(String addressToDelete) {
        if (MyAddress.deleteAddress(addressToDelete)) {
            //Verify deletion of address works as expected
            assert (!MyAddress.isAddressExisted(addressToDelete));
        }
    }

    @Then("I update address \"([^\"]*)\"")
    public void i_updates_address(String addressToUpdated) {
        String newAlias = MyAddress.updateAddress(addressToUpdated);
        if (!Strings.isNullOrEmpty(newAlias)){
            //Verify updating address works as expected
            assert(MyAddress.isAddressExisted(newAlias));
        }
    }

    @Then("I add an address from test data")
    public void i_add_an_address() {
        HashMap<String,String> dataAddress = TestDataJSONReader.readJsonObject("address");
        if (MyAddress.addAddress(dataAddress)){
            //Verify adding address works as expected
            assert(MyAddress.isAddressExisted(dataAddress.get("alias")));
        }
    }

    @Then("I add all addressses from test data")
    public void i_add_all_address() {
        for (HashMap<String,String> dataAddress: TestDataJSONReader.readJsonArray("addresses")){
            if (MyAddress.addAddress(dataAddress)){
                //Verify adding address works as expected
                assert(MyAddress.isAddressExisted(dataAddress.get("alias")));
            }
        }
    }
}
