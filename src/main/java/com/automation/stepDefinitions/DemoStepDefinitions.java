package com.automation.stepDefinitions;

import cucumber.api.java.en.*;

public class DemoStepDefinitions {

    @Given("I have logged into Demo application")
    public void loginDemo() {
        System.out.println("steps: I logged in Demo application");
    }

    @Then("I log out Demo application")
    public void i_log_out_Demo() {
        System.out.println("steps: I log out Demo application");
    }
}
