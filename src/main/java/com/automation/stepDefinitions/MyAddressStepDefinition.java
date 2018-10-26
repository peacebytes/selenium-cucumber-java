package com.automation.stepDefinitions;

import static org.testng.AssertJUnit.*;
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
}
