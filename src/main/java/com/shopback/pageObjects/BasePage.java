package com.shopback.pageObjects;

import com.shopback.stepDefinitions.Hooks;
import com.shopback.utils.SeleniumUtils;

public class BasePage {

    public static void navigateToLoginPage() {
        SeleniumUtils.navigateToURL(Hooks.url);
        try {
            Thread.sleep(500);
        } catch (Exception e) {}
    }
}
