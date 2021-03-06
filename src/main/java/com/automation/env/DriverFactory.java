package com.automation.env;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;
import com.automation.utils.PropertyReader;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.net.MalformedURLException;

public class DriverFactory {

    public static void createWebDriver()
    {
      switch(Global.env){
        case "bs":
          setupBrowserStack(Global.browser);
          break;
        case "grid":
          setupRemoteWebDriver(Global.browser);
          break;
        default:
          setupLocalWebDriver(Global.browser);
          break;
          
      }
      //Delete all cookies at the start of each scenario to avoid shared state between tests
      Global.driver.manage().deleteAllCookies();
      Global.driver.manage().window().maximize();
      Global.driver.manage().timeouts().pageLoadTimeout(Global.timeout, TimeUnit.SECONDS);
    }

    private static void setupBrowserStack(String browserType) {
      DesiredCapabilities capabilities = new DesiredCapabilities();
      String USERNAME = PropertyReader.readConfigProperties("USERNAME");
      String AUTOMATE_KEY = PropertyReader.readConfigProperties("AUTOMATE_KEY");
      String targetURL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
      //To make sure the 1st char is uppercase and the rest is lowercase
      capabilities.setCapability("browser", browserType);
      capabilities.setCapability("os", PropertyReader.readConfigProperties("os"));
      capabilities.setCapability("os_version", PropertyReader.readConfigProperties("os_version"));
      capabilities.setCapability("resolution", PropertyReader.readConfigProperties("resolution"));
      try {
          Global.driver = new RemoteWebDriver(new URL(targetURL), capabilities);
      } catch (MalformedURLException ex) {
          System.out.println(ex.getMessage());
      }
    }

    private static void setupLocalWebDriver(String browserType) {
      switch(browserType) {
        case "headless":
            ChromeOptions chrome_options = new ChromeOptions();
            chrome_options.addArguments("--headless");
            Global.driver = new ChromeDriver(chrome_options);
            break;
        case "chrome":
            Global.driver = new ChromeDriver();
            break;
        case "firefox":
            Global.driver = new FirefoxDriver();
            break;
      }
    }

    private static void setupRemoteWebDriver(String browserType) {
      String targetURL = "http://localhost:4444/wd/hub";
      DesiredCapabilities capabilities = new DesiredCapabilities();
      capabilities.setCapability("os", "Linux");
      switch (browserType) {
        case "chrome":
          ChromeOptions chrome_options = new ChromeOptions();
          chrome_options.addArguments("--headless");
          capabilities.setCapability(ChromeOptions.CAPABILITY, chrome_options);
          break;
        case "firefox":
          FirefoxOptions firefox_options = new FirefoxOptions();
          firefox_options.addArguments("--headless");
          capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefox_options);
          break;
        default:
          break;
      }
      try {
          Global.driver = new RemoteWebDriver(new URL(targetURL), capabilities);
      } catch (MalformedURLException ex) {
          System.out.println(ex.getMessage());
      }
    }
}
