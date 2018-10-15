package com.shopback.env;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;
import com.shopback.stepDefinitions.Hooks;

public class DriverFactory {

    private static WebDriver d = null;
    private static DesiredCapabilities capabilities = null;
    public static WebDriver CreateWebDriver()
    {
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

        d.manage().deleteAllCookies();
      	d.manage().window().maximize();
        d.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        d.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
        d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return d;
    }


}
