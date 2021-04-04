package com.automation.stepDefinitions;

import com.automation.env.DriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.support.PageFactory;
import com.automation.pageObjects.*;
import com.automation.env.Global;

public class Hooks {

    @Before
    /**
     * This is to run when starting a scenario.
     */
    public void openBrowser() {
        //Loading Test Data
        Global.loadJsonData();

        //Loading config.properties
        Global.loadProperties();

        //Reading passing arguments from command line
        Global.parseCommandLineArgs();

        //Set up WebDriver at the start of each scenario to avoid shared state between tests
        DriverFactory.createWebDriver();

        //Initialize all Page Objects
        PageFactory.initElements(Global.driver, MyAccount.class);
        PageFactory.initElements(Global.driver, LoginPage.class);
        PageFactory.initElements(Global.driver, MyAddress.class);

        //Load UAT
        Global.driver.get(Global.url);
    }

    @After
    public void closeBrowser(Scenario scenario) {
        try {
            Global.driver.close();
          Thread.sleep(3000);
            Global.driver.quit();
        } catch (Exception e) {}
    }
}
