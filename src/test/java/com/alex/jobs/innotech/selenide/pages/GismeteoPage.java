package com.alex.jobs.innotech.selenide.pages;

import com.alex.jobs.innotech.selenide.pages.locators.GismeteoLocators;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GismeteoPage {

    @Step // sendKeys is used because Gismeteo search tries to find result by typing
    public GismeteoPage sendkeysToSearchInput(String value) {
        $(GismeteoLocators.searchInputField()).sendKeys(value);
        return this;
    }

    @Step
    public GismeteoPage clickFirstTip() {
        $$(GismeteoLocators.searchTips()).get(0).click();
        return this;
    }

    @Step
    public GismeteoPage waitForFistTipWithText(String _text) {
        $$(GismeteoLocators.searchTips()).get(0).shouldHave(text(_text), Duration.ofSeconds(3));
        return this;
    }

    @Step
    public GismeteoPage checkCityTitleTextIs(String text) {
        $(GismeteoLocators.cityTitleText()).shouldHave(text(text));
        return this;
    }
}
