package com.automation.stepDefinitions;

import com.automation.env.DriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.support.PageFactory;
import com.automation.pageObjects.*;
import com.automation.env.Global;

public class Hooks extends Global {

    @Before
    /**
     * This is to run when starting a scenario.
     */
    public void openBrowser() {
        //Loading Test Data
        loadJsonData();

        //Loading config.properties
        loadProperties();

        //Reading passing arguments from command line
        parseCommandLineArgs();

        //Set up WebDriver at the start of each scenario to avoid shared state between tests
        DriverFactory.createWebDriver();

        //Initialize all Page Objects
        PageFactory.initElements(driver, MyAccount.class);
        PageFactory.initElements(driver, LoginPage.class);
        PageFactory.initElements(driver, MyAddress.class);

        //Load UAT
        driver.get(url);
    }

    @After
    public void closeBrowser(Scenario scenario) {
        try {
            driver.close();
          Thread.sleep(3000);
            driver.quit();
        } catch (Exception e) {}
    }
}
