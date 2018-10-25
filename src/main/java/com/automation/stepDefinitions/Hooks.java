package com.automation.stepDefinitions;

import com.automation.env.DriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import com.automation.utils.PropertyReader;
import com.google.common.base.Strings;

public class Hooks {

    //Global variables
    public static WebDriver driver;
    public static String email;
    public static String password;
    public static String url;
    public static String browser;
    public static String env;

    //Private variables
    private static String targetBrowser;
    private static String targetEnv;


    @Before
    /**
     * Delete all cookies at the start of each scenario to avoid shared state between tests
     */
    public void openBrowser() {
        //Loading config.properties
        email = PropertyReader.readConfigProperties("email");
        password = PropertyReader.readConfigProperties("password");
        url = PropertyReader.readConfigProperties("url");

        System.out.println("url: " + url);
        System.out.println("email: " + email);
        System.out.println("password: " + password);

        //Reading passing target.browser argument from command line
        targetBrowser = System.getProperty("target.browser");
        if (!Strings.isNullOrEmpty(targetBrowser)) {
          browser = targetBrowser;
        } else {
          browser = PropertyReader.readConfigProperties("default.browser");
        }
        System.out.println("browser: " + browser);

        //Reading passing target.env argument from command line
        targetEnv = System.getProperty("target.env");
        if (!Strings.isNullOrEmpty(targetEnv)) {
          env = targetEnv;
        } else {
          env = PropertyReader.readConfigProperties("default.env");
        }
        System.out.println("env: " + env);

        //Set up WebDriver
        driver = DriverFactory.CreateWebDriver();
    }

    @After
    /**
     * Embed a screenshot in test report if test is marked as failed
     */
    public void embedScreenshot(Scenario scenario) {

        if(scenario.isFailed()) {
            try {
                scenario.write("Current Page URL is " + driver.getCurrentUrl());
                byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }
        }
        driver.quit();
    }
}
