package com.automation.stepDefinitions;

import com.automation.env.DriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.net.MalformedURLException;
import com.automation.utils.PropertyReader;

public class Hooks {

    //Global variables
    public static WebDriver driver;
    public static String email;
    public static String password;
    public static String url;
    public static String browser;


    @Before
    /**
     * Delete all cookies at the start of each scenario to avoid shared state between tests
     */
    public void openBrowser() throws MalformedURLException {
        //Loading config.properties
        email = PropertyReader.readConfigProperties("email");
        password = PropertyReader.readConfigProperties("password");
        url = PropertyReader.readConfigProperties("url");
        browser = PropertyReader.readConfigProperties("browser");

        System.out.println("url: " + url);
        System.out.println("email: " + email);
        System.out.println("password: " + password);
        System.out.println("browser: " + browser);

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
//            byte[] screenshot = getScreenshotAs(OutputType.BYTES);
                byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }

        }
        driver.quit();

    }
}
