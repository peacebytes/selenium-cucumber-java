package com.automation.pageObjects;

import com.automation.stepDefinitions.Hooks;
import com.automation.utils.SeleniumUtils;

public class BasePage {

    public static void navigateToLoginPage() {
        SeleniumUtils.navigateToURL(Hooks.url);
        try {
            Thread.sleep(500);
        } catch (Exception e) {}
    }
}
