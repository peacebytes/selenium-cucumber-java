package com.automation.stepDefinitions;

import com.automation.env.DriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import com.automation.utils.PropertyReader;
import com.google.common.base.Strings;
import org.openqa.selenium.support.PageFactory;
import com.automation.pageObjects.*;
import com.automation.utils.SeleniumUtils;
import org.json.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Hooks {

    //Global variables
    public static WebDriver driver;
    public static String email;
    public static String password;
    public static String url;
    public static String browser;
    public static String env;
    public static Integer timeout;
    public static JSONObject testDataJsonObject;

    @Before
    /**
     * This is to run when starting a scenario.
     */
    public void openBrowser() {
        //Loading Test Data
        try {
            InputStream inputStream = new FileInputStream("src/main/resources/TestData.json");
            String s = IOUtils.toString(inputStream, StandardCharsets.UTF_8.name());
            testDataJsonObject = new JSONObject(s);
        } catch(IOException e){e.printStackTrace();}


        //Loading config.properties
        email = PropertyReader.readConfigProperties("email");
        password = PropertyReader.readConfigProperties("password");
        url = PropertyReader.readConfigProperties("url");
        timeout = Integer.parseInt(PropertyReader.readConfigProperties("timeout"));

        System.out.println("url: " + url);
        System.out.println("email: " + email);
        System.out.println("password: " + password);

        //Reading passing target.browser argument from command line
        String targetBrowser = System.getProperty("target.browser");
        if (!Strings.isNullOrEmpty(targetBrowser)) {
          browser = targetBrowser;
        } else {
          browser = PropertyReader.readConfigProperties("default.browser");
        }
        System.out.println("browser: " + browser);

        //Reading passing target.env argument from command line
        String targetEnv = System.getProperty("target.env");
        if (!Strings.isNullOrEmpty(targetEnv)) {
          env = targetEnv;
        } else {
          env = PropertyReader.readConfigProperties("default.env");
        }
        System.out.println("env: " + env);

        //Set up WebDriver at the start of each scenario to avoid shared state between tests
        driver = DriverFactory.CreateWebDriver();

        //Initialize all Page Objects
        PageFactory.initElements(driver, SeleniumUtils.class);
        PageFactory.initElements(driver, MyAccount.class);
        PageFactory.initElements(driver, LoginPage.class);
        PageFactory.initElements(driver, MyAddress.class);
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
