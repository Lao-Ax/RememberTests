package com.alex.jobs.innotech.selenide.pages;

import com.alex.jobs.innotech.selenide.pages.locators.YaLocators;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class YaPage {

    @Step
    public YaPage open() {
        Selenide.open("https://ya.ru/");
        return this;
    }

    @Step
    public YaPage setValueForSearchInput(String value) {
        $(YaLocators.searchInput()).setValue("gismeteo");
        return this;
    }

    @Step
    public YaPage clickSearchBtn() {
        $(YaLocators.searchSubmitBtn()).click();
        return this;
    }

    @Step
    public GismeteoPage clickFirstTip() {
        $$(YaLocators.searchTips()).get(0).click();
        switchTo().window(1);
        return new GismeteoPage();
    }
}
