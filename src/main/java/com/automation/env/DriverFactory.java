package com.automation.env;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;
import com.automation.stepDefinitions.Hooks;
import com.automation.utils.PropertyReader;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.net.MalformedURLException;

public class DriverFactory {

    private static WebDriver d = null;

    public static WebDriver CreateWebDriver()
    {
      DesiredCapabilities capabilities = new DesiredCapabilities();
      String targetURL = new String();
      switch(Hooks.env){
        case "bs":
          String USERNAME = PropertyReader.readConfigProperties("USERNAME");
          String AUTOMATE_KEY = PropertyReader.readConfigProperties("AUTOMATE_KEY");
          targetURL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
          //To make sure the 1st char is uppercase and the rest is lowercase
          capabilities.setCapability("browser", Hooks.browser);
          capabilities.setCapability("os", PropertyReader.readConfigProperties("os"));
          capabilities.setCapability("os_version", PropertyReader.readConfigProperties("os_version"));
          capabilities.setCapability("resolution", PropertyReader.readConfigProperties("resolution"));
          try{
            d = new RemoteWebDriver(new URL(targetURL), capabilities);
          } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
          }
          break;
        case "grid":
          targetURL = "http://localhost:4444/wd/hub";
          capabilities.setCapability("os", "Linux");
          switch (Hooks.browser) {
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
          try{
            d = new RemoteWebDriver(new URL(targetURL), capabilities);
          } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
          }
          break;
        default:
          switch(Hooks.browser) {
            case "headless":
                ChromeOptions chrome_options = new ChromeOptions();
                chrome_options.addArguments("--headless");
                d = new ChromeDriver(chrome_options);
                break;
            case "chrome":
                d = new ChromeDriver();
                break;
            case "firefox":
                d = new FirefoxDriver();
                break;
            default:
                d = new ChromeDriver();
          }
      }
      //Delete all cookies at the start of each scenario to avoid shared state between tests
      d.manage().deleteAllCookies();
      d.manage().window().maximize();
      d.manage().timeouts().pageLoadTimeout(Hooks.timeout, TimeUnit.SECONDS);
      return d;
    }
}
