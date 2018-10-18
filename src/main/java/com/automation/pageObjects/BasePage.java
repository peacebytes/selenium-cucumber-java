package com.automation.pageObjects;

import com.automation.stepDefinitions.Hooks;
import com.automation.utils.SeleniumUtils;

public class BasePage {

    public static void navigateToPage(String expectedUrl) {
        SeleniumUtils.navigateToURL(expectedUrl);
        try {
            Thread.sleep(500);
        } catch (Exception e) {}
    }
}
