package com.alex.jobs.innotech.selenide.pages;

import com.alex.jobs.innotech.selenide.pages.locators.GismeteoLocators;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GismeteoPage {

    @Step
    public GismeteoPage setValueForSearchInput(String value) {
        $(GismeteoLocators.searchInputField()).sendKeys(value);
        return this;
    }

    @Step
    public GismeteoPage clickFirstTip() {
        $$(GismeteoLocators.searchTips()).get(0).click();
        return this;
    }

    @Step
    public GismeteoPage checkCityTitleText(String text) {
        $(GismeteoLocators.cityTitleText()).shouldHave(text(text));
        return this;
    }
}
