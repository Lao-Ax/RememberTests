package com.alex.jobs.innotech.selenide.pages.locators;

import org.openqa.selenium.By;

public class GismeteoLocators {

    public static By searchInputField() {
        return By.cssSelector("input[type]");
    }

    public static By searchTips() {
        return By.cssSelector("a.search-item");
    }

    public static By cityTitleText() {
        return By.cssSelector("div.page-title");
    }
}
